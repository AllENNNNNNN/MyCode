
#ifndef DNS_SHRINK_VIEW_NODE_H
#define DNS_SHRINK_VIEW_NODE_H


#include<vector>
#include<string>
#include<iostream>
struct ViewNode
{
	ViewNode *father_ptr;
	std::vector<ViewNode *> son_ptrs;
	std::string node_name;
	std::string father_name;
	std::string config;
	std::string domain_name;

	ViewNode()
	{
		father_ptr = NULL;
	}

	void init_node()
	{
		config.clear();
		domain_name.clear();
	}

	bool operator <(const ViewNode &v)const //�˴�һ��Ҫ��const����
	{
		if(node_name.size()==v.node_name.size())
		return this->node_name < v.node_name;
		return node_name.size() < v.node_name.size();
	}
	inline	friend std::ostream &operator <<(std::ostream &out, const ViewNode &v);
};
//��ͷ�ļ��ж���ĺ���һ��Ҫ��inline���Σ��������ֶඨ��Ĵ���
inline std::ostream &operator <<(std::ostream &out, const ViewNode &v)
{
	out << v.domain_name << ' ' << v.node_name << ' ' << v.config;
	return out;
}
#endif // !DNS_SHRINK_VIEW_NODE_H
