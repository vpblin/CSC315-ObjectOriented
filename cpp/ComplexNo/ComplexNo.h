
class ComplexNo
{
  // methods
  public:
  ComplexNo();
  ComplexNo(double x, double y);
  ~ComplexNo();

  void print();
  void toString();

  double getR();
  double getI();

  void setR(double x);
  void setI(double y);

  ComplexNo add(ComplexNo rhs);
  ComplexNo sub(ComplexNo rhs);
  ComplexNo mult(ComplexNo rhs);
  ComplexNo div(ComplexNo rhs);
  ComplexNo conj(ComplexNo rhs);
  ComplexNo sqrt(ComplexNo rhs);

  double mag();

  bool equals();

  // attributes
  private:
  double x, y, z;
};
