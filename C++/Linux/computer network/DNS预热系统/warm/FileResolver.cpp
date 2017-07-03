#include<fstream>
#include<iostream>
#include<iomanip>
#include<netinet/in.h>
#include "FileResolver.h"



bool FileResolver::toIPsrc(std::string)
{
	return false;
}

bool FileResolver::toIPdes(std::string)
{
	return false;
}

bool FileResolver::toDomainName(std::string domainNameString, char * domainName)
{
	
	if (domainNameString.size()>255)
	{
		return false;
	}
	std::vector<std::string>subStrs = split(domainNameString, ".");
	int t = 0;
	for (size_t i = 0; i < subStrs.size(); ++i)
	{
		if (subStrs[i].length()>63)
		{
			return false;
		}
		domainName[t++] = subStrs[i].size();
		for (size_t j = 0; j < subStrs[i].size(); j++)
		{
			domainName[t++] = subStrs[i][j];
		}
	}

	domainName[t] = 0;
	return true;
}

bool FileResolver::toDomainType(std::string domainTypeString, unsigned short & domainType)
{

	if (!domainTypeMap.count(domainTypeString))
	{
		return false;
	}
	domainType = domainTypeMap[domainTypeString];
	return true;
}

bool FileResolver::initDomainTypeMap()
{
	domainTypeMap["A"] = 1;
	domainTypeMap["SOA"] = 6;
	domainTypeMap["CNAME"] = 5;
	domainTypeMap["PTR"] = 12;
	domainTypeMap["MX"] = 15;
	domainTypeMap["TXT"] = 16;
	domainTypeMap["AAAA"] = 28;
	domainTypeMap["NS"] = 2;

	return true;
}

FileResolver::FileResolver()
{
	initDomainTypeMap();
}

FileResolver::~FileResolver()
{
}

FileResolver::FileResolver(std::string DNSFilenameArg, std::string IPFilenameArg) :DNSFilename(DNSFilenameArg), IPFilename(IPFilenameArg)
{
	initDomainTypeMap();
}

std::vector<DNS::DNSinfo> FileResolver::getDNSInfos()
{
	std::cout << "Resolving the domain infos..." << std::endl;
	std::vector<DNS::DNSinfo> DNSInfos;
	std::fstream DNSin(DNSFilename.c_str());
	std::string name, type;
	while (DNSin >> name >> type)
	{

		unsigned short typeNumber = 0;
		if (!toDomainType(type, typeNumber))
		{
			continue;
		}

		DNS::DNSinfo tempDNSinfo;
		tempDNSinfo.length = name.length() + 2 + 2 * sizeof(unsigned short);
		tempDNSinfo.Type = type;
		tempDNSinfo.domainName = name;
		tempDNSinfo.Question = new unsigned char[tempDNSinfo.length];
		if (!toDomainName(name, (char *)tempDNSinfo.Question))
		{
			continue;
		}
		//此处可能需要再斟酌一下

		tempDNSinfo.Question[name.length() + 2] = 0;
		tempDNSinfo.Question[name.length() + 3] = typeNumber;
		tempDNSinfo.Question[name.length() + 4] = 0;
		tempDNSinfo.Question[name.length() + 5] = 1;


		DNSInfos.push_back(tempDNSinfo);
	}
	if (DNSInfos.size()<=0)
	{
		std::cout << DNSFilename << " has no Legal domain name!" << std::endl;
		exit(-1);
	}
	return DNSInfos;
}

std::vector<std::string> FileResolver::split(std::string str, std::string pattern)
{
	std::string::size_type pos;
	std::vector<std::string> result;
	str += pattern;//扩展字符串以方便操作
	int size = str.size();

	for (int i = 0; i<size; i++)
	{
		pos = str.find(pattern, i);
		if (pos<size)
		{
			std::string s = str.substr(i, pos - i);
			result.push_back(s);
			i = pos + pattern.size() - 1;
		}
	}
	return result;
}



std::vector<IPInfo> FileResolver::getIPInfos()
{
	std::cout << "Resolving the address infos" << std::endl;
	std::vector<IPInfo> IPInfos;
	std::ifstream IPin(IPFilename.c_str());
	std::string src, des;
	while (IPin >> des >> src)
	{
		IPInfos.push_back(IPInfo(des, src));
	}
	if (IPInfos.size()<=0)
	{
		std::cout << IPFilename << " has no legal address!" << std::endl;
		exit(-1);
	}
	return IPInfos;
}
