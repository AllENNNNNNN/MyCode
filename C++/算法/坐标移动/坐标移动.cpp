#include<iostream>
#include<vector>
#include<string>
#include<cctype>
#include<stdlib.h>
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
bool isHefa(string s)
{
    if(s.size()<=1)
    {
        return false;
    }
    if(s[0]!='W'&&s[0]!='A'&&s[0]!='S'&&s[0]!='D')
    {
        return false;
    }
    for(int i=1;i<s.size();i++)
    {
        if(!isdigit(s[i]))
        {
            return false;
        }
    }
    
    return true;
}

int main()
{
    string s;
    while(cin>>s)
    {
     int x=0,y=0;
     vector<string> v=split(s,";");
     for(int i=0;i<v.size();i++)
     {
        if(!isHefa(v[i])) continue;
        int n=atoi(v[i].substr(1,v[i].size()).c_str());
        switch(v[i][0])
        {
            case 'W':y+=n;break;
            case 'A':x-=n;break;
            case 'S':y-=n;break;
            case 'D':x+=n;break;
        }
     }
     cout<<x<<','<<y<<endl;
    }
}