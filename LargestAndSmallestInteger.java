import java.util.Scanner;
public class LargestAndSmallestInteger{
	public static void main(String [] args){
	Scanner scanner = new Scanner(System.in);

	System.out.print("Enter  an enteger");
	int number1 = scanner.nextInt();
	
	System.out.print("Enter  an enteger");
	int number2 = scanner.nextInt();

	System.out.print("Enter  an enteger");
	int number3 = scanner.nextInt();

	System.out.print("Enter  an enteger");
	int number4 = scanner.nextInt();

	System.out.print("Enter  an enteger");
	int number5 = scanner.nextInt();

	if(number1 > number2 && number1 > number3 && number1 > number4 && number1 >number5){
	System.out.print("largest is " + number1 );}

	else if (number2 > number1 && number2 > number3 && number2 > number4 && number2 > number5){
	System.out.print("largest is " + number2);}

	else if(number3 > number1 && number3 > number2 && number3 > number4 && number3 > number5){
	System.out.print("largest is " + number3);}
	

	else if(number4 > number1 && number4 > number2 && number4 > number3 && number4 > number5){
	System.out.print("largest is " + number4);}

	else if(number5 > number1 && number5 > number2 && number5 > number3 && number5 > number4){
	System.out.print("largest is " + number5);}

}}
