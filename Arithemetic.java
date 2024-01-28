import java.util.Scanner;
public class Arithemetic{
	public static void main(String [] args){
	Scanner scanner = new Scanner(System.in);

	System.out.print("Enter two integer");
	int numbersquare1 = scanner.nextInt(); 


	
	int  square = numbersquare1 * numbersquare1;
	int sum = square + square;
	int subtraction = square - square;
	

	System.out.printf("square is %d%n, sum is %d%n, subtraction is %d%n",square, sum, subtraction);
	







}}