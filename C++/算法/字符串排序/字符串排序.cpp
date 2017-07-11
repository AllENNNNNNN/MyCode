//#include "header.h"	//AnycodeX includes the header.h by default, needn't cancle the notation.
#include <iostream>
#include<inttypes.h>
#include<cctype>
#include<iomanip>
#include<vector>
#include<string>
#include<algorithm>
using namespace std;

struct myChar
{
	char c;
	int seq;
	myChar(char cha, int s)
	{
		c = cha;
		seq = s;
	}
};
bool compare(const myChar &a, const myChar &b)
{
	if (tolower(a.c) == tolower(b.c))
	{
		return a.seq<b.seq;
	}
	return tolower(a.c)<tolower(b.c);
}
int main()
{
	//freopen("input.txt", "r", stdin);
	//freopen("output.txt", "w", stdout);
	char c;
	string s;

	while (getline(cin, s))
	{
		vector<myChar> v;
		int seq = 0;
		for (int i = 0; i<s.size(); i++)
		{
			if (isalpha(s[i]))
			{
				v.push_back(myChar(s[i], seq));
				seq++;
			}
		}

		sort(v.begin(), v.end(), compare);
		/*
		for (int i = 0; i<v.size(); i++)
		{
		cout << v[i].c << ' ' << v[i].seq << endl;
		}
		*/
		int j = 0;
		for (int i = 0; i<s.size(); i++)
		{
			if (isalpha(s[i]))
			{
				s[i] = v[j++].c;
			}
		}
		cout << s << endl;
	}
}