#include<iostream>
#include<vector>
#include<string>
using namespace std;

int main()
{
	freopen("sum.txt","r",stdin);//输入文件
	freopen("sumlable.txt", "w", stdout);//输出文件
	string s;
	int i = 0;
	while (getline(cin,s))
	{
		
		switch (i/1000)
		{
		
		case 0:s += " Buick"; break;
		case 1:s += " Chery"; break;
		case 2:s += " citroen"; break;
		case 3:s += " Honda"; break;
		case 4:s += " Hyundai"; break;
		case 5:s += " Lexu"; break;
		case 6:s += " Mazda";  break;
		case 7:s += " Peugeot"; break;
		case 8:s += " Toyota"; break;
		case 9:s += " VW"; break;

		}
		i++;
		cout << s+" 1"+" 1"+" 68"+" 68" << endl;
	}
}