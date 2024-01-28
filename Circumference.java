import java.util.Scanner;
public class Circumference{
	public static void main(String[] args){

	System.out.println("enter a radius");

	Scanner scanner = new Scanner(System.in);
	
	


	double  radius = scanner.nextDouble();

	

	double diameter = 2 * radius;


	System.out.printf("%f%n", diameter);



	double circumference = 2 * 3.14159 * radius;

	
	System.out.printf("%f%n", circumference);

	double area = 3.14159 * radius * radius;

	System.out.printf("%f%n", area );

	









}






}