import java.util.Scanner;

public class PracticeInputAndIf {

   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      
      //problem1(console);
      //problem2(console);
      //problem3(0);
      //problem3(19221);
      
       //String multi5 = problem4(25);
       //System.out.println(multi5);
       //multi5 = problem4(22);
       //System.out.println(multi5);
      
       //problem5(console);
      
       //problem6(console);
      
       //problem7("washington");
       //problem7("Texas");
      
       //int oz = problem8(console);
       //System.out.println("contains " + oz + " ounces.");
   }
   public static void problem1(Scanner console) {
      System.out.print("Enter number: ");
      int num = console.nextInt();
      if(num >= 67) {
         System.out.println("PASSING");
      }
      else {
         System.out.println("NOT PASSING");
      }
   }
   public static void problem2(Scanner console) {
      System.out.print("Enter color: ");
      String color = console.next();
      if(color.equalsIgnoreCase("green"))
         System.out.println("GO");
      else if(color.equalsIgnoreCase("yellow"))
         System.out.println("SLOW");
      else 
         System.out.println("STOP");   
   }
   
   public static void problem3(int num) {
      if(num % 2 == 0)
         System.out.println("EVEN");
      else
         System.out.println("ODD");
   }
   
   public static String problem4(int num) {
      if(num % 5 == 0)
         return "MULTIPLE OF 5";
      else
         return "NOT A MULTIPLE OF 5";
   }
   
   public static void problem5(Scanner console) {
      System.out.print("Enter a number: ");
      int num = console.nextInt();
      
      if(num < 10) 
         System.out.println("ONE DIGIT");
      else if(num >= 10 && num < 100)
         System.out.println("TWO DIGITS");
      else if(num >= 100 && num < 1000)
         System.out.println("THREE DIGITS");
      else
         System.out.println("MANY DIGITS");
   }
   
   public static void problem6(Scanner console) {
      System.out.print("Enter jersey number: ");
      int num = console.nextInt();
      
      if(num == 12 || num == 71 || num == 80)
         System.out.println("That number is retired from the Seattle Seahawks!");
   }
   
   public static void problem7(String state) {
      state = state.toLowerCase();
      
      if(state.equals("washington") || state.equals("oregon") || state.equals("idaho"))
         System.out.println("This state is in the PNW");
      else
         System.out.println("You should move to the PNW; it's great here!");
   }
   
   public static int problem8(Scanner console) {
      System.out.print("Enter drink size: ");
      String size = console.next();
      size = size.toLowerCase();
      
      if(size.equals("short"))
         return 8;
      else if(size.equals("tall"))
         return 12;
      else if(size.equals("grande"))
         return 16;
      else if(size.equals("venti"))
         return 20;
      else
         return 0;
   }
   
}

