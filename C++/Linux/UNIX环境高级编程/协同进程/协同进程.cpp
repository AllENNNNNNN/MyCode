/*��һ�����˳���Ȳ���ĳ�����˳�������룬�ֶ�ȡ�ù��˳�������ʱ�����ͱ����Эͬ����*/


/*
�����̶�ȡ��׼���룬������׼�������뵽fd1[1]��
�ӽ��̽�fd1[0]��Ϊ��׼���룬������׼���봫�ݵ�add2������
add2����������������׼���
�ӽ��̽�fd2[1]��Ϊ��׼�����add2�����Ľ�������fd2[1]
�����̴�fd2[0]�ж�ȡ��������������̨
*/


#include<unistd.h>
#include<stdio.h>
#include<signal.h>
#include<string.h>
#include<iostream>

using namespace std;
#define MAXLINE 5

/*��������ڵȴ������ʱ��ɱ����add2Эͬ���̣�Ȼ������������������ô�����û��
�����̵Ĺܵ�����д����ʱ��������źŴ������*/
static void sig_pipe(int)/* our singnal handler*/
{
	printf("SIGPIPE caught\n");
	exit(1);
}

int main()
{
	int n, fd1[2], fd2[2];
	pid_t pid;
	char line[MAXLINE];

	if (signal(SIGPIPE,sig_pipe)==SIG_ERR)
	{
		cout << "signal error" << endl;
	}
	if (pipe(fd1) < 0 || pipe(fd2) < 0)
		cout << "pipe error" << endl;

	if ((pid = fork()) < 0)
	{
		cout << "fork error" << endl;
	}
	if (pid > 0)
	{
		close(fd1[0]);
		close(fd2[1]);

		while (fgets(line,MAXLINE,stdin)!=NULL)
		{
			n = strlen(line);
			if (write(fd1[1], line, n) != n)
			{
				cout << "write error" << endl;
			}
			if ((n = read(fd2[0], line, MAXLINE))<0)
			{
				cout << "read error from pipe" << endl;
			}
			if (n == 0)
			{
				cout << "child close pipe" << endl;
			}
			line[n] = 0;
			if (fputs(line, stdout) == EOF)
			{
				cout << "fputs error" << endl;
			}
		}

	}
	else
	{
		close(fd1[1]);
		close(fd2[0]);

		if (fd1[0] != STDIN_FILENO)
		{
			if (dup2(fd1[0], STDIN_FILENO) != STDIN_FILENO)
			{
				cout << "dup2 error" << endl;
			}
			close(fd1[0]);
		}

		if (fd2[1] != STDOUT_FILENO)
		{
			if (dup2(fd2[1], STDOUT_FILENO) != STDOUT_FILENO)
			{
				cout << "dup2 error" << endl;
			}
		}
		if (execl("/root/add2", "add2", (char *)0) < 0)
			cout << "execl error" << endl;
	}
}

