/*
Ben Rockhold 
CSC 142
10/2/15
Draw an ASCII Space Needle using recursive functions!

    .≡
    │
 <{===}>
   \║/
    ║
    ║
    ║
    ║
   /║\  
  |=╬=|
 /| ║ |\
|▒▒▒▒▒▒▒▒| 

*/
public class needle {
	static int sectionHeight = 4; // Multiplier for the height of each section; default is 4
	static String Lside = "__/";   // Left sidewall
	static String Rside = "\\__"; // Right sidewall
	public static void main(String[] args) {
		head();
		body();
		pediment();
	}
	public static String fill(String pattern, int count){
		// Accepts a string and an integer, returns the string self-concatenated int times
		String out= ""; 
		for(int i = 1; i <= count; i++){
			out += pattern;
		}
		return out;
	}
	public static void antenna() {
		// Simply prints an increasingly tall tower of || characters
		for(int j=1; j<=sectionHeight; j++){
			System.out.println(fill(" ", 3*sectionHeight)+fill("|", 2));
		}
	}
	public static void restaurant() {
		// Lower half of the top of the tower, basically upside-down pyramid
		for(int j = sectionHeight; j > 0; j--){
			int count = j*2 + (sectionHeight - 1);
			System.out.println(fill(" ", 2*sectionHeight-2*j)
								+ "\\_" + fill("/\\", count) + "_/");
		}
	}
	public static void cap() {
		// Calls ziggurat
		ziggurat();
	}
	public static void pediment() {
		// Calls ziggurat
		ziggurat();
	}
	public static void ziggurat(){
		// Prints a ziggurat; used for both the roof and the base of the tower
		for(int j = 0; j < sectionHeight; j++){
			System.out.println(fill(" ", 3*sectionHeight-3*(j+1))
								+ Lside + fill(":", j*3) + "||" + fill(":", j*3) + Rside);
		}
		System.out.println("|" + fill("\"", sectionHeight*6) + "|");
	}
	public static void head(){
		// Uses the above cap; prints the complete top of the tower
		antenna();
		cap();
		restaurant();
	}
	public static void body(){
		// Prints the central tower
		antenna(); // this is probably architecturally poor
		for(int j = 1; j<=sectionHeight*sectionHeight; j++){
			System.out.println(fill(" ",sectionHeight*3-3)+"|%%||%%|");
		}
	}
}

/*
Expected Output for sectionHeight = 4:

             ||
             ||
             ||
             ||
          __/||\__
       __/:::||:::\__
    __/::::::||::::::\__
 __/:::::::::||:::::::::\__
 |""""""""""""""""""""""""|
 \_/\/\/\/\/\/\/\/\/\/\/\_/
   \_/\/\/\/\/\/\/\/\/\_/
     \_/\/\/\/\/\/\/\_/
       \_/\/\/\/\/\_/
             ||
             ||
             ||
             ||
          |%%||%%|
          |%%||%%|
          |%%||%%|
          |%%||%%|
          |%%||%%|
          |%%||%%|
          |%%||%%|
          |%%||%%|
          |%%||%%|
          |%%||%%|
          |%%||%%|
          |%%||%%|
          |%%||%%|
          |%%||%%|
          |%%||%%|
          __/||\__
       __/:::||:::\__
    __/::::::||::::::\__
 __/:::::::::||:::::::::\__
 |""""""""""""""""""""""""|










*/