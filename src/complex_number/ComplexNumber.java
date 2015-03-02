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
		if(this.getI() >= 0)
			return this.r + " + " + this.i+ ('i');
		else
			return this.r + " - " + this.i+ ('i');

	}
	
	ComplexNumber add(ComplexNumber rhs){
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
		if(rhs.getR() == 0 && rhs.getI() == 0){
			this.setI(0);
			this.setR(0);
		}else{
			this.setR((this.getR() * rhs.getR() + this.getI() * rhs.getR())/(Math.pow(rhs.getR(), 2) + Math.pow(rhs.getI(), 2)));
			this.setI((this.getI() * rhs.getR() - this.getR() * rhs.getI())/(Math.pow(rhs.getR(), 2) + Math.pow(rhs.getI(), 2)));
		}
		return this;
	}

	double mag(){
		return Math.sqrt(Math.pow(this.getR(), 2) + Math.pow(this.getI(), 2));
	}
	ComplexNumber conj(){
		//unfinished
		this.setI(this.getI() * -1);
		return this;
	}
	ComplexNumber sqrt(){
		//unfinished
		double a = this.getR();
		double b = this.getI();
		if(this.getI() != 0){
			this.setR(Math.sqrt((a+Math.sqrt(a*a+b*b))/(2)));
			this.setI(Math.sqrt(((a * -1 ) +(Math.sqrt(a*a + b*b)) )/2));
		}else if(this.getR() >= 0){
			this.setR(Math.sqrt(this.getR()));
			this.setI(0);
		}else{
			this.setI(Math.sqrt(this.getR() * -1));
			this.setR(0);
		}
		return this;
	}
	
	boolean equals(ComplexNumber rhs){
		//unfinished
		if(this.getR() == rhs.getR() && this.getI() == rhs.getI())
			return true;
		else
			return false; 
	}
}
