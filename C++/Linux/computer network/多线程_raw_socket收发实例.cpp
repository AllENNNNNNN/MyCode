#include <unistd.h>
#include <stdio.h>
#include <sys/socket.h>
#include <netinet/ip.h>
#include <netinet/udp.h>
#include<memory.h>
#include<stdlib.h>
#include <linux/if_ether.h>
#include <linux/if_packet.h> // sockaddr_ll
#include<arpa/inet.h>
#include<netinet/if_ether.h>
#include<iomanip>
#include<iostream>

#include<errno.h>

static void *handle_request(void *argv)
{

	//�ں˻�����ݸ�ÿһ��socket����һ��
	
	uint8_t request[1024] = { 0 };
	int request_length = 0;
	int rcode = -1;
	int sd;
	struct sockaddr_in client_addr;
	socklen_t addrlen = sizeof(client_addr);
	//sd = socket(PF_PACKET, SOCK_RAW, htons(ETH_P_IP));
	sd = socket(AF_INET, SOCK_RAW, IPPROTO_UDP );
	//sd = socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP);

	sockaddr_in addrServ;
	addrServ.sin_addr.s_addr= htonl(INADDR_ANY);//ָ��0.0.0.0��ַ����ʾ�����ַ
	addrServ.sin_family = AF_INET;//��ʾIPv4���׽�������
	addrServ.sin_port = htons(53);
	bind(sd, (sockaddr*)&addrServ, sizeof(addrServ));
	int  one = 1;
	const int *val = &one;

	/*
	���IP_HDRINCLδ�������ɽ������ں˷��͵������Ǵ�IP�ײ�֮��ĵ�һ���ֽڿ�ʼ�ģ��ں˻��Զ�������ʵ�IP
	���IP_HDRINGL������������Ҫ���й���IP��
	*/
	/*
	if (setsockopt(sd, IPPROTO_IP, IP_HDRINCL, val, sizeof(int)))
	{
		perror("setsockopt() error");
		exit(-1);
	}
	*/
	while (true)
	{
		//���ܱ���
		/*
		����53�˿ڵ�UDPЭ���IP�㼰�������ݣ�Ȼ�����ݷ���IP���ﴫ��ȥ
		*/
		std::cout <<"Socket ID:"<< *((int *)argv) << std::endl;

		if ((request_length = recvfrom(sd, request, sizeof(request), 0,(struct sockaddr *)&client_addr, &addrlen)) == -1)
		{
			printf("recvfrom failed ! error message : %s\n", strerror(errno));
			continue;
		}
		sendto(sd, request, request_length, 0, (sockaddr *)&client_addr, addrlen);
		std::cout << inet_ntoa(client_addr.sin_addr) << std::endl;
		
	}

}


int main(int argc, char *argv[])
{
	int sd;
	//sd = socket(PF_PACKET, SOCK_RAW, htons(ETH_P_IP));
	//sd = socket(AF_INET, SOCK_RAW, IPPROTO_TCP );
	sd = socket(AF_INET, SOCK_RAW, IPPROTO_UDP);
	
	if (sd < 0)
	{
		perror("socket() error");
		// If something wrong just exit
		exit(-1);
	}
	else
		printf("socket() - Using SOCK_RAW socket and UDP protocol is OK.\n");



	pthread_t thread_s[10];

	
	for (int i = 0; i < 10; i++) {
	
		pthread_create(&thread_s[i], NULL, handle_request, (void *)&sd);
	}

	
	for (int i = 0; i < 10; i++) {
		pthread_join(thread_s[i], NULL);
	}
	


	close(sd);
	return 0;
}