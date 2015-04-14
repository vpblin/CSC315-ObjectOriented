package inheritance;

public class Parent {

	private double x, y;

	public Parent ()
	{
		this.x = 0.0;
		this.y = 0.0;
	}
	
	public Parent(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public void override () {
		System.out.println("override in Parent\n");
	}
	
	public void method () {
		System.out.println("child\n");
	}

	public void testOverride(){
		System.out.println("Hello");
	}
}
