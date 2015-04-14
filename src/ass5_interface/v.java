package ass5_interface;
//Blin Kazazi
//CSC 315
public class v<doube> implements vector{
	double x= XCOMPONENT;
	double y= YCOMPONENT;
	double z= ZCOMPONENT;
	
    public v(){
    	this.x = XCOMPONENT;
    	this.y = YCOMPONENT;
    	this.z = ZCOMPONENT;
    }
    

	public v(double x, double y, double z){
    	this.x = x;
    	this.y = y;
    	this.z = z;
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



	public double getZ() {
		return z;
	}



	public void setZ(double z) {
		this.z = z;
	}



	@Override
	public v add(v v1, v v2) {
		// TODO Auto-generated method stub
		v1.setX(v1.getX() + v2.getX());
		v1.setX(v1.getY() + v2.getY());
		v1.setX(v1.getZ() + v2.getZ());

		return v1;
	}
	
	public v add(v v2) {
		// TODO Auto-generated method stub
		this.setX(this.getX() + v2.getX());
		this.setX(this.getY() + v2.getY());
		this.setX(this.getZ() + v2.getZ());

		return this;
	}


	@Override
	public v sub(v v1, v v2) {
		// TODO Auto-generated method stub
		v1.setX(v1.getX() - v2.getX());
		v1.setX(v1.getY() - v2.getY());
		v1.setX(v1.getZ() - v2.getZ());

		return v1;
	}

	@Override
	public v mult(v v1, v v2) {
		// TODO Auto-generated method stub
		v1.setX(v1.getX() * v2.getX());
		v1.setX(v1.getY() * v2.getY());
		v1.setX(v1.getZ() * v2.getZ());

		return v1;
	}

	@Override
	public v scalar_mult(double a, v v1) {
		// TODO Auto-generated method stub
		v1.setX(a * v1.getX());
		v1.setY(a * v1.getY());
		v1.setY(a * v1.getZ());
		return v1;
	}

	@Override
	public double dot_prod(v v1, v v2) {
		// TODO Auto-generated method stub
		double a = v1.getX() * v2.getX() + v1.getY() * v2.getY() + v1.getZ() * v2.getZ();
		return a;
	}

	@Override
	public v cross_prod(v v1, v v2) {
		// TODO Auto-generated method stub
		v prod = new v (
				v1.getY() * v2.getZ() - v1.getZ() * v2.getY(), 
				v1.getX() * v2.getZ() - v2.getX() * v1.getZ(),
				v1.getX() * v2.getY() - v1.getY() * v2.getX()
				);
		
		
		return prod;
	}
	public String toString(){
		return "<" +this.getX()+ " " + this.getY() + " " +  this.getZ() + ">";
	}

	@Override
	public double vect_norm(v v1) {
		// TODO Auto-generated method stub
		return Math.sqrt(Math.pow(v1.getX(),2) + Math.pow(v1.getY(),2) + Math.pow(v1.getZ(),2));
		
	}

	@Override
	public v vect_unit(v v1) {
		// TODO Auto-generated method stub.
		
		v unit = new v(
				v1.getX() / v1.vect_norm(v1),
				v1.getY() / v1.vect_norm(v1),
				v1.getZ() / v1.vect_norm(v1)
				);
		
		
		return unit;
	}

	@Override
	public double angle_2_vect(v v1, v v2) {
		// TODO Auto-generated method stub
		Math.acos(v1.dot_prod(v1, v2) / (v1.vect_norm(v1)* v2.vect_norm(v2)));
		return 0;
	}

	@Override
	public double[] direction_angles(v v1) {
		// TODO Auto-generated method stub
		double a = Math.acos(v1.getX() / v1.vect_norm(v1));
		double b = Math.acos(v1.getY() / v1.vect_norm(v1));
		double c = Math.acos(v1.getZ() / v1.vect_norm(v1));
		
		double[] x = {a, b,c};
		return x;
	}
	public double single_direction_angle(double a,v v1) {
		// TODO Auto-generated method stub
		double b = Math.acos(a / v1.vect_norm(v1));
		
		return b;
	}

	
	public boolean parallel(v v1, v v2){
		return v1.vect_norm(v1.cross_prod(v1, v2)) == 0;
	}
	public boolean anti_parallel(v v1, v v2){
		return v1.angle_2_vect(v1, v2) == Math.PI;
	}

	public v projection(v v1, v v2){
		double a= v1.dot_prod(v1, v2.vect_unit(v2));
		return 	scalar_mult(a, v2.vect_unit(v2));
	}

}
