//#include "header.h"	//AnycodeX includes the header.h by default, needn't cancle the notation.
#include <iostream>
#include <algorithm>
#include <string>
#include<cmath>
#include<vector>
#include<map>
#include<cctype>
#include<queue>
#include<stack>
using namespace std;
/*
����������ʵ��ջ��
һ������������ݣ�һ��Ϊ��
��������ʱ��ֱ�Ӳ��������ݵĶ���
��������ʱ����������ݵĶ���һֱ������ԭ��Ϊ�յ��Ǹ������ֱ��ԭ�ȴ�����ݵĶ���ֻʣ�����һ�����ݣ���������
			Ȼ���ٽ�ԭ��Ϊ�յĶ����е��������ݵ�����ԭ������������ݵĶ���
*/
class MyStack
{
private:
	queue<int> q1;
	queue<int> q2;
public:
	int pop()
	{
		while (q1.size() > 1)
		{
			q2.push(q1.front());
			q1.pop();
		}
		int result = q1.front();
		q1.pop();

		while (q2.size())
		{
			q1.push(q2.front());
			q2.pop();
		}
		return result;
	}
	void push(int n)
	{
		q1.push(n);
	}


	/* ��Ϊ��Ч������ ���÷�������*/
	void push2(int n)
	{
		if (q1.size())
		{
			q1.push(n);
		}
		else
		{
			q2.push(n);
		}
	}
	int pop2()
	{
		int result;
		if (q1.size())
		{
			while (q1.size() > 1)
			{
				q2.push(q1.front());
				q1.pop();
			}
			result = q1.front();
			q1.pop();

			while (q2.size())
			{
				q1.push(q2.front());
				q2.pop();
			}
		}
		else
		{
			while (q2.size() > 1)
			{
				q1.push(q2.front());
				q2.pop();
			}
			result = q2.front();
			q2.pop();

			while (q1.size())
			{
				q2.push(q1.front());
				q1.pop();
			}
		}
		return result;

	}


};

class MyQueue
{
private:
	stack<int> s1;
	stack<int> s2;
public:
	void push(int n)
	{
		s1.push(n);
	}

	int pop()
	{
		while (s1.size() > 1)
		{
			s2.push(s1.top());
			s1.pop();
		}
		int result = s1.top();
		s1.pop();
		while (s2.size())
		{
			s1.push(s2.top());
			s2.pop();
		}
		return result;
	}
	/*��Ϊ��Ч������ ���Բ��÷�������*/
	int pop2()
	{
		int result;
		if (s2.size())
		{
			result = s2.top();
			s2.pop();
		}
		else
		{
			while (s1.size() > 1)
			{
				s2.push(s1.top());
				s1.pop();
			}
			result = s1.top();
			s1.pop();
		}
		return result;
	}
};



int main()
{
	MyStack mystack;
	mystack.push2(1);
	mystack.push2(2);
	mystack.push2(3);
	cout << mystack.pop2() << endl;
	mystack.push2(4);
	cout << mystack.pop2() << endl;
	cout << mystack.pop2() << endl;

	MyQueue myqueue;
	myqueue.push(1);
	myqueue.push(2);
	myqueue.push(3);
	cout << myqueue.pop2() << endl;
	myqueue.push(4);
	cout << myqueue.pop2() << endl;
	cout << myqueue.pop2() << endl;

}