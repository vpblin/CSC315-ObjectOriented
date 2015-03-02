#include "Base.h"
#include "Derive.h"
#include <iostream>

int main(int argc, char** argv)
{
	Base h;
	h.print();
	
	Derive d;
	d.print();

	Derive d1(10);
	return 0;
}
