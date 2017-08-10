//#include "header.h"	//AnycodeX includes the header.h by default, needn't cancle the notation.
#include <iostream>
#include <algorithm>
#include <string>
#include<cmath>
#include<vector>
#include<map>
#include<cctype>

using namespace std;

//ð������ÿ�αȽ����ڵ�����Ԫ�أ����˳�����㽻��֮
void bubble_sort(vector<int> &v)
{
	for (int i = 0; i < v.size() - 1; i++)
	{
		for (int j = 0; j < v.size() - 1 - i; j++)
		{
			if (v[j] > v[j + 1])
			{
				swap(v[j], v[j + 1]);
			}
		}
	}
}

//ð������Ľ��棬���ñ�־λ��һ��һ�˱Ƚ�û����Ҫ����Ԫ�صĲ������������ɹ�
//���Լ���ԭ����������еıȽϴ���
void bubble_sort_s(vector<int> &v)
{
	for (int i = 0; i < v.size() - 1; i++)
	{
		bool flag = 1;
		for (int j = 0; j < v.size() - 1 - i; j++)
		{
			if (v[j] > v[j + 1])
			{
				swap(v[j], v[j + 1]);
				flag = 0;
			}
		}
		if (flag) break;
	}
}

//ð������ڶ��ָĽ�����¼���һ�η����ı��λ�á����λ��֮��Ķ����Ѿ��ź����
void bubble_sort_s2(vector<int> &v)
{
	int pos = v.size() - 1;
	int last_change = 0;
	while (pos > 0)
	{
		last_change = 0;
		for (int i = 0; i < pos; ++i)
		{
			if (v[i] > v[i + 1])
			{
				swap(v[i], v[i + 1]);
				last_change = i;
			}
		}
		pos = last_change;
	}
}

//ð����������ָĽ���˫·����
void bubble_sort_s3(vector<int> &v)
{
	for (int i = 0; i < v.size() - 1; i++)
	{
		for (int j = 0; j < v.size() - 1 - i; j++)
		{
			if (v[j] > v[j + 1])
			{
				swap(v[j], v[j + 1]);
			}
		}
		for (int j = v.size() - 2 - i; j > 0; --j)
		{
			if (v[j] < v[j - 1])
			{
				swap(v[j], v[j - 1]);
			}
		}
	}


}


//���������㷨
/*
�м��ָĽ��취��
1.�ڵݹ�С��һ���̶ȵ�ʱ�򣬲��ò��������㷨
2.ѡȡ��λ����Ϊkeyֵ������˳��ͳ����˵���нϴ������
3.�����������Ϊkeyֵ�����������ƽ�����Ӷ�
4.�����м�����˵���λ����Ϊkeyֵ��ƽ��������14%����
*/
void quick_sort(vector<int> &v, int left, int right)
{
	if (left >= right) return;
	int temp = v[left];
	int l = left;
	int r = right;
	while (left < right)
	{
		while (left < right&&v[right] >= temp) right--;
		v[left] = v[right];
		while (left < right&&v[left] <= temp)left++;
		v[right] = v[left];
	}
	v[left] = temp;
	quick_sort(v, l, left - 1);
	quick_sort(v, left + 1, r);
}

//��������
/*
�Ľ�����
1.���ֲ��Ҳ���
*/
void insert_sort(vector<int> &v)
{
	for (int i = 1; i < v.size(); i++)
	{
		int value = v[i];
		for (int j = i; j > 0; j--)
		{
			if (v[j - 1] > value)
			{
				v[j] = v[j - 1];
			}
			else
			{
				v[j] = value;
				break;
			}
		}
	}
}

//ѡ������
/*
�Ľ�����
1.��Ԫѡ������ÿ�α���ѡ�����ֵ����Сֵ
*/
void select_sort(vector<int> &v)
{
	for (int i = 0; i < v.size(); i++)
	{
		int min = v[i];
		int pos = i;
		for (int j = i + 1; j < v.size(); j++)
		{
			if (min > v[j])
			{
				min = v[j];
				pos = j;
			}
		}
		swap(v[i], v[pos]);
	}
}

void print(const vector<int> v)
{
	for (size_t i = 0; i < v.size(); i++)
	{
		cout << v[i] << ' ';
	}
	cout << endl;
}
int main()
{
	int my_array[] = { 0,3,5,7,1,8,6,4,2,9 };
	vector<int> v(my_array, my_array + 10);
	select_sort(v);

	print(v);

}