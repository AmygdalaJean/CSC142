public class main {
	// Print an acending stack of '*' characters, using a pair of for loops.
	public static void main(String[] args) {
		countingDots();
	}
	public static void dots(){
		for(int i=1; i<=5; i++){
			for(int j=1; j<=i; j++){
				System.out.print(i);
			}
			System.out.println();
		}
	}
	public static void countingDots(){
		for(int line = 1; line <=5; line++){
			for(int j=1; j<= (line*-1 +5); j++){
				System.out.print(".");
			}
		for(int k=1; k<=line; k++){
			System.out.print(line);
		}
		System.out.println();
		}
	}
}
