import java.util.Scanner;
public class Energy{
public static void main(String[]arg){
Scanner input=new Scanner(System.in);
System.out.println("final temperature");
float y= input.nextFloat();
System.out.println("initial temperature");
float s= input.nextFloat();
float z=(y-s)*4184;
System.out.printf("the energy needed is %f", z);




}
}


