#pragma once
#include<iostream>
namespace DNS
{
	//DNS头部
	struct Header
	{
		unsigned short ID;//DNS的ID
		unsigned short FLAGS;
		unsigned short QDCOUNT;//请求段中的问题记录数
		unsigned short ANCOUNT;//回答记录数
		unsigned short NSCOUNT;//授权记录数
		unsigned short ARCOUNT;//附加记录数

	};

	struct DNSinfo
	{
		std::string domainName;
		std::string Type;
		unsigned	char *Question;
		int length;
	};

	struct DNSPocket
	{
		unsigned	char *data;
		unsigned int length;
	};

	//以下类型暂时未用*******************************************************************************************************8
	enum
	{
		DNS_DOMAIN_MAX_SIZE = 256//完全限定域名的最大尺寸（包括\0）
	};


	struct Question
	{
		char domain[DNS_DOMAIN_MAX_SIZE];
		unsigned QTYPE;//查询的协议类型
		unsigned QCLASS;//查询的类

	};

	struct Answer
	{
		unsigned short NAME;//资源记录包含的域名
		unsigned short TYPE;//表示DNS协议的类型
		unsigned short CLASS;//表示RDATA的类
		unsigned short TTL;//表示资源记录可以缓存的时间
		unsigned short RDLENGTH;//表示RDATA的长度
		unsigned short RDATA;//不定长字符串来表示记录
	};


	struct Authority
	{
		unsigned short NAME;//资源记录包含的域名
		unsigned short TYPE;//表示DNS协议的类型
		unsigned short CLASS;//表示RDATA的类
		unsigned short TTL;//表示资源记录可以缓存的时间
		unsigned short RDLENGTH;//表示RDATA的长度
		unsigned short RDATA;//不定长字符串来表示记录


	};
	struct Additional
	{
		unsigned short NAME;//资源记录包含的域名
		unsigned short TYPE;//表示DNS协议的类型
		unsigned short CLASS;//表示RDATA的类
		unsigned short TTL;//表示资源记录可以缓存的时间
		unsigned short RDLENGTH;//表示RDATA的长度
		unsigned short RDATA;//不定长字符串来表示记录

	};


}