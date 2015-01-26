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
		return this.r + "," + this.i;
	}
	
	
}
