import java.util.*;

public class PracticeIt {
	public static void main(String[] args) {
		int[] array = {1, 3, 6, 7, 12};
		System.out.println(minGap(array));
	}
	
	
	public static double percentEven(int[] array){
		int evenCount = 0;
		if (array.length < 1) return 0.0;
		for (int index = 0; index < array.length; index++){
			if (array[index] %2 == 0){
				evenCount++;
			}
		}
		if (evenCount == 0) return 0.0;
		return 100.0*evenCount/array.length;
	}
	
	public static int minGap(int[] array){
		if (array.length < 2) return 0;
		int[] gapArray = new int[array.length-1];
		for (int index = 0; index < array.length-1; index++){
			gapArray[index] = array[index+1]-array[index];
		}
		int min = 999;
		for (int index = 0; index < gapArray.length; index++){
			if (gapArray[index] < min) min =  gapArray[index];
		}
		
		return min;
	}
	
	public static int median(int[] array){
		// More bubblesorting.
		int[] sortedArray = array.clone();
    	int temp;
    	boolean needsSwap = false;
    	for (int indexA = sortedArray.length-1; indexA > 0; indexA--){
    		for (int indexB = 0; indexB < indexA; indexB++){
    			if (sortedArray[indexB] < sortedArray[indexB+1]){
    				needsSwap = true;
    				temp = sortedArray[indexB];
    				sortedArray[indexB] = sortedArray[indexB+1];
    				sortedArray[indexB+1] = temp;
    			}
    		}
    		if (needsSwap == false) break;
    	}
		return sortedArray[sortedArray.length/2];
	}
	
	public static int kthLargest(int k, int[] array){
		// Basically just bubblesort
		int[] sortedArray = array.clone();
    	int temp;
    	boolean needsSwap = false;
    	for (int indexA = sortedArray.length-1; indexA > 0; indexA--){
    		for (int indexB = 0; indexB < indexA; indexB++){
    			if (sortedArray[indexB] < sortedArray[indexB+1]){
    				needsSwap = true;
    				temp = sortedArray[indexB];
    				sortedArray[indexB] = sortedArray[indexB+1];
    				sortedArray[indexB+1] = temp;
    			}
    		}
    		if (needsSwap == false) break;
    	}
		return sortedArray[k];
	}
	
	public static double stdev(int[] array){
		// Also really janky
		int sum = 0;
		double average;
		for (int index = 0; index < array.length; index++){
			sum+=array[index];
		}
		average = (double)sum / array.length;
		double numerator = 0;
		for (int index = 0; index < array.length; index++){
			numerator += (array[index] - average)*(array[index] - average);
		}
		
		return Math.sqrt(numerator/(array.length-1));
	}
	
	public static int mode(int[] array){
		// This is a super janky way to do this, I think.
		// It's going to make a new array as long as the largest int it finds!
		int max = 0;
		for (int i = 0; i < array.length; i++){
			if (array[i] > max) max = array[i];
		}
		int[] table = new int[max+1];
		for (int i = 0; i < array.length; i++){
			table[array[i]]++;
		}
		max = 0;
		int indexOf = 0;
		for (int j = 0; j < table.length; j++){
			if (table[j] > max){
				max = table[j];
				indexOf = j;
			}
			
		}
		return indexOf;
	}
	
	public static boolean isSorted(double[] array){
		for (int index = 0; index < array.length-1; index++){
			if (array[index] > array[index+1]) return false;
		}
		return true;
	}
	
	public static int countInRange(int[] array, int min, int max){
		int count = 0;
		for (int index = 0; index < array.length; index++){
			if ((array[index] >= min) && (array[index] <= max)) count++;
		}
		return count;
	}
	
	public static int range(int[] array){
		int smallest = 9999;
		int largest = 0;
		for (int index = 0; index < array.length; index++){
			if (array[index] > largest) largest = array[index];
			if (array[index] < smallest) smallest = array[index];
		}
		return largest - smallest + 1;
	}
	
	public static int lastIndexOf(int[] list, int value){
		for (int index = list.length-1; index >= 0; index--){
			if(list[index] == value) return index;
		}
		return -1;
	}
	
	public static void hopscotch(int hops){
		System.out.println("   1");
		for(int thisHop = 2; thisHop <= hops*3; thisHop+=3){
			System.out.println(thisHop+"     "+(thisHop+1));
			System.out.println("   "+(thisHop+2));
		}
	}
	
	public static void printFactors(int target){
		System.out.print("1");
		for(int divisor = 2; divisor<= target; divisor++){
			if(target%divisor==0){
				System.out.print(" and "+divisor);
			}
		}
	}
	
	public static void randomWalk(){
		int limit = 3;
		int max = 0;
		Random rand = new Random();
		int count = 0;
		int position = 0;
		do{
			position += rand.nextInt(3)-1;
			System.out.println("position = "+position);
			if(position>max) max = position;
		} while(!(Math.abs(position) == limit));
		System.out.println("max position = "+max);
	}
	
	public static void diceSum(){
		Scanner input = new Scanner(System.in);
		System.out.print("Desired dice sum: ");
		int targetSum = input.nextInt();
		int diceSum;
		Random rand = new Random();
		do{
			int firstDie = rand.nextInt(6)+1;
			int secondDie = rand.nextInt(6)+1;
			diceSum =  firstDie+secondDie;
			System.out.println(firstDie+" and "+secondDie+" = "+diceSum);
		} while(diceSum != targetSum);
	}
	
	public static void makeGuesses(){
		int guessTotal = 0;
		int guess;
		while(true){
			guessTotal++;
			guess = (int)(50*Math.random());
			System.out.println("guess = "+guess);
			if(guess>47){
				System.out.println("total guesses = "+guessTotal);
				return;
			}
		}
	}
	
	public static void randomChars(){
		int randRows = (int)(5*Math.random())+5;
		for(int row = 1; row <= randRows; row++){
			int rand = (int)(15*Math.random())+4;
			for(int x = 0; x<rand; x++){
				System.out.print((char)(int)(26*Math.random()+97));
			}
			System.out.println();
		}
	}
	
	public static String toBinary(int value){
		if(value == 0) return "0";
		String binaryForm = "";
		while(value != 0){
			binaryForm = value%2 + binaryForm;
			value /=2 ;
		}
		return binaryForm;
	}
	
	public static int gcd(int a, int b){
		if(b==0) return Math.abs(a);
		if(b==1) return 1;
		return gcd(b,a%b);
	}
	
	public static void showTwos(int target){
		System.out.print(target+" = ");
		boolean isNegative = false;
		if(target < 0){
			isNegative = true;
			target *= -1;
		}
		if(target%2==1){
			System.out.print(target);
			return;
		}
		int reduction = target;
		while(reduction >=2 && reduction%2==0){
			reduction /= 2;
			System.out.print("2 * ");
		}
		if(isNegative){
			System.out.print(-1*reduction);
		} else {
			System.out.print(reduction);
		}
	}
}
