#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
#include<map>
using namespace std;
class error
{
public:
	string name;
	int line;
	int count;
	error(string n, int l)
	{
		name = n;
		line = l;
		count=1;
	}
	bool operator <(const error &e2) const
	{
		{
			if (name<e2.name)
			{
				return true;
			}
			else if (name == e2.name)
			{
				return line<e2.line;
			}
			else
			{
				return false;
			}
		}
	}

};
bool compareByValue(const pair<error, int>  p1, const pair<error, int>  p2)
{
	return p1.second>p2.second;
}
int main()
{

	string name;
	int line;
	vector<error> v;
	while (cin >> name >> line)
	{
		for (int pos = name.size() - 1; pos >= 0; pos--)
		{
			if (name[pos] == '\\')
			{
				name = name.substr(pos + 1, name.size() - pos);
				break;
			}
		}
	//	int i=(v.size()>8?(v.size()-8):0);
	int i=0;
		for( ;i<v.size();i++)
		{
		    if(v[i].name==name&&v[i].line==line)
		    {
		        v[i].count++;
		        break;
		    }
		}
		if(i==v.size())
		{
		    v.push_back(error(name,line));
		}
		    
	}
	int i=(v.size()>8?v.size()-8:0);
	
	for(;i<v.size();i++)
	{
	   
	    cout<<(v[i].name.size()>16?v[i].name.substr(v[i].name.size()-16,16):v[i].name)<<' '<<v[i].line<<' '<<v[i].count<<endl;
	}

}