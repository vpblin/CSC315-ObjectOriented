package inheritance;

public class Substitution {

	public static void UseParent (Parent _p)
    {
		System.out.println("From UseParent() method");
		System.out.println(_p.getX() + " " + _p.getY());
		_p.override();
		System.out.println();
    }

	public static void main(String[] args) {
		Parent A = new Parent (1.0, 2.0);
		Child B = new Child (1.0, 2.0);

		System.out.println("Parent: " + A.getX() + " " + A.getY());
		System.out.println(" Child: " + B.getX() + " " + B.getY());
		A.override();
		System.out.println();
		
		/*// -- call UseParent() with a Parent class instance
		UseParent(A);

		// -- call UseParent() with a Child class instance
		UseParent(B);

		// -- assign a Child class instance to a Parent class instance
		Parent C = B;
		UseParent(C);

		// -- assign a Parent class instance to a Child class instance
		//    causes an "incompatible types" error
		// Child D = A;
		
		A.override();
		B.override();*/
	}

}
