import java.util.Scanner;

public class RecommendMovie {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please choose your age category:\n1: 0 - 12\n2: 13 - 19\n3: 20+");
		int ageSelection = input.nextInt();
		if(!(ageSelection>3 || ageSelection < 1)){
			System.out.println("How many movies do you watch per week?\n1: 0-5\n2: 5-10\n3: 10+");
			int moviesSelection = input.nextInt();
			if(!(moviesSelection < 1 || moviesSelection > 3)){
				if(ageSelection==2){
					if(moviesSelection == 1){
						System.out.println("You should watch The Hunger Games.");
					} else if(moviesSelection == 2){
						System.out.println("You should watch Harry Potter (any).");
					} else{
						System.out.println("You should watch Twilight.");
					}
				} else if(ageSelection == 3){
					if(moviesSelection == 1){
						System.out.println("You should watch The King's Speech.");
					} else if(moviesSelection == 2){
						System.out.println("You should watch Schneidler's List.");
					} else{
						System.out.println("You should watch The Godfather.");
					}
				} else {
					System.out.println("You should watch Toy Story!\nFOREVER.");
				}
					
			} else {
				System.out.println("Invalid movie count selection \""+moviesSelection+"\"");
			}
		} else {
			System.out.println("Invalid age range selection \""+ageSelection+"\"");
		}
	}
}
