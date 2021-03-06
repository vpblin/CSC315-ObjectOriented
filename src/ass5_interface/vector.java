package ass5_interface;

public interface vector {
	
	double XCOMPONENT = 0.0;
	double YCOMPONENT = 0.0;
	double ZCOMPONENT = 0.0;

	v add(v v1, v v2);
	v sub(v v1, v v2);
	v mult(v v1, v v2);
	double dot_prod(v v1, v v2);
	v cross_prod(v v1, v v2);
	double vect_norm(v v1);
	v vect_unit(v v1);
	double angle_2_vect(v v1, v v2);
	v scalar_mult(double a, v v1);
	double[] direction_angles(v v1);

	
}
