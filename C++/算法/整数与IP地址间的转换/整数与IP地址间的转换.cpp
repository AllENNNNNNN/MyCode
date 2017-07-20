
#include <iostream>
#include <algorithm>
#include <string>
#include<cmath>
#include<vector>
#include<map>
#include<cctype>
using namespace std;

vector<string> split(const string &s, const string &c)
{
	vector<string> result;
	string::size_type pos = 0;
	string temp = s + c;
	for (size_t i = 0; i < temp.size(); i++)
	{
		pos = temp.find(c, i);
		if (pos >= temp.size())
		{
			break;
		}
		else
		{
			string subStr = temp.substr(i, pos - i);
			result.push_back(subStr);
			i = pos + c.size() - 1;
		}
	}

	return result;
}

uint32_t  getIntByIp(const string &s)
{
	uint32_t result;
	vector<string> numbers = split(s, ".");
	uint8_t *p = (uint8_t *)&result;
	p[3] = atoi(numbers[0].c_str());
	p[2] = atoi(numbers[1].c_str());
	p[1] = atoi(numbers[2].c_str());
	p[0] = atoi(numbers[3].c_str());
	return result;
}

string getIPbyInt(uint32_t ip)
{
	uint8_t *p = (uint8_t *)&ip;
	string s;
	s += to_string(p[3]);
	s += ".";
	s += to_string(p[2]);
	s += ".";
	s += to_string(p[1]);
	s += ".";
	s += to_string(p[0]);
	return s;

}

int main()
{
	freopen("input.txt", "r", stdin);
	string s;
	while (cin>>s)
	{
		cout << getIntByIp(s) << endl;
		uint32_t t;
		cin >> t;
		cout << getIPbyInt(t) << endl;
	}
}