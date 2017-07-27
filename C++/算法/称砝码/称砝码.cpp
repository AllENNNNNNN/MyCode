
#include <iostream>
#include <algorithm>
#include <string>
#include<cmath>
#include<vector>
#include<map>
#include<cctype>
#include<set>
using namespace std;


int main()
{
	freopen("input.txt", "r", stdin);
	int n;
	while (cin>>n)
	{
		vector<int> weight(n);
		vector<int> nums(n);
		for (size_t i = 0; i < n; i++)
		{
			cin >> weight[i];
		}
		for (size_t i = 0; i < n; i++)
		{
			
			cin >> nums[i];
		}
		vector<int> all;
		for (size_t i = 0; i < n; i++)
		{
			for (size_t j = 0; j < nums[i]; j++)
			{
				all.push_back(weight[i]);
			}
		}
		
		vector<int> temp;
		set<int> result;
		result.insert(0);
		for (size_t i = 0; i < all.size(); i++)
		{
			
			for( int n:result)
			{
				temp.push_back(n + all[i]);
			}
			for (int  n :temp)
			{
				
				result.insert(n);
			}
			temp.clear();
		}
		cout << result.size() << endl;
	}
}