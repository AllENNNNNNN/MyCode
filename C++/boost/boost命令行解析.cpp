
#include <iostream>  
#include<string>
#include <boost/thread/thread.hpp>  
#include<boost/program_options.hpp>
#include<boost\foreach.hpp>
void print_vm(boost::program_options::options_description &opts,boost::program_options::variables_map &vm)
{
	if (vm.size() == 0)
	{
		std::cout << opts << std::endl;
		return;
	}
	if (vm.count("help"))
	{
		std::cout << opts << std::endl;//输出帮助信息
	}
	//输出查找文件名，因为它有缺省值，故总是存在
	std::cout << "find opt::" << vm["filename"].as<std::string>() << std::endl;
	if (vm.count("dir"))
	{
		std::cout << "dir toor:";
		BOOST_FOREACH(std::string str, vm["dir"].as<std::vector<std::string>>())
		{
			std::cout << str << ",";
		}
		std::cout << std::endl;
	}

	if (vm.count("depth"))
	{
		std::cout << "depth opt:" << vm["depth"].as<int>() << std::endl;
	}
}

int main(int argc,char *argv[])
{
	boost::program_options::options_description opts("demo options");
	std::string filename;
	opts.add_options()
		("help,h", "help message\n a bit of long text")//帮助选项，使用空格缩进格式
		//文件名选项，值可存储到外部，缺省值是test
		("filename,f", boost::program_options::value<std::string>(&filename)->default_value("test"), "to find a file")
		//搜索路径选项，可以多次出现，可以接受多个记号
		("dir,D", boost::program_options::value<std::vector<std::string>>()->multitoken(), "search dir")
		//搜索深度选项，隐含值是5，短命与搜索路径不同
		("depth,d", boost::program_options::value<int>()->implicit_value(5), "search depth");

	boost::program_options::variables_map vm;
	try 
	{
		boost::program_options::store(boost::program_options::parse_command_line(argc, argv, opts), vm);
	}
	catch (...)
	{
		std::cout << "输入了未定义的选项!\n" << std::endl;
		return -1;
	}
	boost::program_options::notify(vm);//解析结果存储外部变量
	//解析完成，实现选项处理逻辑
	print_vm(opts, vm);
	
}