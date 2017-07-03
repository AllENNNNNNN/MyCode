#include<string>
#include<sys/socket.h>
#include<netinet/in.h>
#include<memory.h>
#include "DNSBuilder.h"



DNSBuilder::DNSBuilder()
{

}

DNSBuilder::DNSBuilder(DNS::DNSinfo & dnsInfoArg) :dnsInfo(dnsInfoArg)
{
}

DNSBuilder::~DNSBuilder()
{

}

DNS::DNSPocket DNSBuilder::getDNSPackage()
{
	DNS::Header header;
	memset(&header, 0, sizeof(DNS::Header));
	header.ID = 0xcc9e;//此处可以固定吗?
	
	header.FLAGS = htons(0x0100);
	header.QDCOUNT = htons(1);
	DNS::DNSPocket dnsPocket;
	unsigned short *temp = (unsigned short *)&header;
	dnsPocket.length = sizeof(DNS::Header) + dnsInfo.length;
	dnsPocket.data = new unsigned char[dnsPocket.length];
	memcpy(dnsPocket.data, &header, sizeof(DNS::Header));
	memcpy(dnsPocket.data + sizeof(DNS::Header), dnsInfo.Question, dnsInfo.length);
	return dnsPocket;
}


