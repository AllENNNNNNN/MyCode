#include<iostream>




#include"command_resolver.h"
#include"file_handler.h"
#include<boost/unordered_map.hpp>  


int main(int argc, char *argv[])
{
	//����������
	CommandResolver command_resolver;
	FileHandler file_handler;

	std::vector<std::vector<ViewNode> > cv_tree_vector;
	boost::unordered_map<std::string, int> name_to_index;
	boost::unordered_set<ViewNode*> r2th_node_ptrs;

	ViewNode *head=NULL;
	if (!command_resolver.resolve_command(argc, argv))
	{
		exit(-1);
	}

	

	//���CV�����ܽ����
	int cv_tree_size = file_handler.get_cv_tree_size(command_resolver.get_cv_file_name());
	std::vector<ViewNode> cv_tree(cv_tree_size + 1, ViewNode());

	//��ȡCV�ļ��γ�CV��
	file_handler.resolve_cv(command_resolver.get_cv_file_name(), cv_tree, name_to_index,head);
	

	//��ȡdn���ݲ���������
	file_handler.resolver_dn(command_resolver.get_dn_file_name(),cv_tree, name_to_index, head);



}

