/*

�������� 2018У�� Ӧ�������������ʦ��C/C++�����������߿���
����� | 10.0�� 2/2
�ַ����ָ�
ʱ�����ƣ�C/C++���� 3000MS���������� 5000MS
�ڴ����ƣ�C/C++���� 65536KB���������� 589824KB
��Ŀ������
����һ���ַ������ָ������ַ����ͷָ���֮���Կո�ֿ�(�ָ����в�������ո�)Ҫ����ݸ÷ָ������в�֣�ÿ��С���ַ������Ϊһ�С�
����
��һ������ԭʼ�ַ��� �ָ�����ԭʼ�ַ����ͷָ����ո�ֿ�(�ָ����в�������ո�)
���
����ָ��ú��ÿ���ַ�����ÿ���ַ����Ի��з��ֿ�

��������
abc,def,ghi,jkl ,
�������
abc
def
ghi
jkl

��ܰ��ʾ
�뾡����ȫ�����Խ���10����ǰ���Գ��򣬷��������ܼ��Ŷ��ύ�����ܲ�ѯ����������
��������ԡ���ɱ������
��������ʹ�ñ��ر���������ҳ�治��¼��������
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

std::vector<std::string> split(std::string str, std::string pattern)
{
	std::string::size_type pos;
	std::vector<std::string> result;
	str += pattern;
	int size = str.size();

	for (int i = 0; i<size; i++)
	{
		pos = str.find(pattern, i);
		if (pos<size)
		{
			std::string s = str.substr(i, pos - i);
			result.push_back(s);
			i = pos + pattern.size() - 1;
		}
	}
	return result;
}
int main()
{
	freopen("input.txt", "r", stdin);
	string s1, s2;
	while (cin>>s1>>s2)
	{
		vector<string> result = split(s1, s2);
		for (string s : result)
		{
			cout << s << endl;
		}

	}
	
}
