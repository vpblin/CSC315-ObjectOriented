package complex_number;

public class Complex_no {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComplexNumber number = new ComplexNumber();
		ComplexNumber second = new ComplexNumber(3, -1);

		
		number.setI(5);
		number.setR(3);
		System.out.println(number.toString());
		System.out.println(number.equals(second));
		System.out.println(number.add(second));
		System.out.println(number.mult(second));
		System.out.println(number.sub(second));
		System.out.println(number.div(second));
		System.out.println(number.conj());
		System.out.println(number.mag());
		System.out.println(number.sqrt());
		
	}

}
