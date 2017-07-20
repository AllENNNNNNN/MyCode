
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
	int n;
	while (cin>>n)
	{
		int startY = 1;
		for (size_t i = 0; i <n; i++)
		{
		    startY += i;
			int startX = startY;
			cout << startX;
			for (size_t j = 1; j < n-i; j++)
			{
				startX += i + j + 1;
				cout << ' ' << startX;
			}
			cout << endl;
		}
	}
}