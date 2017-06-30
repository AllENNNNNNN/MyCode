//file sqrt_unittest.cpp
#include"sqrt.h"
#include<gtest/gtest.h>

TEST(SQRTest, Zero)
{
	EXPECT_EQ(0, sqrt(0));
}

TEST(SQRTTest, Positive)
{
	EXPECT_EQ(100, sqrt(10000));
}