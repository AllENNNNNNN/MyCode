#include<stdio.h>
#include <WINSOCK2.H>
#include <STDIO.H>

#pragma  comment(lib,"ws2_32.lib")

class FileHelper
{
private:
	FILE *f;
public:
	FILE * selectfile()
	{
		printf("请输入要传送的文件名\n");
		char name[100];
		scanf("%s",name);
		getchar();
		
		if (f=fopen(name,"r"))
		{
			printf("文件打开成功\n");
			return f;
		}
		else
		{
			printf("文件不存在，请重新输入\n");
			return selectfile();
		}
	}

	FILE * createFile(char *name)
	{
		if (f=fopen(name,"w"))
		{
			printf("文件%s创建成功\n");
		}
		else
		{
			printf("文件创建失败\n");
		}
		return f;
	}

	
};