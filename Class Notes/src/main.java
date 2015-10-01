// Class name and file name MUST match.

public class main {
	public static void main(String[] args){
		top();
		bottom();
		top();
		System.out.println("|  STOP  |");
		bottom();
		System.out.println("+--------+");
		bottom();
	}
	public static void top(){
		System.out.println("   ----\n"
						+  " /      \\\n"
						+  "/        \\");
	}
	public static void bottom(){
		System.out.println("\\        /\n"
						+  " \\      /\n"
						+  "   ----\n");
	}
	
}
