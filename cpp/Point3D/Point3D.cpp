#include <iostream>
#include "Point3D.h"

using namespace std;

Point3D::Point3D()
{
  x = 0.0; // setX(0.0);
  y = 0.0; // setY(0.0);
  z = 0.0; // setZ(0.0);
}

Point3D::Point3D(double x, double y, double z)
{
  this->x = x;
  this->y = y;
  this->z = z;
}

Point3D::~Point3D()
{
}

void Point3D::print()
{
  cout << "(" << x << ", " << y << ", " << z << ")" << endl;
}

double Point3D::getX()
{
  return x;
}

double Point3D::getY()
{
  return y;
}

double Point3D::getZ()
{
  return z;
}

void Point3D::setX(double x)
{
  this->x = x;
}

void Point3D::setY(double y)
{
  this->y = y;
}

void Point3D::setZ(double z)
{
  this->z = z;
}

void Point3D::add(Point3D p)
{
  x += p.x;
  y += p.y;
  z += p.z;
}



