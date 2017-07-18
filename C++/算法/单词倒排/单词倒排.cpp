
#include <iostream>
#include <algorithm>
#include <string>
#include<cmath>
#include<vector>
#include<map>
#include<cctype>
using namespace std;

int main()
{
	freopen("input.txt", "r", stdin);
	char c;
	vector<string> v;
	string s;
	while ((c=getchar())!=EOF)
	{
		//cout << c << endl;
		if (isalpha(c))
		{
			s.push_back(c);
		}
		else
		{
			if (s.empty())
			{
				continue;
			}
			else
			{
				v.push_back(s);
				s.clear();
			}
		}
	}
	if (!s.empty())
	{
		v.push_back(s);
	}
	for (int i = v.size()-1; i >0; i--)
	{
		cout << v[i] << ' ';
	}
	cout<<v[0] << endl;
}