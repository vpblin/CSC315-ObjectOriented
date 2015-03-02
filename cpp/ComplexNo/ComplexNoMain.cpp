#include <iostream>
#include <cmath>
#include "ComplexNo.h"

int main (int argc, char **argv)
{

  ComplexNo number;
  ComplexNo second(3.0, 1.0);
		
  number.setI(5);
  number.setR(3);
  std::cout << number.toString();
  std::cout << number.equals(second);
  std::cout << number.add(second);
  std::cout << number.mult(second);
  std::cout << number.sub(second);
  std::cout << number.div(second);
  std::cout << number.conj();
  std::cout << number.mag();
  std::cout << number.sqrt();
    
  return 0;
}
