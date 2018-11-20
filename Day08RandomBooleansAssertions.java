import java.util.Random;

public class Day08RandomBooleansAssertions {

   public static void main(String[] args) {
      int x = random();
      System.out.println("x is: " + x);
      boolean factor = isFactor(3, x);
      System.out.println("result of isFactor(3, x) where x = " + x + " is " + factor);
      System.out.println( isEven(x) );
      System.out.println( allSmallDigits(x) );
      System.out.println( isReverse("hello","olleh") );
   }
   
   // returns a random integer between 1 and 100
   public static int random() {
      Random r = new Random();
      //int x = r.nextInt(3) + 1;
      //int x = r.nextInt(11) + 20;
      return r.nextInt(100) + 1;
   }
   
   // returns true if x is a factor of y
   // Question: is x here the same as the x in the main?
   public static boolean isFactor(int x, int y) {
      return y % x == 0;
   }

   // returns true is num is even, false if it's odd
   // e.g. isEven(10) --> true
   // e.g. isEven(-1) --> false
   public static boolean isEven(int num) {
      return num % 2 == 0;
   }

   // returns true if all digits are smaller than 5
   // e.g. allSmallDigits(1233) --> true
   // e.g. allSmallDigits(99) --> false
   // e.g. allSmallDigits(1190) --> false
   // Question: is x here the same as the x in the main?
   public static boolean allSmallDigits(int x) {
      while(x > 0) {
         int last = x % 10;
         if(last >= 5)
            return false;
         x /= 10;
      }
      return true;
   }

   // returns true if the strings are reverse of each other
   // e.g. isReverse("hello","olleh") --> true
   // e.g. isReverse("time","fine") --> false
   public static boolean isReverse(String s1, String s2) {
      if(s1.length() != s2.length())
         return false;
      String s1Reversed = "";
      for(int i = s1.length() - 1; i >= 0; i--)
         s1Reversed += s1.charAt(i);
      return s1Reversed.equals(s2);
   }
   }