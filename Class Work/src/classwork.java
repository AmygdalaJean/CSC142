import java.util.*;

public class classwork {
    public static void main(String[] args) {
    	Scanner console = new Scanner(System.in);
    	Random r = new Random();
    	
    	int[] testArray = randomArray(50,r);
    	
    	/*
    	for (int i = 0; i < testArray.length; i++){
    		System.out.println(testArray[i]);
    	}
    	*/
    	
    	System.out.println();
    	bubbleSort(testArray, false);
    	bubbleSort(testArray, true);
    	
    	/*
    	for (int i = 0; i < firstArray.length; i++){
    		System.out.println(firstArray[i]);
    	}
    	*/
    	
    	//weather(console, System.out);
    	
    }
    // Return an array of given length, filled with random integer values
    private static int[] randomArray(int length, Random r){
    	int[] randomArray = new int[length];
    	for (int i = 0; i < length; i++){
    		randomArray[i] = r.nextInt();
    	}
    	return randomArray;
    }
    
    
    /*	11-4-15
     *  More messing with arrays.
     *  can I remember Bubblesort? Yes!
     */
    private static int[] bubbleSort(int[] inputArray, boolean earlyStop){
    	int[] outputArray = inputArray.clone();
    	int temp;
    	int operationCount = 0;
    	boolean needsSwap = false;
    	for (int indexA = outputArray.length-1; indexA > 0; indexA--){
    		for (int indexB = 0; indexB < indexA; indexB++){
    			if (outputArray[indexB] < outputArray[indexB+1]){
    				needsSwap = true;
    				operationCount++;
    				// swap values via temp
    				temp = outputArray[indexB];
    				outputArray[indexB] = outputArray[indexB+1];
    				outputArray[indexB+1] = temp;
    			}
    		}
    		if (needsSwap == false && earlyStop == true) break;
    	}
    	System.out.println("\n\n"+operationCount+"\n\n");
    	return inputArray;
    }
        
    // 11-3-2015
    // Fill an array with values for temperature, then print the average and number
    // of days above that average.
    private static void weather(Scanner input, java.io.PrintStream out){
    	out.println("How many days' weather? ");
    	int[] days = new int[input.nextInt()];
    	for (int i = 0; i < days.length; i++){
    		out.print("Day "+(i+1)+" high temperature: ");
    		days[i] = input.nextInt();
    		out.println();
    	}
    	double average = findAverage(days);
    	int aboveAverage = 0;
    	for (int i = 0; i < days.length; i++){
    		if (days[i]>average) aboveAverage++;
    	}
    	out.printf("Average temp %.3f\n",average);
    	out.println(aboveAverage+" days were above average");
    	
    }
    

    
    private static int[] lowestTwoDays(int[] days){
    	int[] twoLowest = {999,999};
    	for (int index = 0 ; index < days.length; index++){
    		if (days[index] < twoLowest[0]){
    			twoLowest[1] = twoLowest[0];
    			twoLowest[0] = days[index];
    		}
    	}
    	return twoLowest;
    }
    private static int[] highestTwoDays(int[] days){
    	int[] twoLowest = {0,0};
    	for (int index = 0 ; index < days.length; index++){
    		if (days[index] > twoLowest[0]){
    			twoLowest[1] = twoLowest[0];
    			twoLowest[0] = days[index];
    		}
    	}
    	return twoLowest;
    }
    
    private static double findAverage(int[] list){
    	int sum = 0;
    	for (int i=0; i< list.length; i++){
    		sum += list[i];
    	}
    	return (double)sum/list.length;
    }
    
    
    // 10-22-2015
    //-------------------------------------------------------------------------
    // Generate sums of random numbers until you get a seven! 
    public static void rollTheDice(Random r){
    	int count =0;
    	while(true){
    		int a = r.nextInt(6)+1;
    		int b = r.nextInt(6)+1;
    		System.out.println(a+" + "+b+" = "+(a+b));
    		count+=1;
    		if((a+b)==7){
    			System.out.println("You got a seven in "+count+" tries!");
    			return;
    		}
    	}
    }
    
    
    
    // 10-19-2015
    //------------------------------------------------------
    // Return "even" or "odd" for the last digit in a value
    public static String lastDigit(int value){
    	if(value%2 == 0) return "Even";
    	return "Odd";
    }
    // Sum only the odd digits in a number
    public static int onlyOdd(int value){
    	int sum = 0;
    	while(value > 0){
    		sum+=(value%10)*(value%2);
    		value = value/10;
    	}
    	return sum;
    }
    // Sum only the even digits in a number
    public static int onlyEven(int value){
    	int sum = 0;
    	while(value > 0){
    		sum+=(value%10)*((value%2+1)%2);
    		value = value/10;
    	}
    	return sum;
    }
    // Sum the digits in a number
    static int digitSum(int value){
    	int sum = 0;
    	while(value > 0){
    		sum+=value%10;
    		value = value/10;
    	}
    	return sum;
    }
}