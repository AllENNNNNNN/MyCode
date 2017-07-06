#include <iostream>
#include<vector>
#include<stdio.h>
using namespace std;
int maxv = 0;
int minv=0;
void traceBack(int t, vector<int> &v, vector<int> &p, vector<int> &q, vector<bool> &isSelected,int sumMoney,int value)
{

	if (t<=0)
	{

		if (value>maxv)
		{
			maxv = value;
		}
		return;
	}
	t--;
	if (isSelected[t])
	{
		traceBack(t, v, p, q, isSelected, sumMoney, value);
	}
	else
	{
		if (sumMoney<v[t])
		{
			traceBack(t, v, p, q, isSelected, sumMoney, value);
		}
		else
		{
			if (q[t]==0)
			{
				isSelected[t] = true;
				traceBack(t, v, p, q, isSelected, sumMoney - v[t], value + v[t] * p[t]);
				isSelected[t] = false;
				traceBack(t, v, p, q, isSelected, sumMoney, value);
			}
			else if (q[t]!=0)
			{
				if (sumMoney >= (v[t] + v[q[t]]))
				{
					isSelected[t] = true;
					isSelected[q[t]] = true;
					traceBack(t, v, p, q, isSelected, sumMoney - v[t] - v[q[t]], value + v[t] * p[t] + v[q[t]] * p[q[t]]);
					isSelected[t] = false;
					isSelected[t] = false;
					traceBack(t, v, p, q, isSelected, sumMoney, value);
				}
				else
				{
					traceBack(t, v, p, q, isSelected, sumMoney, value);
				}

			}
		}
	}

}
	
int main()
{
	freopen("input.txt", "r", stdin);
	int sumMoney = 0;
	int goodsCount = 0;
	while (cin >> sumMoney >> goodsCount)
	{
		vector<int> v(goodsCount + 1, 0);
		vector<int> p(goodsCount + 1, 0);
		vector<int> q(goodsCount + 1, 0);
		vector<bool> isSelected(goodsCount + 1, 0);
		vector<vector<int>> m(goodsCount);
		for (size_t i = 0; i < m.size(); i++)
		{
			vector<int> temp(sumMoney + 1,0);
			m[i] = temp;
		}
		for (int i = 1; i <= goodsCount; i++)
		{
			cin >> v[i] >> p[i] >> q[i];
		}
	
		traceBack(goodsCount+1, v, p, q, isSelected, sumMoney, 0);
		cout << maxv << endl;



	}

}