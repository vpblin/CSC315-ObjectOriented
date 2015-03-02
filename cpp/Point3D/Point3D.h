
class Point3D
{
  // methods
  public:
  Point3D();
  Point3D(double x, double y, double z);
  ~Point3D();

  void print();

  double getX();
  double getY();
  double getZ();

  void setX(double x);
  void setY(double y);
  void setZ(double z);

  void add(Point3D p);
  
  // attributes
  private:
  double x, y, z;
};
