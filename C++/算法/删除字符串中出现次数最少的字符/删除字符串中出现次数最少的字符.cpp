#include<iostream>
#include<string>
#include<algorithm>
#include<cctype>
#include<vector>
#include<map>
using namespace std;
bool compare( const pair<char,int> & p1,const pair<char,int> &p2)
{
    return p1.second<p2.second;
}
int main()
{
    string s;
    while(cin>>s)
    {
        if(s.size()<=2)
        {
            cout<<""<<endl;
            continue;
        }
        map<char,int> m;
        for(int i=0;i<s.size();++i)
        {
            m[s[i]]++;
        }
        vector<pair<char,int> >v(m.begin(),m.end());
        m.clear();
        sort(v.begin(),v.end(),compare);
        m[v[0].first]=1;
        for(int i=1;i<v.size();i++)
        {
            if(v[i].second==v[i-1].second)
            {
                m[v[i].first]=1;
            }
            else
            {
                break;
            }
            
        }
        for(int i=0;i<s.size();i++)
        {
            if(m.count(s[i]))
            {
                continue;
            }
            else
            {
                cout<<s[i];
            }
        }
        cout<<endl;
        
    }
	
}