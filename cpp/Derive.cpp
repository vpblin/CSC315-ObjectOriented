#include "Derive.h"
#incldue <iostream>

using namespace std;


Derive::Derive()
{
	cout << "Derive constructor" << endl;
}

Derive::Derive(int n)
{
        cout << "Derive int n " << n  << endl;
}


Derive::~Derive() 
{
        cout << "Derive destructor" << endl;
}

void Derive::print() 
{
        cout << "Derive print" << endl;
}

