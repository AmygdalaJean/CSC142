import java.util.Scanner;

public class Receipt {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		foo(input, 0.80, 20);
	}
	public static void foo(Scanner input, double taxRate, int tipPercent){
		System.out.print("How many people ate? ");
		int personCount = input.nextInt();
		double subTotal = 0;
		for(int person = 1; person <= personCount; person++){
			System.out.println("Person #"+person+", how much did your meal cost? ");
			subTotal += input.nextDouble();
		}
		System.out.println("Subtotal: "+subTotal);
		System.out.println("     Tax: "+(subTotal*taxRate));
		System.out.println("     Tip: "+subTotal*tipPercent/100);
		System.out.println("   Total: "+(subTotal+subTotal*taxRate+(subTotal*tipPercent/100)));
		
		
		
	}

}
