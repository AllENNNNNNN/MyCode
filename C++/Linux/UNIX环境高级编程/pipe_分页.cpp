
//pipe hellowordl
//gcc 4.8  centos 7.3.1611
/*
ÿ��һҳ����ʾ�Ѳ��������
*/
#include<unistd.h>//for pipe
#include<string.h>	/*for strlen*/
#include<sys/wait.h>	/*for waitpid*/

#include<iostream>



#define DEF_PAGER  "/bin/more"  /*Ĭ�ϵķ�ҳ����*/
#define MAXLINE 20
using namespace std;
int  main(int argc, char *argv[])
{
	int n;
	int fd[2];

	pid_t pid;
	char *pager, *argv0;
	char line[MAXLINE];
	FILE * fp;

	if (argc != 2)
	{
		cout << "usage:a.out <pathname>" << endl;
		exit(-1);
	}
	if ((fp = fopen(argv[1], "r")) == NULL)
	{
		cout << "can't open " << argv[1] << endl;
		exit(-1);
	}

	if (pipe(fd) < 0)
	{
		cout << "pipe error" << endl;
		exit(-1);
	}

	if ((pid = fork()) < 0)
	{
		cout << "fork error" << endl;
		exit(-1);
	}
	if (pid > 0)
	{
		close(fd[0]);
		while (fgets(line, MAXLINE, fp) != NULL)/*���ļ��ж�ȡ�ַ���ÿ��һ�У�ÿ������maxline-1���ַ�*/
		{
			n = strlen(line);
			if (write(fd[1], line, n) != n)
			{
				cout << "write error" << endl;
			}

		}

		if (ferror(fp))//��ͬһ���ļ���ÿһ�ε�����������������������һ���µ�ferrorֵ
		{
			cout << "fgets error" << endl;
		}

		close(fd[1]);
		if (waitpid(pid, NULL, 0) < 0)/*��ʱֹͣ��ǰ���̣��ȴ���Ľ���*/
		{
			cout << "waitpid error" << endl;
		}
		exit(0);
	}
	else   /*child*/
	{
		close(fd[1]);
		if (fd[0] != STDIN_FILENO)/* STDIN_FILENO��һ�����ļ��������Ҫ����ϵͳ���ã��Ǳ�׼�������������*/
		{
			if (dup2(fd[0], STDIN_FILENO) != STDIN_FILENO)/* dup2 �����ļ�������*/
			{
				cout << "dup2 error to stdin" << endl;
			}
			close(fd[0]);	/*don't need this after dup2*/
		}

		if ((pager = getenv("PAGER")) == NULL)/*���������е�ֵ*/
		{
			pager = DEF_PAGER;
		}

		if ((argv0 == strrchr(pager, '/')) != NULL)/*�����ַ���ָ���ַ����д����濪
												   ʼ�����һ�γ��ֵ�λ�ã�����ɹ���
												   ���ظ��ַ��Լ��������ַ������ʧ�ܣ��򷵻� NULL*/
		{
			argv0++;
		}
		else
		{
			argv0 = pager;
		}

		if (execl(pager, argv0, (char *)0) < 0)
		{
			cout << "execl error" << endl;
		}
		exit(0);
	}
	exit(0);

}