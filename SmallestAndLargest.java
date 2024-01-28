import java.util.Scanner;
public class SmallestAndLargest{

	public static void main(String [] args){
	Scanner scanner = new Scanner(System.in);

	int average = 0;
	int sum = 0;
	int product = 0;

	System.out.print("Enter an integer :");
	int number1 = scanner.nextInt();

	System.out.print("Enter an integer :");
	int number2 = scanner.nextInt();
	
	System.out.print("Enter an integer :");
	int number3 = scanner.nextInt();

	if(number1 > number2 && number1 > number3){
	System.out.println("highest");}

	else{

	System.out.println("smallest");}

	if(number2 > number1 && number2 > number3){
	System.out.println("largest");}
	
	else{

	System.out.println("smallest");}

	if(number3 > number1 && number3 > number2){
	System.out.println("highest");}

	else{

	System.out.println("smallest");}

	sum = number1 + number2 + number3;
	
	product = number1 * number2 * number3;

	average = sum / 3;

	System.out.printf("%d, %d, %d%n", sum, product, average);
	}}

	
	
	
	
	
