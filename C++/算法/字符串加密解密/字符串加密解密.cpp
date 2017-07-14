
#include <iostream>
#include <algorithm>
#include <string>
#include<cmath>
#include<vector>
#include<map>
using namespace std;
string A = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
string B = "bcdefghijklmnopqrstuvwxyzaBCDEFGHIJKLMNOPQRSTUVWXYZA2345678901";
map<char, char> AB, BA;
void getPassword(string  &s)
{
	for (size_t i = 0; i < s.size(); i++)
	{
		s[i] = AB[s[i]];
	}
}
void getResult(string &s)
{
	for (size_t i = 0; i < s.size(); i++)
	{
		s[i] = BA[s[i]];
	}
}
int main()
{
	freopen("input.txt", "r", stdin);
	for (size_t i = 0; i < 62; i++)
	{
		AB[A[i]] = B[i];
		BA[B[i]] = A[i];
	}
	string s;
	while (cin >> s)
	{
		getPassword(s);
		cout << s << endl;
		cin >> s;
		getResult(s);
		cout << s << endl;
	}
	return 0;
}