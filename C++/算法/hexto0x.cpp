//����wireshack��������������ת��Ϊ16��������
#include <iostream>
using namespace std;
int main()
{
	string s;
	int n=0;
	while(cin>>s)
	{
	    if(s.length()>2) continue;
	    cout<<"0x"<<s<<",  ";
	    
	    n++;
	    if(n%8==0)
	    cout<<endl;
	}
}