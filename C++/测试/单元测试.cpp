#include "stdafx.h"
#include "CppUnitTest.h"
#include "../test1/Mytest.h"
#include "../test1/CRootFinder.h"
using namespace Microsoft::VisualStudio::CppUnitTestFramework;

namespace UnitTest1
{		
	TEST_CLASS(UnitTest)
	{
	public:
		
		
		TEST_METHOD(BasicTest)
		{
			CRootFinder rooter;
			Assert::AreEqual(
				// Expected value:  
				0.0,
				// Actual value:  
				rooter.SquareRoot(0.0),
				// Tolerance:  
				0.01,
				// Message:  
				L"Basic test failed",
				// Line number - used if there is no PDB file:  
				LINE_INFO());
		}//Verifies that two specified doubles are equal, or within the specified accuracy of each other. The assertion fails if they are not within the specified accuracy of each other. Displays a message if the assertion fails.
		TEST_METHOD(RangeTest)
		{
			CRootFinder rooter;
			for (double v = 1e-6; v < 1e6; v = v * 3.2)
			{
				double actual = rooter.SquareRoot(v*v);
				Assert::AreEqual(v, actual, v / 1000);
			}
		}

		// Verify that negative inputs throw an exception.  
		TEST_METHOD(NegativeRangeTest)
		{
			wchar_t message[200];
			CRootFinder rooter;
			for (double v = -0.1; v > -3.0; v = v - 0.5)
			{
				try
				{
					// Should raise an exception:  
					double result = rooter.SquareRoot(v);

					_swprintf(message, L"No exception for input %g", v);
					Assert::Fail(message, LINE_INFO());
				}
				catch (std::out_of_range ex)
				{
					continue; // Correct exception.  
				}
				catch (...)
				{
					_swprintf(message, L"Incorrect exception for %g", v);
					Assert::Fail(message, LINE_INFO());
				}
			}
		}


	};
}