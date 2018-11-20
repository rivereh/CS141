import java.util.Random;
import java.util.Scanner;

public class chapter5 {

   public static void main(String[] args) {
   
      Scanner console = new Scanner(System.in);
      Random rand = new Random();
      
   
   
   
      //loopOne(console, rand);
   
   
      System.out.println(firstWord("Four score"));
   
   
   }

   public static void loopOne(Scanner console, Random rand) {
      System.out.print("Enter number between 1-10: ");
      int number = console.nextInt();
      
      int result = -1; // set to -1 to make sure we enter loop
      int count = 0;
      while (result != number) {
         result = rand.nextInt(10) + 1; // random number from 1-10
         System.out.println("Computer chose: " + result);
         count++;
      }
      System.out.println("Your number came up after " + count + " times!");
   }
   
   public static String firstWord(String s) {
      int start = 0;
      
      while(start < s.length() && s.charAt(start) == ' ')
         start++;
      
      // short-circuit thing
      int stop = start;
      while(stop < s.length() && s.charAt(stop) != ' ')
         stop++;
      
      return s.substring(start, stop);
      
   }




}