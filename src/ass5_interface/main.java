package ass5_interface;

public class main {
	public static void main(String[] args){
		
		v v0 = new v(1.0, 2.0, 3.0);
		v v1 = new v(4.0, 5.0, 6.0);
		vector vresult;
		vresult = v0.add(v1);
		System.out.println(vresult);
		vresult = v0.sub(v0, v1);
		System.out.println(vresult);
		System.out.println(v0.scalar_mult(2.0, v0));
		System.out.println(v0.dot_prod(v0, v1));
		System.out.println(v0.cross_prod(v0, v1));
		System.out.println(v0.vect_norm(v0));
		System.out.println(v0.vect_unit(v0));
		v0 = new v(2, -3, 4);
		v1 = new v(5, 2, 1);
		System.out.println(v0.angle_2_vect(v0, v1) * 180.0 / Math.PI);
		System.out.println(v0.single_direction_angle(vector.XCOMPONENT, v0));
		System.out.println(v0.single_direction_angle(vector.YCOMPONENT, v0));
		System.out.println(v0.single_direction_angle(vector.ZCOMPONENT, v0));
		System.out.println("parallel " + v0.parallel(v0, v0));
		System.out.println("parallel " + v0.parallel(v0, v1));
		v0 = new v(1, 0, 0);
		v1 = new v(-1, 0, 0);
		System.out.println("anti-parallel " + v0.anti_parallel(v0, v1));
		System.out.println("anti-parallel " + v0.anti_parallel(v0, v0));
		v vunit = (v)v0.vect_unit(v0);
		System.out.println(vunit.vect_norm(vunit));
		System.out.println("equals " + v0.equals(v0));
		System.out.println("equals " + v0.equals(v1));
		v0 = new v(2, -3, 4);
		v1 = new v(5, 2, 1);
		System.out.println(v0.projection(v0, v1));
		
	}
}
