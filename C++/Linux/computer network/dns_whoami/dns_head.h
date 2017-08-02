
#ifndef DNS_WHOAMI_DNS_HEAD_H_
#define DNS_WHOAMI_DNS_HEAD_H_

 //DNSͷ��
struct DNS_Head
{
	unsigned short ID;//DNS��ID
	unsigned short FLAGS;
	unsigned short QDCOUNT;//������е������¼��
	unsigned short ANCOUNT;//�ش��¼��
	unsigned short NSCOUNT;//��Ȩ��¼��
	unsigned short ARCOUNT;//���Ӽ�¼��

};
#pragma pack(push) //�������״̬
#pragma pack(2)// �趨Ϊ4�ֽڶ���
struct DNS_Answer
{
	uint16_t domain_ptr;
	uint16_t type;
	uint16_t classs;
	uint32_t ttl;
	uint16_t rdata_length;
	uint32_t rdata;
};
#pragma pack(pop)// �ָ�����״̬
#endif // !DNS_WHOAMI_DNS_HEADER_H_
