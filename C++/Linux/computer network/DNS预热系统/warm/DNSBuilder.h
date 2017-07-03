#pragma once
#include<map>
#include"DNS.h"
#include<vector>
class DNSBuilder
{
public:
	DNSBuilder();
	DNSBuilder(DNS::DNSinfo &dnsInfo);

	~DNSBuilder();
	DNS::DNSPocket getDNSPackage();

private:
	DNS::DNSinfo dnsInfo;
};
