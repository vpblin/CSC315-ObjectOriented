package complex_number;

public class ComplexNumber {
	double r;
	double i;
	
	public ComplexNumber(){
		this.r = 0;
		this.i = 0;
	}
	
	public ComplexNumber(double _r, double _i){
		this.r = _r;
		this.i = _i;

	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public double getI() {
		return i;
	}

	public void setI(double i) {
		this.i = i;
	}
	
	public String toString(){
		return this.r + " + " + this.i+ ('i');
	}
	
	ComplexNumber add (ComplexNumber rhs){
		this.setR(this.getR() + rhs.getR());
		this.setI(this.getI() + rhs.getI());
		return this;
	}

	ComplexNumber sub (ComplexNumber rhs){
		this.setR(this.getR() - rhs.getR());
		this.setI(this.getI() - rhs.getI());
		return this;
	}

	ComplexNumber mult (ComplexNumber rhs){
		this.setR((this.getR() * rhs.getR()) - (this.getI() * rhs.getI()));
		this.setI((this.getR() * rhs.getI()) + (this.getI() * rhs.getR()));
		return this;
	}

	ComplexNumber div (ComplexNumber rhs){
		//unfinished
		
		return this;
	}

	double mag(){
		//unfinished

		return 0.0;
	}
	ComplexNumber conj(){
		//unfinished

		return this;
	}
	ComplexNumber sqrt(){
		//unfinished

		return this;
	}
	
	boolean equals(ComplexNumber rhs){
		//unfinished

		return false; 
	}
}
