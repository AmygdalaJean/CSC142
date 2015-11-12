import java.util.*;

public class PrimeCheck {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		java.io.PrintStream out = System.out;
		out.println("Enter number to check");
		out.println(isPrime(input.nextInt()));
	}
	public static boolean isPrime(int n){
		int factors = 0;
		for(int i = 1; i<= n; i++){
			if(n%i==0) factors++;
		}
		return factors==2;
	}
}
