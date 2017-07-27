
#include <iostream>
#include <algorithm>
#include <string>
#include<cmath>
#include<vector>
#include<map>
#include<cctype>

#include<istream>

using namespace std;
int main()
{
	//freopen("input.txt", "r", stdin);
	string s;
	int p1, p2, p3;
	while (cin >> s >> p1 >> p2 >> p3)
	{
		if (p1!=1&&p1!=2&&p1!=3)
		{
			cout << "ERROR" << endl;
			continue;
		}
		if (p2<0)
		{
			cout << "ERROR" << endl;
			continue;
		}
		if (p3!=1&&p3!=2)
		{
			cout << "ERROR" << endl;
			continue;
		}
		int index = -1;
		int count = 0;
		for (size_t i = 0; i < s.size(); i++)
		{
			if (s[i] == '-')
			{
				index = i;
				count++;
			}

		}
		if (count != 1)
		{
			cout << "ERROR" << endl;
			continue;
		}
		if (index == -1 || index == 0 || index == s.size() - 1)
		{
			cout << "ERROR" << endl;
			continue;
		}
		char pre = s[index - 1];
		char bra = s[index + 1];

		string substr;
		if (isdigit(pre) && isdigit(bra) && bra>pre)
		{
			for (char i = pre + 1; i < bra; i++)
			{
				substr.push_back(i);
			}
		}
		else if (islower(pre) && islower(bra) && bra>pre)
		{
			if (p1 == 1)
			{
				for (char i = pre + 1; i < bra; i++)
				{
					substr.push_back(i);
				}
			}
			else
			{
				for (char i = pre + 1; i < bra; i++)
				{
					substr.push_back(toupper(i));
				}
			}

		}
		else
		{
			cout << "ERROR" << endl;
			continue;
		}
		if (p3 == 2)
		{
			reverse(substr.begin(), substr.end());
		}

		for (size_t i = 0; i < index; i++)
		{
			cout << s[i];
		}
		for (size_t i = 0; i < substr.size(); i++)
		{
			for (size_t j = 0; j < p2; j++)
			{
				if (p1 == 3)
				{
					cout << "*";
				}
				else
				{
					cout << substr[i];
				}
			}
		}
		for (size_t i = index + 1; i < s.size(); i++)
		{
			cout << s[i];
		}
		cout << endl;


	}
}