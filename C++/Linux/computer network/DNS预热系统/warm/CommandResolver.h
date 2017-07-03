#pragma once
#include<string>
#include"IPInfo.h"
class CommandResolver
{
private:
	int argc;
	char **argv;
	std::string DNSFileName;
	std::string IPFileName;
	int rate;
	bool CheckTheParament();//¼ìÑé²ÎÊý
public:
	CommandResolver();
	~CommandResolver();
	CommandResolver(int &argc, char *argv[]);
	std::string getDNSFileName();
	std::string getIPFileName();
	int getRate();
	bool ResovleCommand();
};