#include <ctime>
#include <iostream>
#include <string>
#include <boost/array.hpp>
#include <boost/asio.hpp>

#include<inttypes.h>
using boost::asio::ip::udp;

std::string make_daytime_string()
{
	using namespace std; // For time_t, time and ctime;
	time_t now = time(0);
	return ctime(&now);
}

int main()
{
	try
	{
		boost::asio::io_service io_service;

		udp::socket socket(io_service, udp::endpoint(udp::v4(), 53));

		for (;;)
		{
			uint8_t buffer[1024] = { 0 };
			udp::endpoint remote_endpoint;
			boost::system::error_code error;
			socket.receive_from(boost::asio::buffer(buffer),
				remote_endpoint, 0, error);

			uint8_t *dnsQuery = buffer + 12;
			int n = 0;
			while ((n=*dnsQuery++)!=0)
			{
				while (n--)
				{
					std::cout << *dnsQuery++;
				}
				std::cout << ".";
			}
			std::cout << std::endl;
			
			if (error && error != boost::asio::error::message_size)
				throw boost::system::system_error(error);

			std::string message = make_daytime_string();
		
			boost::system::error_code ignored_error;
			socket.send_to(boost::asio::buffer(message), remote_endpoint, 0, ignored_error);
		}
	}
	catch (std::exception& e)
	{
		std::cerr << e.what() << std::endl;
	}

	return 0;
}
