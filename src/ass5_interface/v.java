package ass5_interface;


public class v implements vector{
	double x;
	double y;
	double z;
	
    public v(){
    	this.x = 0;
    	this.y = 0;
    	this.z = 0;
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



	public v(double x, double y, double z){
    	this.x = x;
    	this.y = y;
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

	@Override
	public double vect_norm(v v1) {
		// TODO Auto-generated method stub
		return Math.sqrt(Math.pow(v1.getX(),2) + Math.pow(v1.getY(),2) + Math.pow(v1.getZ(),2));
		
	}

	@Override
	public v vect_unit(v v1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double angle_2_vect(v v1, v v2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public v direct_angles(v v1) {
		// TODO Auto-generated method stub
		return null;
	}
}
