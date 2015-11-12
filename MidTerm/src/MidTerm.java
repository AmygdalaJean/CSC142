
public class MidTerm {
	public static void main(String[] args){
		sequenceSum(3.0);
	}
	public static void sequenceSum(double target){
		double sum = 1.0;
		int denominator = 1;
		if(target <= 1.0) return;
		//System.out.print("1/"+denominator+" + ");
		while(sum < target){
			System.out.print("1/"+denominator+" + ");
			sum += (1.0/denominator);
			denominator++;
			
		}
		System.out.print(" = "+sum);
	}
}
