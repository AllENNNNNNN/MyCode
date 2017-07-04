

#include<gtest/gtest.h>
#include"../warm/FileResolver.h"

TEST(FileResolverClass,getDNSInfos)
{
	FileResolver fileResolver("/root/wcf/testfile/Domain.txt","/root/wcf/testfile/IP.txt");
	
	std::vector<DNS::DNSinfo> dnsInfos = fileResolver.getDNSInfos();
	DNS::DNSinfo tempDNSInfos = dnsInfos[0];
	EXPECT_EQ("www.baidu.com", tempDNSInfos.domainName);
	EXPECT_EQ("MX", tempDNSInfos.Type);
	unsigned char pocket[] = { 0x03,0x77,0x77,0x77,0x05,0x62,0x61,0x69, 0x64, 0x75,0x03, 0x63, 0x6f, 0x6d, 0x00, 0x00
		 ,0x01, 0x00, 0x01 };
	unsigned char *anser = tempDNSInfos.Question;
	EXPECT_EQ(sizeof(pocket), tempDNSInfos.length);
	for (size_t i = 0; i < tempDNSInfos.length; i++)
	{
		EXPECT_EQ(pocket[i], anser[i]);
	}
}