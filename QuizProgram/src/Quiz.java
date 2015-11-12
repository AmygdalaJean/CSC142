import java.util.*;

public class Quiz {
	public static void main(String[] args) {
		performQuiz(new Scanner(System.in), System.out); // Perform quiz!
	}
	public static void performQuiz(Scanner in, java.io.PrintStream out){
		boolean answerOne = questionOne(in, out);
		boolean answerTwo = questionTwo(in, out);
		boolean answerThree = questionThree(in, out);
		giveResults(answerOne, answerTwo, answerThree, out);
	}
	public static void giveResults(boolean a, boolean b, boolean c, java.io.PrintStream out){
		if(!a && !b && !c){ // None correct
			out.println("You need more practice!");
			
		} else if(!a && !b && c){ // Just c
			out.println("Well, at least you got the hard one corect!");
			
		} else if((a && !b) || (!a && b) && !c){ // Just a or b and not c
			out.println("You need to warm up!");
			
		} else if((!a && b) || (!b && a) && c){ // (a xor b) and c
			out.println("You are amazing!");
			
		} else if(a && b && !c){ // Just a and b
			out.println("You are on your way!");
			
		} else if (a && b && c){ // a and b and c
			out.println("You are a scholar!");
		}
	}
	public static boolean getInput(Scanner in, int answer, java.io.PrintStream out){
		int input;
		try{
			input = in.nextInt();
		} catch (InputMismatchException e){
			out.println("Invalid entry; question failed; \""+in.next()+"\" was invalid.");
			return false;
		}
		if(input == answer) return true;
		return false;
	}
	public static boolean questionOne(Scanner in, java.io.PrintStream out){
		out.println("Is the Space Needle the tallest building in Seattle?");
		out.println("1: True\n2: False");
		return getInput(in, 2, out);
	}
	public static boolean questionTwo(Scanner in, java.io.PrintStream out){
		out.println("What is the most common bear in north america?");
		out.println("1: Black \n2: Polar\n3: Brown");
		return getInput(in, 3, out);
	}
	public static boolean questionThree(Scanner in, java.io.PrintStream out){
		out.println("How far away is the sun?");
		out.println("1: 1 Astronomical Unit\n2: About a mile\n3: 299,792,458 meters\n4: 10,000,000,000 miles");
		return getInput(in, 1, out);
	}

}
