

public class main {

	public static void main(String[] args) {
		System.out.println(fToC(90));
		System.out.println(hypotenuse(5,4));

	}
	public static double fToC(double degreesF){
		// Accept a temperature in F, return equivalent in C
		return 5.0 / 9.0 * (degreesF - 32);
	}
	public static double hypotenuse(int a, int b){
		// Find the hypoenuse of a triangle, given its two sides.
		return Math.sqrt(a*a + b*b);
	}

}
