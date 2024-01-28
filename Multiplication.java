import java.util.Scanner;
public class Multiples{
	public static void main(String [] args){
	Scanner scanner = new Scanner(System.in);

	System.out.print("Enter an integer: ");
	int number1 = scanner.nextInt();

	System.out.print("Enter an integer: ");
	int number2 = scanner.nextInt();

	if(number1 * 3 % number2 * 2 == 0){
	System.out.println("divisible");}

	else{
	System.out.println("not divisible");}


	
	




}}
	
	