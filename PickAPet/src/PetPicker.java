import java.util.Scanner;

public class PetPicker {

	public static void main(String[] args) {
		System.out.println("What is your name?");
		Scanner console = new Scanner(System.in);
		String nameOfUser = console.nextLine();
		System.out.println("Hi "+nameOfUser+", how old are you?");
		int userAge = console.nextInt();
		System.out.println("What gender are you?\n0: Male\n1: Female");
		int userGender = console.nextInt();
		System.out.println(nameOfUser+", you should get a pet "+petPicker(userAge, userGender)+"!");
	}
	public static String petPicker(int age, int gender){
		if(gender == 0){
			if(age>10 && age<20){
				return "turtle";
			} else if(age>21 && age<50){
				return "bulldog";
			} else if(age>50 && age<80){
				return "iguana";
			}
		} else if(age>10 && age<20){
			return "frog";
		} else if(age>21 && age<50){
			return "alpaca";
		} else if(age>50 && age<80){
			return "lizard";
		}
		return "fish";
	}
}
