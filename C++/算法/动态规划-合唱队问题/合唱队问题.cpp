//#include "header.h"	//AnycodeX includes the header.h by default, needn't cancle the notation.
#include <iostream>
#include<vector>
#include <algorithm>
using namespace std;
void fun(vector<int> & v,vector<int> &s)
{
    for(int i=1;i<v.size();i++)
    {
        for(int j=i-1;j>=0;j--)
        {
            if(v[i]>v[j]&&s[i]<s[j]+1)
              s[i]=s[j]+1;
        }
    }
}
int main()
{
	int n;
	while(cin>>n)
	{
	    vector<int> v(n);
	    for(int i=0;i<n;i++)
	    cin>>v[i];
	    int max=0;
	    vector<int> up(n,1);
	    vector<int> down(n,1);
	    fun(v,up);
	    reverse(v.begin(),v.end());
	    fun(v,down);
	    reverse(down.begin(),down.end());
	    for(int i=0;i<n;i++)
	    max=max>(up[i]+down[i])?max:(up[i]+down[i]);
	    cout<<n-max+1<<endl;
	}
}