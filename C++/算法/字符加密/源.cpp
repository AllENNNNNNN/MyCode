
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
	string key;
	string data;
	while (cin>>key>>data)
	{
		key += "abcdefghijklmnopqrstuvwxyz";
		string temp;
		for (size_t i = 0; i < key.size(); i++)
		{
			if (temp.find(key[i])==string::npos)
			{
				temp.push_back(key[i]);
			}
		}
		
		//cout << temp << endl;
		//cout << temp.size() << endl;
		for (size_t i = 0; i < data.size(); i++)
		{
			cout << (char)(isalpha(data[i]) ? temp[data[i] - 'a'] : data[i]);
		}
		cout << endl;
	}
}