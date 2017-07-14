
#include <iostream>
#include<vector>
#include<string>
#include<algorithm>
using namespace std;
bool isBrother( string s1,  string s2)
{
	if (s1==s2)
	{
		return false;
	}
	sort(s1.begin(), s1.end());
	sort(s2.begin(), s2.end());
	return s1 == s2;
}
int main()
{
	freopen("input.txt", "r", stdin);
	int n;
	while (cin>>n)
	{
		vector<string> v(n);
		for (size_t i = 0; i < n; i++)
		{
			cin >> v[i];
		}
		string s;
		int count;
		cin >> s;
		cin >> count;
		vector<string> brother;
		for (size_t i = 0; i < n; i++)
		{
			if (isBrother(s,v[i]))
			{
				brother.push_back(v[i]);
			}
		}

		sort(brother.begin(), brother.end());
		cout << brother.size() << endl; 
		if (count<=brother.size())
		{
			cout << brother[count - 1] << endl;
		}

	}
}