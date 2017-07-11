#include<iostream>
#include "CommandResolver.h"
#include"FileResolver.h"
#include"DNS.h"
#include"DNSBuilder.h"
#include"IPBuilder.h"
#include"RawSocketSender.h"
int main(int arg, char *argv[])
{

	CommandResolver commandResolver(arg, argv);
	commandResolver.ResovleCommand();


	FileResolver fileResolver(commandResolver.getDNSFileName(), commandResolver.getIPFileName());
	std::cout << "domain file:" + commandResolver.getDNSFileName() << std::endl;
	std::cout << "address file:" + commandResolver.getIPFileName() << std::endl;
	std::cout << "send rate:" << commandResolver.getRate() << std::endl;
	std::vector<DNS::DNSinfo> DNSInfos = fileResolver.getDNSInfos();
	std::vector<IPInfo> IPInfos = fileResolver.getIPInfos();

	int count = 0;
	//Ëæ»ú·¢ËÍ
	/*
	while (true)
	{
		int i = rand() % DNSInfos.size();
		int j = rand() % IPInfos.size();
		DNS::DNSinfo tempDNSinfo = DNSInfos[i];
		IPInfo tempIPInfo = IPInfos[j];
		std::cout << "Query " + tempDNSinfo.domainName + "(" + tempDNSinfo.Type + ")" + " from " + tempIPInfo.getSrc() + " to " + tempIPInfo.getDes() << std::endl;
		DNSBuilder dnsBuilder(tempDNSinfo);
		DNS::DNSPocket dnsPocket = dnsBuilder.getDNSPackage();

		UDPBuilder udpBuilder(dnsPocket);
		UDPPocket udpPocket = udpBuilder.getUDPPocket();

		IPBuilder ipBuilder(tempIPInfo, udpPocket);
		IPPocket ipPocket = ipBuilder.getIPPocket();

		RawSocketSender rawSocketSender;
		rawSocketSender.sendPocket(ipPocket.IPdata, ipPocket.length);

		delete[] ipPocket.IPdata;
		++count;
		if (count >= commandResolver.getRate())
		{
			sleep(1);
			count = 0;
		}
	}
	*/
	//Ë³Ðò·¢ËÍ



	for (size_t i = 0; i < DNSInfos.size(); i++)
	{
		for (size_t j = 0; j < IPInfos.size(); j++)
		{

			DNS::DNSinfo tempDNSinfo = DNSInfos[i];
			IPInfo tempIPInfo = IPInfos[j];
			std::cout << "Query " + tempDNSinfo.domainName + "(" + tempDNSinfo.Type + ")" + " from " + tempIPInfo.getSrc() + " to " + tempIPInfo.getDes() << std::endl;
			DNSBuilder dnsBuilder(tempDNSinfo);
			DNS::DNSPocket dnsPocket = dnsBuilder.getDNSPackage();

			UDPBuilder udpBuilder(dnsPocket);
			UDPPocket udpPocket = udpBuilder.getUDPPocket();

			IPBuilder ipBuilder(tempIPInfo, udpPocket);
			IPPocket ipPocket = ipBuilder.getIPPocket();

			RawSocketSender rawSocketSender;
			rawSocketSender.sendPocket(ipPocket.IPdata, ipPocket.length);

			delete[] ipPocket.IPdata;
			++count;
			if (count >= commandResolver.getRate())
			{
				sleep(1);
				count = 0;
			}
		}



	}




}