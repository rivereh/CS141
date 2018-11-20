public class Day04ASCII {

   public static void main(String[] args) {
      //numberTri();
      hourglass();
   }
   
   
   /* This method should produce the following
      -----1-----
      ----333----
      ---55555---
      --7777777--
      -999999999-
   */
   public static void numberTri() {
   
      
   
   }
   
   
   /* This method should produce the following
      |""""""""""|
       \::::::::/
        \::::::/
         \::::/
          \::/
           ||
          /::\
         /::::\
        /::::::\
       /::::::::\
      |""""""""""|
   */
   public static void hourglass() {
      
      line();
      
      upperCone();
      
      lowerCone();
      
      line();
      
      
   }
   
   
   public static void line() {
      System.out.print("|");
      for(int i = 1; i <= 10; i++) {
         System.out.print("\"");
      }
      System.out.println("|");
   }
   
   public static void upperCone() {
      for(int line = 1; line <= 4; line++) {
         for(int space = 1; space <= line; space++) {
            System.out.print(" ");
         }
         System.out.print("\\");
         for(int colon = 1; colon <= ((-2 * line) + 10); colon++) {
            System.out.print(":");
         }
         System.out.println("/");
      }
      System.out.println("     ||");
   }
   
   public static void lowerCone() {
      for(int line = 1; line <= 4; line++) {
         for(int space = 1; space <= (-1 * line + 5); space++) {
            System.out.print(" ");
         }
         System.out.print("/");
         for(int colon = 1; colon <= (2 * line); colon++) {
            System.out.print(":");
         }
         System.out.print("\\");
         System.out.println();
      }
   }
 
   
}