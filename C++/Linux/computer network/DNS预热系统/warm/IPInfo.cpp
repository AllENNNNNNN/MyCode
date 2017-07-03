#include "IPInfo.h"

IPInfo::IPInfo()
{
}

IPInfo::~IPInfo()
{
}

IPInfo::IPInfo(std::string desArg, std::string srcArg) :src(srcArg), des(desArg)
{
}

std::string IPInfo::getSrc()
{
	return src;
}

std::string IPInfo::getDes()
{
	return des;
}
