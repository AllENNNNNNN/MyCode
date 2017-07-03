#pragma once
#include<memory.h>
#include<netinet/udp.h>
#include<netinet/in.h>
#include<iostream>
#include<exception>
#include"DNS.h"
struct UDPPocket
{
	__uint8_t * UDPdata;
	unsigned int length;

};

//UDPµÄÎ±Í·²¿
struct UDP_PSD_Header
{
	u_int32_t src;
	u_int32_t des;
	u_int8_t  mbz;
	u_int8_t ptcl;
	u_int16_t len;
};

class UDPBuilder
{
public:
	UDPBuilder();
	~UDPBuilder();
	UDPBuilder(const DNS::DNSPocket &dnsPocketArg);
	UDPPocket getUDPPocket();

private:
	DNS::DNSPocket dnsPocket;

};
