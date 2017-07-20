
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
	//freopen("input.txt", "r", stdin);
	string s;
	while (cin>>s)
	{
		int n = s.size();
		int max = 0;
		for (size_t i = 0; i < n; i++)
		{
			int j = i-1, k = i+1;
			int count = 1;
			while (j >= 0 && k < n&&s[j--]==s[k++])
			{
				count+=2;
			}
			max = max > count ? max : count;
			j = i; k = i + 1;
			count = 0;
			while (j >= 0 && k < n&&s[j--] == s[k++])
			{
				count += 2;
			}
			max = max > count ? max : count;
		}
		cout << max << endl;
	}
}