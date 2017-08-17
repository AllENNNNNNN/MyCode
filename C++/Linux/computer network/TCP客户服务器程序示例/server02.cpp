/* TCP�������˳���*/


#include<unistd.h>//for read write
#include<netinet/in.h> //for sockaddr_in
#include<arpa/inet.h> //for inet_pton
#include<stdio.h>  //for stdion stdout
#include<errno.h>  //for  errno
#include<sys/wait.h> //for wait
//#include<bits/sigaction.h> //for sigaction //�������˻ᷢ����ͻ
#include<signal.h> //for signal
#include<string.h>
#include<iostream>

using namespace std;
#define MAXLINE 100
typedef void sigfun(int);

int SERVER_PORT = 21;
int LISTENQ = 20;

void str_echo(int sockfd)
{
	ssize_t n;
	char buf[MAXLINE];

again:
	while ((n = read(sockfd, buf, MAXLINE)) > 0)
	{
		write(sockfd, buf, n);

		if (n < 0 && errno == EINTR)
			goto again;
		else if (n < 0)
		{
			cout << "error" << endl;
		}
	}
}

sigfun * signal(int signo, sigfun * func)
{

	struct sigaction act, oact;
	act.sa_handler = func;
	sigemptyset(&act.sa_mask);//mask��Ϊ�ռ�����ζ���ڸ��źŴ����������ڼ䣬������������ź�
	act.sa_flags = 0;
	/*
	��������ĳ����ϵͳ���õ�һ�����̲���ĳ���ź�����Ӧ�źŴ���������ʱ
	��ϵͳ���ÿ��ܷ���һ��EINTR����
	��Щ�ں��Զ�����ĳЩ���жϵ�ϵͳ���ã�����Ϊ�˷�����ֲ�������Ǳ�д�����źŵĳ���ʱ��Ҫ����ϵͳ���÷���EINTR��������׼��


	*/
	if (signo == SIGALRM)
	{
#ifdef SA_INTERRUPT
		act.sa_flags |= SA_INTERRUPT;
#endif // SA_INTERRUPT

	}
	else
	{
#ifdef SA_RESTART
		act.sa_flags |= SA_RESTART;
#endif // SA_RESTART
	}
	if (sigaction(signo, &act, &oact) < 0)
		return (SIG_ERR);
	return (oact.sa_handler);

}
void sig_chld(int signo)
{
	pid_t pid;
	int stat;
	/*
	pid = wait(&stat);      //�������̻�ռ���ں˿ռ�
	printf("child %d terminated\n", pid);

	ʹ��wait�������Է�ֹ���ֽ������̡���Ϊ�źŴ�������ͬһ���ź�ֻ����һ�Σ���ΪUnix�ź�һ���ǲ��Ŷӵġ�
	�����ǽ���ǲ�ȷ���ġ�
	*/

	while ((pid = waitpid(-1, &stat, WNOHANG)) > 0)
	{
		printf("child %d terminated\n", pid);
	}
	/*
	��ȷ����Ӧ������waitpid����ָ��WHOHANGѡ���֪��ӵ����δ��ֹ���ӽ���������ʱ��Ҫ����
	*/
	return;
}



int main()
{
	int listenfd, connfd;
	pid_t childpid;
	socklen_t client;
	sockaddr_in cliaddr, servaddr;
	listenfd = socket(AF_INET, SOCK_STREAM, 0);
	bzero(&servaddr, sizeof(servaddr));
	servaddr.sin_family = AF_INET;
	servaddr.sin_addr.s_addr = htonl(INADDR_ANY);
	servaddr.sin_port = htons(SERVER_PORT);
	bind(listenfd, (sockaddr *)&servaddr, sizeof(servaddr));
	listen(listenfd, LISTENQ);
	signal(SIGCHLD, sig_chld);
	while (true)
	{
		client = sizeof(cliaddr);
		connfd = accept(listenfd, (sockaddr *)&servaddr, &client);
		if ((childpid = fork()) == 0)
		{
			close(listenfd);
			str_echo(connfd);
			//      cout<<"child has been closed!"<<endl;
			exit(0);
			//�ӽ��̽�������Ȼ���ڽ���״̬��ռ��ϵͳ��Դ
		}
		close(connfd);//������رգ����һֱ����close_wait״̬
	}
	return 0;
}
