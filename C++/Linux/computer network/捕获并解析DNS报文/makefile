objects=main.o
dns_whoami:$(objects)
	g++ -o dns_whoami $(objects)  -L/usr/lib/ -lboost_system-gcc41-mt
clean:
	rm -r dns_whoami $(objects)