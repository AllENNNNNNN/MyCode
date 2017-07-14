
#include <iostream>
#include<vector>
#include<string>
#include<algorithm>
using namespace std;
bool compare(const string &a, const string &b)
{
	if (a.size() == b.size())
		return a<b;
	return a.size()<b.size();
}
int main()
{
	//freopen("input.txt", "r", stdin);
	int m, n;
	while (cin >> m)
	{
		vector<string> I(m);
		for (int i = 0; i < m; i++)
		{
			cin >> I[i];
		}
		cin >> n;
		vector<string> R(n);
		for (int i = 0; i < n; i++)
		{
			cin >> R[i];
		}
		sort(R.begin(), R.end(), compare);

		vector<string> result;
		for (size_t i = 0; i < R.size(); i++)
		{
			if (i != 0 && R[i] == R[i - 1])
			{
				continue;
			}
			int count = 0;
			int start = 0;
			for (size_t j = 0; j < I.size(); j++)
			{
				if (I[j].find(R[i]) != string::npos)
				{
					if (count == 0)
					{
						result.push_back(R[i]);
						start = result.size();
						result.push_back("");
					}
					result.push_back(to_string(j));
					result.push_back(I[j]);

					count++;
				}
			}
			if (count != 0)
			{
				result[start] = to_string(count);
			}
		}
		cout << result.size();
		for (size_t i = 0; i < result.size(); i++)
		{
			cout << ' ' << result[i];
		}
		cout << endl;
	}
}