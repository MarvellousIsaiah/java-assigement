import java.util.Scanner;
public class Game{

public static void main(String [] arg){
Scanner scanner = new Scanner(System.in);
System.out.println("Welcome to the rock paper scissors game....pick 0 for scissors, 1 for rock and 2 for paper...but first enter you names...");

System.out.println("Player one enter your name: ");
String playerOneName = scanner.nextLine();

System.out.println("Player two enter your name: ");
String playerTwoName = scanner.nextLine();

System.out.println(playerOneName +" pick a number from 0-2:");
int playerOneChoice = scanner.nextInt();

System.out.println(playerTwoName +" pick a number from 0-2:");
int playerTwoChoice = scanner.nextInt();

if (playerOneChoice == playerTwoChoice){
	System.out.print("it's a tie!!");
}else if(playerOneChoice == 0 && playerTwoChoice==2){
	System.out.print("player one wins");
}else if(playerOneChoice == 1 && playerTwoChoice==0){
	System.out.print("player one wins");
}else if(playerOneChoice == 2 && playerTwoChoice==1){
	System.out.print("player one wins!!");
}else if(playerTwoChoice ==0 && playerOneChoice==2){
	System.out.print("player two wins");
}else if(playerTwoChoice ==1 && playerOneChoice==0){
	System.out.print("player two wins!!");
}else if(playerTwoChoice==2 && playerOneChoice==1){
	System.out.print("player two wins");
}else{
	System.out.print("pick a right number pls..");
}











}
}