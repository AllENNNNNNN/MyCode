/*

�������� 2018У�� Ӧ�������������ʦ��C/C++�����������߿���
����� | 10.0�� 1/2
����ȼ�
ʱ�����ƣ�C/C++���� 3000MS���������� 5000MS
�ڴ����ƣ�C/C++���� 65536KB���������� 589824KB
��Ŀ������
�û��������Ϊ4���ȼ������嶨�����£�
�ȼ�0������С��8λ/�������û���һ�����෴/ֻ����4���ַ��е�����һ��
�ȼ�1�����ڵ���8λ���������ַ��������Ϊ(����+Сд��ĸ)��(����+��д��ĸ)
�ȼ�2�����ڵ���8λ���������ַ�������ϲ���Ϊ(����+Сд��ĸ)��(����+��д��ĸ)
�ȼ�3�����ڵ���8λ�������������ַ�
����4���ַ�Ϊ�����֣�Сд��ĸ����д��ĸ�������ַ�(�������֣�Сд��ĸ����д��ĸ����ַ�)
����
��һ�������û��� ���룬�û��������ÿո�ֿ�(�����в�������ո�)
���
�����������ǿ��

��������
admin 112233
�������
0

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
#include<math.h>
using namespace std;

int class_count(const string &s)
{
	int flag = 0;
	for (char c : s)
	{
		if (isdigit(c))
		{
			flag |= 0x1;
			continue;
		}

		if (islower(c))
		{
			flag |= 0x2;
			continue;
		}
		if (isupper(c))
		{
			flag |= 0x4;
			continue;
		}
		flag |= 0x8;
	}
	return flag;
}

bool is_match(string password, string username)
{
	if (password == username) return true;
	reverse(username.begin(), username.end());
	return password == username;
}
int main()
{
	freopen("input.txt", "r", stdin);
	string username, password;
	while (cin>>username>>password)
	{

		int flag = class_count(password);
		
		if (flag == 1 || flag == 2 || flag == 4 || flag == 8 || password.size() < 8 || is_match(username,password))
		{
			cout << 0 << endl;
			continue;
		}

		if (password.size() >= 8 && (flag == 3 || flag == 5))
		{
			cout << 1 << endl;
			continue;
		}

		if (password.size() >= 8 && (flag == 9 || flag == 6 || flag == 10 || flag == 12))
		{
			cout << 2 << endl;
			continue;
		}

		if (password.size() >= 8 && (flag >= 7))
		{
			cout << 3 << endl;
			continue;
		}



	}
	
}
