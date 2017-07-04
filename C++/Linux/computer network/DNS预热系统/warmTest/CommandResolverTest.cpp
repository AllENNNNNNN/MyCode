#include"../warm/CommandResolver.h"
#include<gtest/gtest.h>
#include<iostream>
TEST(CommandResolverClass,ResolveCommandMethod)
{
	char *v[] = { "/root/projects/warmTest/runTest","-d","domain.txt","-a","address.txt","-r","400" };

	int c = 7;
	CommandResolver commandResolver(c, v);
	for (size_t i = 0; i < c; i++)
	{
		std::cout << v[i] << std::endl;
	}
	/*

	EXPECT_EQ("domain.txt", v[2]);
	EXPECT_EQ("domain.txt", commandResolver.getDNSFileName());
	EXPECT_EQ("address.txt", commandResolver.getIPFileName());
	EXPECT_EQ(400, commandResolver.getRate());
	
	*/
}