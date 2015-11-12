import java.util.*;
public class rename {
	// Convert a user's given name to their GANGSTA name!
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Please type your first name and last name: ");
		String nameOfUser = console.nextLine();
		// A "gangsta" name is their first initial +"-Diddy", and their last name (in all caps) + "IZZLE"
		System.out.println("Your Gangsta name is: "
				+ nameOfUser.substring(0, 1)+"-Diddy"+" "
				+nameOfUser.substring(nameOfUser.indexOf(" ")+1, nameOfUser.length()).toUpperCase()+"IZZLE");
	}


}
