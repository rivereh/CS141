import java.util.Scanner;

public class Day05InputDecisions {

   public static void main(String[] args) {
      // creates a Scanner object called console for User Input
      Scanner console = new Scanner(System.in);
      
      //System.out.print("What is your name: ");
      //String name = console.next();
      //System.out.println("Hello " + name + "!");
      
      
      //repeatPhrase("Hello", 3);
       //repeatPhrase(console);
       
       //System.out.println(calcGrade(console));
      
       double finalPercentage = calcGrade(console);
       System.out.println("Expected Final Grade: " + finalPercentage);
       double finalGpa = calcGPA(finalPercentage);
       System.out.print(finalGpa);
   }
   
   // takes a phrase and a number 
   // prints the phrase to the screen that number of times
   // what if "returns"?
   public static void repeatPhrase(String phrase, int times) {
      for(int i = 1; i <= times; i++) {
         System.out.println(phrase);
      }
   }
   
   // prompts for a phrase and a number
   // prints the phrase to the screen, one letter per line, all caps
   // repeatPhrase() where the user types in "try" and 3
   /* should produce: 
      TTT
      RRR
      YYY
   */
   public static void repeatPhrase(Scanner console) {
      System.out.print("Enter phrase and number: ");
      
      String input = console.nextLine();
      String[] inputArr = input.split(" ");
      
      String phrase = inputArr[0];
      phrase = phrase.toUpperCase();
      int times = Integer.parseInt(inputArr[1]);
      
      for(int i = 0; i < phrase.length(); i++) {
         for(int j = 1; j <= times; j++) {
            System.out.print(phrase.charAt(i));
         }
         System.out.println();
      }
   }
   
   // prompts for your percentage grade in the following categories:
   // Individual Homework (30%)
   // Learning Practice (20%)
   // Midterm (20%)
   // Final (30%)
   // returns the calculated final percentage for the class
   //TODO: PERCENTAGE GRADE METHOD
   
   // takes a percentage grade as a parameter 
   // returns the calculated gpa, according to the following:
   // >= 95% is a 4.0
   // 94 is a 3.9
   // 93 is a 3.8
   // 92 is a 3.7
   // 91 is a 3.6
   // 90 is a 3.5
   // else return 2.0 for now 
   //TODO: GPA METHOD
   
   public static double calcGrade(Scanner console)
   { 
      double gradeSum = 0;
      
      System.out.println("Please enter grade percentages for each category");
      System.out.println();
      
      System.out.print("Individual Homework: ");
      gradeSum += console.nextInt() * .3;
      System.out.print("Learning Practice: ");
      gradeSum += console.nextInt() * .2;
      System.out.print("Midterm: ");
      gradeSum += console.nextInt() * .2;
      System.out.print("Final: ");
      gradeSum += console.nextInt() * .3;
      System.out.println();      
      
      return gradeSum;
   }
   
   public static double calcGPA(double grade) 
   {
      if(grade >= 95)
         return 4.0;
      else if(grade >= 94)
         return 3.9;
      else if(grade >= 93)
         return 3.8;
      else if (grade >= 92)
         return 3.7;
      else if(grade >= 91)
         return 3.6;
      else if (grade >= 90)
         return 3.5;
      else
         return 2.0;
   }
}