objects = sqrt.o sqrt_unittest.o
runTest : $(objects)
	g++ - o runTest $(objects) - L / usr / lib / -lgtest_main - lpthread
	sqrt.o : sqrt.cpp sqrt.h
	g++ - c sqrt.cpp
	sqrt_unittest.o : sqrt_unittest.cpp
	g++ - c sqrt_unittest.cpp
	clean :
rm runTest $(objects)
