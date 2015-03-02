#pragma once
#include "Base.h"

class Derive : public Base
{

	public:
	Derive();
	Derive(int n);
	Virtual ~Derive();

	void print();
};
