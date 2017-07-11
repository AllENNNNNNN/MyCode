#include<iostream>
#include<vector>
#include<string>
#include<cinttypes>
#include<iomanip>
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

bool islegalIP(const string &s)
{
	for (size_t i = 0; i < s.size(); i++)
	{
		if (!isdigit(s[i]) && s[i] != '.')
		{
			return false;
		}
	}
	vector<string> numbers = split(s, ".");
	if (numbers.size() != 4)
	{
		return false;
	}

	for (size_t i = 0; i < numbers.size(); i++)
	{
		if (!numbers[i].length())
		{
			return false;
		}
		if (0>atoi(numbers[i].c_str()) || 255<atoi(numbers[i].c_str()))
		{
			return false;
		}
	}
	return true;
}

bool isLegalMask(const string&m)
{
	if (!islegalIP(m))
	{
	
		return false;
	}
	if (m=="0.0.0.0"||m=="255.255.255.255")
	{
		return false;
	}
	uint32_t number = getIntByIp(m);
	uint32_t b = ~number + 1;
	return (b&(b - 1)) == 0;
}

bool isPrivate(const string &s)
{
	return getIntByIp("10.0.0.0") <= getIntByIp(s) && getIntByIp(s) <= getIntByIp("10.255.255.255") ||
		getIntByIp("172.16.0.0") <= getIntByIp(s) && getIntByIp(s) <= getIntByIp("172.31.255.255") ||
		getIntByIp("192.168.0.0.0") <= getIntByIp(s) && getIntByIp(s) <= getIntByIp("192.168.255.255");
}

bool isA(const string &s)
{

	return getIntByIp("1.0.0.0") <= getIntByIp(s) && getIntByIp(s) <= getIntByIp("126.255.255.255");
}

bool isB(const string &s)
{
	return getIntByIp("128.0.0.0") <= getIntByIp(s) && getIntByIp(s) <= getIntByIp("191.255.255.255");
}

bool isC(const string &s)
{
	return getIntByIp("192.0.0.0") <= getIntByIp(s) && getIntByIp(s) <= getIntByIp("223.255.255.255");
}

bool isD(const string &s)
{
	return getIntByIp("224.0.0.0") <= getIntByIp(s) && getIntByIp(s) <= getIntByIp("239.255.255.255");
}

bool isE(const string &s)
{
	return getIntByIp("240.0.0.0") <= getIntByIp(s) && getIntByIp(s) <= getIntByIp("255.255.255.255");
}
int main()
{
	freopen("input.txt", "r", stdin);
	string s;
	int a = 0, b = 0, c = 0, d = 0, e = 0, error = 0, pri = 0;

	while (cin >> s)
	{
		//cout << hex << getIntByIp(s) << endl;
		vector<string>substr = split(s, "~");
		string ip = substr[0];
		string mask = substr[1];
		if (islegalIP(ip) && isLegalMask(mask))
		{
			a += isA(ip);
			b += isB(ip);
			c += isC(ip);
			d += isD(ip);
			e += isE(ip);
			pri += isPrivate(ip);
		}
		else
		{
			error += 1;
		}


	}

	cout << dec << a << ' ' << b << ' ' << c << ' ' << d << ' ' << e << ' ' << error << ' ' << pri << endl;



}



