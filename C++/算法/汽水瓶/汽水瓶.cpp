
//有更简便的算法
#include<iostream>
#include<string>
#include<cctype>
#include<map>
using namespace std;
int main()
{
    int n;
    while(cin>>n)
    {
        int count=0;
        while(n/3>=1)
        {
            count+=n/3;
            n=n/3+n%3;
        }
        if(n==2) count++;
        cout<<count<<endl;
        
    }

	
}