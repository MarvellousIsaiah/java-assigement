import java.util.Scanner;
public class BodyMassIndex{

public static void main(String [] args){
Scanner scanner = new Scanner(System.in);

System.out.print("Enter weight in kilogram: ");
int weightInKilogram = scanner.nextInt();

System.out.print("Enter weight in meter: ");
int weightInMeter = scanner.nextInt();

System.out.print("Enter height in meter: ");
int heightInMeter = scanner.nextInt();



int bmi = weightInKilogram * 703 / heightInMeter * weightInMeter;
System.out.println(bmi);}}

