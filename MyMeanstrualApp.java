

import java.util.Scanner;
public class MyMeanstrualApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("please enter the last day of your meanstruation:");
        int day = scanner.nextInt();
        System.out.print("please enter the last month of your meanstruation:");
        int month = scanner.nextInt();
        System.out.print("please enter the last year of your meanstruation:");
        int year = scanner.nextInt();
        System.out.println(collector(day, month, year));


    }


    public static String collector(int day, int month, int year) {
        if (isInRange(day, month, year)) {
            String date = String.valueOf(day);
            String day1 = String.valueOf(month);
            String day2 = String.valueOf(year);
            return date + " " + day1 + " " + day2;
        }
              return " Values are Not in range";
    }
    public static boolean isInRange(int day, int month, int year) {
        if (day > 31 || day < 0 || month > 12 || month < 0 || month == 2 &&  day > 29 ) {
            return false;
        }
       return true ;


    }






}
