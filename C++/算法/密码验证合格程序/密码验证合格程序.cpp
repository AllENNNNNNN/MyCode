#include<iostream>
#include<string>
#include<cctype>
using namespace std;
int main()
{
	//freopen("input.txt", "r", stdin);
	//freopen("output.txt", "w", stdout);
	
	string s;
	int c = 1;
	while (cin>>s)
	{
		//cout << s << ' ' << c << endl;
		c++;
		bool OK = true;
		bool up = false, low = false, other = false, digit = false;
		if (s.size()<=8)
		{
			cout << "NG" << endl;
		
			continue;
		}
		for (int i = 0; i<s.size(); i++)
		{
			if (i + 3 <= s.size())
			{
				if (s.find(s.substr(i, 3), i + 1) != -1)
				{
					OK = false;
				}
			}
			if (isdigit(s[i])) digit = true;
			if (ispunct(s[i])) other = true;
			if (isupper(s[i])) up = true;
			if (islower(s[i])) low = true;
		}
		if (!OK)
		{
			cout << "NG" << endl;
		
			continue;
		}
		int i = (int)digit + other + up + low;
		if (i >= 3)
		{
			cout << "OK" << endl;
		}
		else
		{
			cout << "NG" << endl;
		}
	}


}