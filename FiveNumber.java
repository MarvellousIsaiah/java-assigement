import java.util.Scanner;

public class FiveNumber{

	public static void main(String [] args){
	Scanner scanner = new Scanner(System.in);

	int positiveCounter = 0;
	int negativeCounter = 0 ;
	int zeroCounter = 0;
	
	System.out.println("ENter a number: ");
	int first = scanner.nextInt();

	if(first > 0){
		positiveCounter++;
	}
	if(first < 0){
	negativeCounter++;
}
	if(first == 0){
	zeroCounter++;
}

	System.out.println("ENter a number: ");
	int second = scanner.nextInt();

	if(second > 0){
		positiveCounter++;
	}
	if(second < 0){negativeCounter++; }
	if(second == 0){zeroCounter++; }
	
	System.out.println("ENter a number: ");
	int third = scanner.nextInt();
	
	if(third > 0){
	positiveCounter++;
	}
	if(third < 0){ negativeCounter++; }
	if(third == 0){ zeroCounter++; }

	System.out.println("ENter a number: ");
	int forth = scanner.nextInt();

	if(forth > 0){
	positiveCounter++;
	}
	if(forth < 0){ negativeCounter++; }
	if(forth == 0){zeroCounter++; }

	System.out.println("ENter a number: ");
	int fifth = scanner.nextInt();
	
	if(fifth > 0){
	positiveCounter++;
	}
	if(fifth < 0){ 
	negativeCounter++; 
	}
	if(fifth == 0){zeroCounter++; }

	System.out.println("The number of positive is : "+ positiveCounter );
	System.out.println("The number of negative is : "+ negativeCounter );
	System.out.println("The number of zero is : "+ zeroCounter );
	
}

}