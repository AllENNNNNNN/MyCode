
#include "IPBuilder.h"

IPBuilder::IPBuilder()
{
}

IPBuilder::~IPBuilder()
{
}

IPBuilder::IPBuilder(IPInfo & IPinfoArg, UDPPocket & udpPocketArg):ipInfo(IPinfoArg),udpPocket(udpPocketArg)
{

}

IPPocket IPBuilder::getIPPocket()
{
	IPPocket ipPocket;
	ipPocket.length = sizeof(iphdr) + udpPocket.length;
	ipPocket.IPdata = new __uint8_t[ipPocket.length];
	iphdr *ip = (iphdr*)ipPocket.IPdata;
	ip->ihl = 5;
	ip->version = 4;//报头长度，4*32=128bit=16B
	ip->tos = 0; // 服务类型
	ip->tot_len = ((sizeof(struct iphdr) + udpPocket.length));
	//ip->id = htons(54321);//可以不写
	ip->ttl = 64; // hops生存周期
	ip->protocol = 17; // UDP
	ip->check = 0;
	// Source IP address, can use spoofed address here!!!
	ip->saddr = inet_addr(ipInfo.getSrc().c_str());
	// The destination IP address
	ip->daddr = inet_addr(ipInfo.getDes().c_str());
	setUDPCheckSum();
	memcpy(ipPocket.IPdata + sizeof(iphdr), udpPocket.UDPdata, udpPocket.length);
	try
	{
		delete[]udpPocket.UDPdata;
	}
	catch (const std::exception& e)
	{
		std::cout << "Can't free udpPocket.UDPdata's memory:" << e.what() << std::endl;
	}
	return ipPocket;
}

void IPBuilder::setUDPCheckSum()
{
	__uint8_t *forChecksum = new __uint8_t[(sizeof(UDP_PSD_Header) + udpPocket.length + 1) / 2 * 2];
	UDP_PSD_Header *udp_PSD_Header = (UDP_PSD_Header *)forChecksum;
	udp_PSD_Header->src = inet_addr(ipInfo.getSrc().c_str());
	udp_PSD_Header->des = inet_addr(ipInfo.getDes().c_str());
	udp_PSD_Header->mbz = 0;
	udp_PSD_Header->ptcl = 17;
	udp_PSD_Header->len = htons(udpPocket.length);
	memcpy(forChecksum+sizeof(UDP_PSD_Header), udpPocket.UDPdata, udpPocket.length);
	udphdr *udpHearder = (udphdr *)(udpPocket.UDPdata);
	udpHearder->check = csum((unsigned short *)forChecksum, (sizeof(UDP_PSD_Header) + udpPocket.length + 1) / 2);
	delete[]forChecksum;
}

unsigned short IPBuilder::csum(unsigned short * buf, int nwords)
{
	unsigned long sum;
	for (sum = 0; nwords > 0; nwords--)
	{
		sum += *buf++;
	}
	sum = (sum >> 16) + (sum & 0xffff);
	sum += (sum >> 16);
	return (unsigned short)(~sum);
}
