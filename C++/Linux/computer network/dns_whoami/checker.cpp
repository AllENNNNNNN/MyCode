#include "checker.h"






/*
@summary ��������
@param request ָ���������ָ��
@param request_length ������ĳ���
@return ���ض�Ӧ��rcode,���������-1
*/
int Checker::check_request(const uint8_t * request, int& request_length)
{

	if (request_length < 12)//����������12�ֽ�,��Ҫ��Ӧ
	{
		return -1;
	}

	int rcode = 0;

	rcode = this->check_head(request);//����ͷ��
	if (rcode != 0)
	{
		return rcode;
	}

	int domain_length = 0;
	rcode = this->check_domain(request + 12, request_length - 12 - 4, domain_length); //��������
	if (rcode != 0)
	{
		return rcode;
	}
	uint16_t TYPE = htons(*((uint16_t *)(request + 12 + domain_length)));
	uint16_t CLASS = htons(*((uint16_t *)(request + 12 + domain_length + 2)));
	if (CLASS != 1)
	{
		return -1;//��������CLASS����1����Ҫ��Ӧ
	}


	int addition_length = 0;
	if (((DNS_Head *)(request))->ARCOUNT)
	{
		rcode = this->check_addition(request + 12 + domain_length + 4, request_length - 12 - domain_length - 4, addition_length);
		if (rcode != 0)
		{
			return rcode;
		}
	}

	if (addition_length + domain_length + 4 + 12 < request_length)//���Ľ������ж��������
	{
		return -1;
	}

	if (TYPE != 1)//�������Ͳ���1�������ֶ���ȷ
	{
		return 2;
	}

	return 0;
}
/*
@summary ����������ͷ��
@paramr  ָ��ͷ����ָ��
@return  ����rcode
*/
int Checker::check_head(const uint8_t * request)
{
	DNS_Head *dns_head = (DNS_Head *)request;
	uint16_t flag = ntohs(dns_head->FLAGS);
	if (flag & 0x8000)//QR д����1����Ҫ��Ӧ
	{
		return -1;
	}
	if (ntohs(dns_head->QDCOUNT) != 1)//Total Questions ��Ϊ1,������Ӧ
	{
		return -1;
	}
	if (ntohs(dns_head->ANCOUNT) != 0)//Total Answer RRs��Ϊ0��������Ӧ
	{
		return -1;
	}
	if (ntohs(dns_head->NSCOUNT) != 0)//Total Authority RRs��Ϊ0��������Ӧ
	{
		return -1;
	}
	if (ntohs(dns_head->ARCOUNT) != 0 && ntohs(dns_head->ARCOUNT) != 1)//Total Additional RRs��Ϊ0Ҳ��Ϊ1��������Ӧ
	{
		return -1;
	}
	return 0;
}

/*
@summary �������
@param domainΪָ��������ָ��
@param max_length ���������������������󳤶�
@param domain_length ��Ҫ����������ĳ���
@return ����RCODE
*/
int Checker::check_domain(const uint8_t * domain, int max_length, int & domain_length)
{
	int sub_lable_length = 0;
	char c;
	char pre;
	char bac;
	while (sub_lable_length = domain[domain_length])
	{
		if (sub_lable_length > 63)//������ʽ���Ϸ�
		{
			return 1;
		}
		int cur = domain_length + 1;
		domain_length += sub_lable_length + 1;
		if (domain_length >= max_length || domain_length >= 255)
		{

			return 1;//������ʽ̫�����߲�����
		}
		
		for (size_t i = cur; i < domain_length; i++)
		{
			c = domain[i];
			pre = domain[i - 1];
			bac = domain[i + 1];


			if (c == '-')
			{
				if (!((pre >= '0'&&pre <= '9' || pre >= 'a'&&pre <= 'z' || pre >= 'A' || pre <= 'Z') &&
					(bac >= '0'&&bac <= '9' || bac >= 'a'&&bac <= 'z' || bac >= 'A' || bac <= 'Z')))
				{

					return 1;//������ʽ�Ƿ���-ֻ�ܳ����ڽڵ����λ
				}
			}
			else if (!(c >= '0'&&c <= '9' || c >= 'a'&&c <= 'z' || c >= 'A' || c <= 'Z'))
			{

				return 1;//������ʽ�Ƿ���ֻ�ܳ�����ĸ���ֻ���-
			}

		}

	}
	domain_length++;//���Ͻ�βΪ0

	if (domain_length > max_length || domain_length >= 255)
	{

		return 1;//������ʽ̫�����߲�����
	}
	return 0;
}
/*
@summary ��鸽�Ӳ���
@param addition ָ�򸽼Ӳ��ֵ�ָ��
@param max_length ������и��Ӳ��������������󳤶�
@param addition_length ������Ӱ��ĳ���
@return rcode
*/
int Checker::check_addition(const uint8_t * addition, int max_length, int &addition_length)
{
	addition_length = 11;
	if (addition_length > max_length)
	{
		return 1;//���Ĳ�����
	}
	unsigned name = addition[0];
	if (name != 0)
	{
		return -1;
	}
	unsigned type = ntohs(*(uint16_t *)(addition + 1));
	if (type != 41)
	{
		return -1;
	}
	unsigned RdataLength = (*(uint16_t *)(addition + 1 + 2 + 2 + 4));
	if (RdataLength != 0)
	{
		return -1;
	}
	return 0;
}
