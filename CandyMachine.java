// River Hill
// CS 141
//
// This program will print a virtual store and
// allow the user to purchase candy

import java.util.Scanner;

public class CandyMachine {

   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      
      printIntroText();
      
      double money = askUserMoney(console);
      double userChoicePrice = printStoreItems(console);
      
      handlePurchase(money, userChoicePrice);
   }
   
   // Prints the store's intro text
   public static void printIntroText() {
      System.out.println("Welcome to Shoreline's Computer Candy Machine!");
      System.out.println("(All candy provided is virtual.)\n");
   }
   
   // Asks and returns how much money the user has
   public static double askUserMoney(Scanner console) {
      System.out.print("How much money ya got? > $");
      double money = console.nextDouble();
      System.out.println("$" + money + ", that's all?\n");
      
      return money;
   }
   
   // Prints store items and returns cost of selected candy
   public static double printStoreItems(Scanner console) {
      System.out.println("Well, lemme tell ya what we got here.");
      System.out.println("A $0.65 Twix");
      System.out.println("B $0.50 Chips");
      System.out.println("C $0.75 Nutter Butter");
      System.out.println("D $0.65 Peanut Butter Cup");
      System.out.println("E $0.55 Juicy Fruit Gum\n");
      
      System.out.print("So, what'll ya have? > ");
      String userChoice = console.next();
      userChoice = userChoice.toLowerCase();
      
      double price = 0;
      
      if(userChoice.equals("a"))
         price = 0.65;
      else if(userChoice.equals("b"))
         price = 0.50;
      else if(userChoice.equals("c"))
         price = 0.75;
      else if(userChoice.equals("d"))
         price = 0.65;
      else if(userChoice.equals("e"))
         price = 0.55;
         
      return price;
   }
   
   // Finds out if the user can afford their selected candy and prints change
   public static void handlePurchase(double money, double price) {
      if(price == 0.0) {
         System.out.println("\nInvalid selection!");
      }
      else if(money >= price) {
         System.out.println("\nThanks for purchasing candy through us.");
         System.out.printf("Please take your candy and your $%.2f change!", (money - price));
      }
      else {
         System.out.printf("\nYou're broke. Take your $%.2f and go elsewhere.", money);
      }
   }
}

/*
    ----jGRASP exec: java CandyMachine
 Welcome to Shoreline's Computer Candy Machine!
 (All candy provided is virtual.)
 
 How much money ya got? > $0.76
 $0.76, that's all?
 
 Well, lemme tell ya what we got here.
 A $0.65 Twix
 B $0.50 Chips
 C $0.75 Nutter Butter
 D $0.65 Peanut Butter Cup
 E $0.55 Juicy Fruit Gum
 
 So, what'll ya have? > a
 
 Thanks for purchasing candy through us.
 Please take your candy and your $0.11 change!
  ----jGRASP: operation complete.
*/