#pragma once
#include<netinet/ip.h>
#include<sys/socket.h>
#include<stdlib.h>
#include<stdio.h>
#include<netinet/udp.h>
#include<unistd.h>
class RawSocketSender
{
public:
	RawSocketSender();
	~RawSocketSender();
	bool sendPocket(__uint8_t * buffer,unsigned int length);
private:
	int socketID;
};
