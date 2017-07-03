#include "RawSocketSender.h"

RawSocketSender::RawSocketSender()
{
	socketID = socket(AF_INET, SOCK_RAW, IPPROTO_UDP);
	if (socketID < 0)
	{
		perror("socket() error");
		// If something wrong just exit
		exit(-1);
	}
	int val = 1;
	if (setsockopt(socketID, IPPROTO_IP, IP_HDRINCL, &val, sizeof(int)))
	{
		perror("setsockopt() error");
		exit(-1);
	}
}

RawSocketSender::~RawSocketSender()
{
	close(socketID);
}

bool RawSocketSender::sendPocket(__uint8_t * buffer, unsigned int length)
{
	iphdr *ip = (iphdr *)buffer;
	udphdr *udp = (udphdr *)(buffer + sizeof(iphdr));

	struct sockaddr_in sin, din;
	sin.sin_family = AF_INET;
	din.sin_family = AF_INET;
	// Port numbers
	sin.sin_port = udp->source;
	din.sin_port = udp->dest;
	// IP addresses
	sin.sin_addr.s_addr = ip->saddr;
	din.sin_addr.s_addr = ip->daddr;



	if (sendto(socketID, buffer, ip->tot_len, 0, (struct sockaddr *)&din, sizeof(din)) < 0)
		// Verify
	{
		perror("sendto() error");
		exit(-1);
	}
	

	return true;
}
