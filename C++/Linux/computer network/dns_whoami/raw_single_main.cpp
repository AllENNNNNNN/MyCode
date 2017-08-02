
//���߳�ԭʼ�׽���

#include<inttypes.h>
#include<sys/socket.h>
#include <stdio.h>//for perror
#include<errno.h>
#include<stdlib.h>
#include <unistd.h>//for close
#include <sys/syscall.h>
#include<netinet/ip.h>

#include <iostream>
#include <string>


#include"responser.h"
#include"checker.h"

#define PTHREAD_NUM 1




static void *handle_request(void *argv)
{
	/*Socket��ʼ������*/
	int sd = sd = socket(AF_INET, SOCK_RAW, IPPROTO_UDP);
	if (sd < 0)
	{
		perror("socket() error");
		// If something wrong just exit
		exit(-1);
	}

	int optVal = 1024 * 1024;
	int optLen = sizeof(int);

	//setsockopt(sd, SOL_SOCKET, SO_RCVBUF, (char*)&optVal, optLen);

	sockaddr_in addrServ;
	addrServ.sin_addr.s_addr = htonl(INADDR_ANY);//ָ��0.0.0.0��ַ����ʾ�����ַ
	addrServ.sin_family = AF_INET;//��ʾIPv4���׽�������
	addrServ.sin_port = htons(53);
	bind(sd, (sockaddr*)&addrServ, sizeof(addrServ));
	//Socket��ʼ������


	int receive_length = 0, request_length = 0;
	int send_length = 0, response_length = 0;
	uint8_t receive_buffer[1024] = { 0 };
	uint8_t _send_buffer[1024] = { 0 };
	uint8_t *send_buffer = _send_buffer + 20;//������ǰ�����¿ռ����udpУ��͵ļ���
	Checker checker;
	Responser responser;
	int rcode = 0;


	struct sockaddr_in client_addr;
	socklen_t addrlen = sizeof(client_addr);

	int thread_id = *((int *)argv);

	//std::cout << thread_id << std::endl;
	while (true)
	{
		//���ܱ���,�˴����ܵı�����IP+UDP+DNS
		std::cout << thread_id << std::endl;
		if ((receive_length = recvfrom(sd, receive_buffer, sizeof(receive_buffer), 0, (struct sockaddr *)&client_addr, &addrlen)) == -1)
		{
			printf("recvfrom failed ! error message : %s\n", strerror(errno));
			continue;
		}


		int select_code = uint32_t((((iphdr*)receive_buffer)->check - ((udphdr *)(receive_buffer + 20))->check + ((iphdr*)receive_buffer)->id)) % PTHREAD_NUM;
		//	std::cout << select_code << std::endl;


		if (select_code != thread_id)
		{
			continue;
		}

		//��鱨��
		uint8_t *request = receive_buffer + 28;
		request_length = receive_length - 28;
		if ((rcode = checker.check_request(request, request_length)) == -1)
		{
			continue;
		}

		//������Ӧ����
		uint8_t *response = send_buffer + 8;//ǰ������һЩ�ֽڱ��ڼ���udpУ���
											//responseָ��Ӧ��DNS����
		responser.construct_response(request, request_length, rcode, client_addr.sin_addr.s_addr, response, response_length);
		responser.construct_udp_header(((iphdr*)receive_buffer)->daddr, ((iphdr*)receive_buffer)->saddr, //����udpͷ��
			((udphdr *)(receive_buffer + 20))->dest, ((udphdr *)(receive_buffer + 20))->source, response_length, send_buffer);


		//������Ӧ
		send_length = response_length + 8;

		std::cout << thread_id << std::endl;
		if (sendto(sd, send_buffer, send_length, 0, (struct sockaddr *) &client_addr, sizeof(client_addr)) == -1)
		{
			printf("sendto failed ! error message :%s\n", strerror(errno));
			break;
		}
		memset(receive_buffer, 0, sizeof(receive_buffer));
		memset(_send_buffer, 0, sizeof(_send_buffer));

	}
	close(sd);
}

int main()
{

	
	int  place_hold = socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP);
	sockaddr_in addrServ1;
	addrServ1.sin_addr.s_addr = htonl(INADDR_ANY);
	addrServ1.sin_family = AF_INET;
	addrServ1.sin_port = htons(53);
	bind(place_hold, (sockaddr*)&addrServ1, sizeof(addrServ1));

	/*Socket��ʼ������*/
	int  sd = socket(AF_INET, SOCK_RAW, IPPROTO_UDP);
	if (sd < 0)
	{
		perror("socket() error");
		// If something wrong just exit
		exit(-1);
	}


	sockaddr_in addrServ;
	addrServ.sin_addr.s_addr = htonl(INADDR_ANY);//ָ��0.0.0.0��ַ����ʾ�����ַ
	addrServ.sin_family = AF_INET;//��ʾIPv4���׽�������
	addrServ.sin_port = htons(53);
	bind(sd, (sockaddr*)&addrServ, sizeof(addrServ));
	//Socket��ʼ������


	int receive_length = 0, request_length = 0;
	int send_length = 0, response_length = 0;
	uint8_t receive_buffer[1024] = { 0 };
	uint8_t _send_buffer[1024] = { 0 };
	uint8_t *send_buffer = _send_buffer + 20;//������ǰ�����¿ռ����udpУ��͵ļ���
	Checker checker;
	Responser responser;
	int rcode = 0;


	struct sockaddr_in client_addr;
	socklen_t addrlen = sizeof(client_addr);

	while (true)
	{
	
		if ((receive_length = recvfrom(sd, receive_buffer, sizeof(receive_buffer), 0, (struct sockaddr *)&client_addr, &addrlen)) == -1)
		{
			printf("recvfrom failed ! error message : %s\n", strerror(errno));
			continue;
		}


		int select_code = uint32_t((((iphdr*)receive_buffer)->check - ((udphdr *)(receive_buffer + 20))->check + ((iphdr*)receive_buffer)->id)) % PTHREAD_NUM;
	


		//��鱨��
		uint8_t *request = receive_buffer + 28;
		request_length = receive_length - 28;
		if ((rcode = checker.check_request(request, request_length)) == -1)
		{
			continue;
		}

		//������Ӧ����
		uint8_t *response = send_buffer + 8;//ǰ������һЩ�ֽڱ��ڼ���udpУ���
											//responseָ��Ӧ��DNS����
		responser.construct_response(request, request_length, rcode, client_addr.sin_addr.s_addr, response, response_length);
		responser.construct_udp_header(((iphdr*)receive_buffer)->daddr, ((iphdr*)receive_buffer)->saddr, //����udpͷ��
			((udphdr *)(receive_buffer + 20))->dest, ((udphdr *)(receive_buffer + 20))->source, response_length, send_buffer);


		//������Ӧ
		send_length = response_length + 8;

		if (sendto(sd, send_buffer, send_length, 0, (struct sockaddr *) &client_addr, sizeof(client_addr)) == -1)
		{
			printf("sendto failed ! error message :%s\n", strerror(errno));
			break;
		}
		memset(receive_buffer, 0, sizeof(receive_buffer));
		memset(_send_buffer, 0, sizeof(_send_buffer));

	}
	close(sd);



	return 0;
}
