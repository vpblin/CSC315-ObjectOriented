package inheritance;

public class Child extends Parent {
	private double u, v;

	public Child () {
		super();
		this.u = 10.0;
		this.v = 10.0;
	}
	
	public Child(double u, double v) {
		super(u + 10, v + 10);
		this.u = u;
		this.v = v;
	}

	public double getU() {
		return u;
	}

	public void setU(double u) {
		this.u = u;
	}

	public double getV() {
		return v;
	}

	public void setV(double v) {
		this.v = v;
	}
	
	public void override () {
		System.out.println("override in Child\n");
	}
	public void method () {
		System.out.println("child\n");
	}
	
	public void testOverride(){
		System.out.println("Test hellp from child");
	}

	public void onlychild(){
		System.out.println("only child");
	}


}
