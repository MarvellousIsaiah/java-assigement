import java.util.Scanner;

public class Factor{

public static void main ( String [] args){

Scanner input = new Scanner( System.in); 

int counter = 1 ;



System.out.println("Enter a mumber to get the factors\n");
int FromAnyUser = input.nextInt();

while ( counter <= FromAnyUser) {
   counter++ ;

   if ( FromAnyUser % counter == 0) { 
   System.out.printf("%d is a factors of %d%n" ,counter,FromAnyUser ); }
   									 }
      				                                    }
 
									}	