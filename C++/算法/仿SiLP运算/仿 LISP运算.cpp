
#include <iostream>
#include <algorithm>
#include <string>
#include<cmath>
#include<vector>
#include<map>
#include<cctype>
#include<istream>
#include<stdlib.h>
using namespace std;


int getresult()
{
	string s;
	cin >> s;
	if (s.find("add") != string::npos)
	{
		return getresult() + getresult();
	}
	if (s.find("sub") != string::npos)
	{
		return getresult() - getresult();
	}
	if (s.find("mul") != string::npos)
	{
		return getresult() *getresult();
	}
	if (s.find("div") != string::npos)
	{
		int a1 = getresult();
		int a2 = getresult();
		if (a2==0)
		{
			cout << "error" << endl;
			exit(0);
		}
		return a1 / a2;
	}

	while (s.back()==')')
	{
		s.pop_back();
	}
	return atoi(s.c_str());

}

int main()
{
	//freopen("input.txt", "r", stdin);

	
	cout << getresult() << endl;
}