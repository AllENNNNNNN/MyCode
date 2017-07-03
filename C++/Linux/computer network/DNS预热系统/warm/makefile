objects=main.o IPInfo.o FileResolver.o DNSBuilder.o CommandResolver.o RawSocketSender.o IPBuilder.o UDPBuilder.o
warm:$(objects)
	g++ -o warm $(objects) -L/usr/lib/ -lboost_program_options-gcc41-mt
main.o:main.cpp FileResolver.h DNS.h DNSBuilder.h CommandResolver.h
	g++ -c main.cpp
IPInfo.o:IPInfo.cpp IPInfo.h 
	g++ -c IPInfo.cpp
FileResolver.o:FileResolver.cpp FileResolver.h IPInfo.h DNS.h
	g++ -c FileResolver.cpp
DNSBuilder.o:DNSBuilder.cpp DNSBuilder.h DNS.h
	g++ -c DNSBuilder.cpp
CommandResolver.o:CommandResolver.cpp CommandResolver.h IPInfo.h
	g++ -c CommandResolver.cpp
RawSocketSender.o:RawSocketSender.cpp RawSocketSender.h
	g++ -c RawSocketSender.cpp
IPBuilder.o:IPBuilder.cpp IPBuilder.h UDPBuilder.h IPInfo.h
	g++ -c IPBuilder.cpp
UDPBuilder.o:UDPBuilder.cpp UDPBuilder.h DNS.h
	g++ -c UDPBuilder.cpp
clean:
	rm warm $(objects)