
#include "UDPBuilder.h"
UDPBuilder::UDPBuilder()
{
}

UDPBuilder::~UDPBuilder()
{
}

UDPBuilder::UDPBuilder(const DNS::DNSPocket & dnsPocketArg):dnsPocket(dnsPocketArg)
{
	
}

UDPPocket UDPBuilder::getUDPPocket()
{
	udphdr udpHearder;
	udpHearder.source = htons(5678);
	udpHearder.dest = htons(53);
	udpHearder.len = htons(sizeof(udphdr) + dnsPocket.length);
	UDPPocket udpPocket;
	udpPocket.UDPdata= new __uint8_t[udpHearder.len];
	udpPocket.length = sizeof(udphdr) + dnsPocket.length;
	memcpy(udpPocket.UDPdata, &udpHearder, sizeof(udphdr));
	memcpy(udpPocket.UDPdata + sizeof(udphdr), dnsPocket.data, dnsPocket.length);
	try
	{
		delete[] dnsPocket.data;
		dnsPocket.data = NULL;
	}
	catch (const std::exception& e)
	{
		std::cout << "Can't Release dnsPocket.data's memory:" << e.what() << std::endl;
	}
	return udpPocket;
}
