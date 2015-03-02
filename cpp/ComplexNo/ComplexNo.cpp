#include <iostream>
#include <cmath>
#include "ComplexNo.h"

using namespace std;

ComplexNo::ComplexNo()
{
    r = 0.0; // setX(0.0);
    i = 0.0; // setY(0.0);
}

ComplexNo::ComplexNo(double r, double i)
{
  this->r = r;
  this->i = i;
}

ComplexNo::~ComplexNo()
{
}

void ComplexNo::print()
{
  cout << "(" << x << ", " << y << ", " << z << ")" << endl;
}

double ComplexNo::getR()
{
  return r;
}

double ComplexNo::getI()
{
  return i;
}


void ComplexNo::setR(double r)
{
  this->r = r;
}

void ComplexNo::setI(double i)
{
  this->i = i;
}

void ComplexNo::add(ComplexNo rhs)
{
  this->r += rhs.r;
  this->i += rhs.i;
}

string ComplexNo::toString()
{
    if(this->getI() >= 0){
return this->r + " + " + this->i+ ('i');
    else
return this->r + " - " + this->i+ ('i');
    }
}

ComplexNo ComplexNo::add(ComplexNo rhs){
		this->setR(this->getR() + rhs.getR());
		this->setI(this->getI() + rhs.getI());
		return this;
}

ComplexNo ComplexNo::sub(ComplexNo rhs){
		this->setR(this->getR() - rhs.getR());
		this->setI(this->getI() - rhs.getI());
		return this;
}

ComplexNo ComplexNo::mult(ComplexNo rhs){
		this->setR((this->getR() * rhs.getR()) - (this->getI() * rhs.getI()));
		this->setI((this->getR() * rhs.getI()) + (this->getI() * rhs.getR()));
		return this;
	}

ComplexNo ComplexNo::div(ComplexNo rhs){
		//unfinished
		if(rhs.getR() == 0 && rhs.getI() == 0){
			this->setI(0);
			this->setR(0);
		}else{
			this->setR((this->getR() * rhs.getR() + this->getI() * rhs.getR())/(std::pow(rhs.getR(), 2) + std::pow(rhs.getI(), 2)));
			this->setI((this->getI() * rhs.getR() - this->getR() * rhs.getI())/(std::pow(rhs.getR(), 2) + std::pow(rhs.getI(), 2)));
		}
		return this;
}

double ComplexNo::mag(){
		return std::sqrt(std::pow(this->getR(), 2) + std::pow(this->getI(), 2));
}
ComplexNo ComplexNo::conj(){
		//unfinished
		this->setI(this->getI() * -1);
		return this;
}
ComplexNo ComplexNo::sqrt(){
		//unfinished
		double a = this->getR();
		double b = this->getI();
		if(this->getI() != 0){
			this->setR(std::sqrt((a+std::sqrt(a*a+b*b))/(2)));
			this->setI(std::sqrt(((a * -1 ) +(std::sqrt(a*a + b*b)) )/2));
		}else if(this->getR() >= 0){
			this->setR(std::sqrt(this->getR()));
			this->setI(0);
		}else{
			this->setI(std::sqrt(this->getR() * -1));
			this->setR(0);
		}
		return this;
}
	
bool ComplexNo::equals(ComplexNumber rhs){
		//unfinished
		if(this->getR() == rhs.getR() && this->getI() == rhs.getI())
			return true;
		else
			return false; 
}



