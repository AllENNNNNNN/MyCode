objects = CommandResolverTest.o CommandResolver.o FileResolverTest.o FileResolver.o IPInfo.o
runTest : $(objects)
	g++ -o runTest $(objects) -I/root/projects/warm/  -L/usr/lib/ -lgtest_main -lpthread  -lboost_program_options-gcc41-mt
CommandResolverTest.o:CommandResolverTest.cpp ../warm/CommandResolver.h
	g++ -c CommandResolverTest.cpp 
CommandResolver.o:../warm/CommandResolver.cpp ../warm/CommandResolver.h
	g++ -c ../warm/CommandResolver.cpp -I/root/projects/warm/
FileResolverTest.o:FileResolverTest.cpp ../warm/FileResolver.h 
	g++ -c FileResolverTest.cpp 
FileResolver.o:../warm/FileResolver.cpp ../warm/FileResolver.h ../warm/IPInfo.h ../warm/DNS.h
	g++ -c ../warm/FileResolver.cpp -I/root/projects/warm/
IPInfo.o:IPInfo.cpp IPInfo.h
	g++ -c IPInfo.cpp -I/root/projects/warm/
clean:
	rm runTest $(objects)
