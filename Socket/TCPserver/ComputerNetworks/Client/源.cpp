#include <stdio.h>
#include <WINSOCK2.H>
#include <STDIO.H>
#include"FileHelper.h"
#pragma  comment(lib,"ws2_32.lib")

void selectFile()
{

}

int main(int argc, char* argv[])
{
	WORD sockVersion = MAKEWORD(2,2);//版本号
	WSADATA data;    //用来保存WSAStartup调用后返回的windows Sockets数据
	FileHelper fh;
	if(WSAStartup(sockVersion, &data) != 0)
	{
		return 0;
	}

	SOCKET sclient = socket(AF_INET, SOCK_STREAM, IPPROTO_TCP);
	if(sclient == INVALID_SOCKET)
	{
		printf("invalid socket !");
		return 0;
	}

	sockaddr_in serAddr;
	serAddr.sin_family = AF_INET;
	serAddr.sin_port = htons(8888);
	serAddr.sin_addr.S_un.S_addr = inet_addr("127.0.0.1"); 
	if (connect(sclient, (sockaddr *)&serAddr, sizeof(serAddr)) == SOCKET_ERROR)
	{
		printf("connect error !");
		closesocket(sclient);
		return 0;
	}
	while (true)
	{
		FILE *f=fh.selectfile();
		char sendData[BUFSIZ];
		int nCount;
		while ((nCount=fread(sendData,1,BUFSIZ,f))>0)
		{
			printf("%d\n",nCount);
			printf(sendData);
			send(sclient, sendData, nCount, 0);
			char recData[255];
			int ret = recv(sclient, recData, 255, 0);
			if(ret > 0)
			{
				recData[ret] = 0x00;
				printf(recData);
			}
		}
		fclose(f);

	}

	closesocket(sclient);
	WSACleanup();
	return 0;
}