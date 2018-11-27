import java.util.Scanner;

public class Day07FencepostAndWhile {

   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);

      //fencepost(10);
      whileAndDoWhile(console);   
//       System.out.println("firstDigit(1234) = " + firstDigit(1234) );
//       System.out.println("firstDigit(-910) = " + firstDigit(-910) );
//       showTwos(7);
//       showTwos(18);
//       showTwos(68);
//       showTwos(120);
   }

   // This method demonstrates fencepost problems
   public static void fencepost(int n) {
      System.out.print("1");
      for(int i = 2; i <= n; i++) {
         System.out.print(", " + i);
      }
      System.out.println();
   }

   // This method demonstrates while and do while loops
   public static void whileAndDoWhile(Scanner console) {
      System.out.print("Enter number from 1-10: ");
      int num = console.nextInt();
      // while(num < 1 || num > 10) {
//          System.out.println(num + " is not within range!\n");
//          System.out.print("Enter number from 1-10: ");
//          num = console.nextInt();
//       }

      do {
          System.out.println(num + " is not within range!\n");
          System.out.print("Enter number from 1-10: ");
          num = console.nextInt();

      } while(num < 1 || num > 10);
      
      // while(x < 10) {
//          x++;
//          System.out.println(x);
//       }
   }

   // returns the first digit of a number
   // e.g. firstDigit(1234) --> 1
   // e.g. firstDigit(-910) --> 9
   public static int firstDigit(int num) {
      return 0;
   }

   // returns a summary of the factors of two for a given number
   // the logic is that you divide your number by 2 until you reach an odd number
   // e.g. showTwos(18) --> prints "18 = 2 * 9"
   // e.g showTwos(120) --> prints "120 = 2 * 2 * 2 * 15"
   public static void showTwos(int num) {
   }
}
