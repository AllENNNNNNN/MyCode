#pragma once
#include<vector>
#include<string>
#include<stdlib.h>
#include<map>
#include"IPInfo.h"
#include"DNS.h"
class FileResolver
{
private:
	std::string DNSFilename;
	std::string IPFilename;
	bool toIPsrc(std::string);
	bool toIPdes(std::string);
	bool toDomainName(std::string, char *domainName);//将string类型的域名转换为域名数据包
	bool toDomainType(std::string, unsigned short &domainType);//将string的域名类型映射为域名类型数字
	bool initDomainTypeMap();//初始化域名映射
	std::map<std::string, unsigned short> domainTypeMap;
public:
	FileResolver();
	~FileResolver();
	FileResolver(std::string DNSFilenameArg, std::string IPFilenameArg);
	std::vector<DNS::DNSinfo> getDNSInfos();
	std::vector<std::string> split(std::string str, std::string pattern);//字符串分割
	std::vector<IPInfo> getIPInfos();

private:

};

