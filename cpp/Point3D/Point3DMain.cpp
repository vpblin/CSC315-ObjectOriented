#include <iostream>
#include "Point3D.h"

int main (int argc, char **argv)
{
  Point3D p3d;
  Point3D p3d_1(10, 20, 30);

  p3d.print();
  p3d_1.print();

  p3d.setX(100);
  p3d.setY(100);
  p3d.setZ(100);

  p3d_1.add(p3d);
  p3d_1.print();

  return 0;
}
