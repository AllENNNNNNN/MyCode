#include <stdio.h>
#include <stdio.h>
#include <winsock2.h>
#include "FileHelper.h"
#pragma comment(lib,"ws2_32.lib")

int main(int argc, char* argv[])
{
	//初始化WSA
	WORD sockVersion = MAKEWORD(2,2);
	WSADATA wsaData;
	FileHelper fh;
	if(WSAStartup(sockVersion, &wsaData)!=0)
	{
		return 0;
	}

	//创建套接字
	SOCKET slisten = socket(AF_INET, SOCK_STREAM, IPPROTO_TCP);
	if(slisten == INVALID_SOCKET)
	{
		printf("socket error !");
		return 0;
	}

	//绑定IP和端口
	sockaddr_in sin;
	sin.sin_family = AF_INET;
	sin.sin_port = htons(8888);
	sin.sin_addr.S_un.S_addr = INADDR_ANY; 
	if(bind(slisten, (LPSOCKADDR)&sin, sizeof(sin)) == SOCKET_ERROR)
	{
		printf("bind error !");
	}

	//开始监听
	if(listen(slisten, 5) == SOCKET_ERROR)
	{
		printf("listen error !");
		return 0;
	}

	//循环接收数据
	SOCKET sClient;
	sockaddr_in remoteAddr;
	int nAddrlen = sizeof(remoteAddr);
	char revData[BUFSIZ]; 
	while (true)
	{
		printf("等待连接...\n");
		sClient = accept(slisten, (SOCKADDR *)&remoteAddr, &nAddrlen);
		if(sClient == INVALID_SOCKET)
		{
			printf("accept error !");
			continue;
		}
		printf("接受到一个连接：%s \r\n", inet_ntoa(remoteAddr.sin_addr));
		FILE *f=fh.createFile(inet_ntoa(remoteAddr.sin_addr));
		int ret=0;
		while ((ret=recv(sClient, revData, BUFSIZ, 0))>0)
		{
			printf("%d\n",ret);
			printf(revData);
			fwrite(revData,1,ret,f);
			//revData[ret] = 0x00;
			//printf(revData);
			//发送数据
			char * sendData = "你好，TCP客户端！\n";
			send(sClient, sendData, strlen(sendData), 0);
		}
		fclose(f);




		closesocket(sClient);
	}

	closesocket(slisten);
	WSACleanup();
	return 0;
}