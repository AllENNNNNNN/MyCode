/*
����Ͱ�2018���＾��Ƹ�з�����ʦ��̲�����
1. ���˰�һ������Ӥ��(һ��һĸ��Ϊһ��)�ŵ�һ���ĵ��ϣ�����֮����������һ��С�ã�֮��ʼÿ�궼������һ��С�á����µ�С���ֻ���ͬ���ķ�ʽ������ֳ��
2. ���ӵ���������x(x>=3)�꣬�������������һ�겻��ֳ��
3. ������ϵ����Ӷ���10�ԣ���ô���˻�ÿ������������ɷ�ֳ��������֮�󣬴ӵ��ϴ����������ϵ����ӡ�
����y��(y>=3)��ĵ������е����Ӽ�����������?(ע��, ������3ִ����֮��)

����: ������������������������һ����x���ڶ�����y
���: y���ĵ������е������������ܺ�
*/
#include <iostream>
#include <algorithm>
#include <string>
#include<cmath>
#include<vector>
#include<map>
#include<cctype>
#include<queue>
#include<stack>
using namespace std;

void jian1(vector<int> &v, int x)
{
	int new_count = 0;
	int dead_count = 0;
	for (int i = 0; i < v.size(); i++)
	{
		v[i]--;
		if (v[i] == 0)
		{
			dead_count++;
			continue;
		}
		if (x - v[i] >= 2)
		{
			new_count++;
		}
	}
	v.assign(v.begin() + dead_count, v.end());
	for (int i = 0; i < new_count; i++)
	{
		v.push_back(x);
	}
	if (v.size() > 10)
	{
		v.assign(v.begin() + 2, v.end());
	}
}

int main()
{
	//freopen("input.txt", "r", stdin);
	int x, y;
	while (cin >> x >> y)
	{
		vector<int> v;
		v.push_back(x);
		for (int i = 1; i <= y; i++)
			jian1(v, x);

		int result = 0;

		for (int i = 0; i < v.size(); i++)
		{
			//cout <<x- v[i] << ' ';
			result += (x - v[i]);
		}

		//cout << endl;

		cout << result * 2 << endl;
	}
}