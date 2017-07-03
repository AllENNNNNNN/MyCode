#pragma once
#include<string>
class IPInfo
{
public:
	IPInfo();

	~IPInfo();
	IPInfo(std::string des, std::string src);
	std::string getSrc();
	std::string getDes();

private:
	std::string src;
	std::string des;

};
