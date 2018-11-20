// River Hill
// CS 141
// HW Core Topics: Methods, return values, and if/else statements
//
// This program will ask about the users meal and calorie intake and
// determing which day was closer to their calorie goal

import java.util.Scanner;

public class MyCalorieTracker {

   public static void main(String[] args) {
   
      Scanner console = new Scanner(System.in);
      
      printIntro();
      
      int calorieGoal = askForGoal(console);
      
      int dayOneNetCalories = askForDayInfo(console, calorieGoal, 1);
      int dayTwoNetCalories = askForDayInfo(console, calorieGoal, 2);
      
      printSummary(dayOneNetCalories, dayTwoNetCalories, calorieGoal);
      
      printDisclaimer();    
   }
   
   // Prints the intro text
   public static void printIntro() {
      System.out.println("This program compares your daily caloric intake");
      System.out.println("for two days and determines which day was better");
      System.out.println("in regards to reaching your fitness goals.\n");
   }
   
   // Asks user for their calorie goal
   public static int askForGoal(Scanner console) {
      System.out.print("What is your calorie goal for the day? > ");
      return console.nextInt();
   }
   
   // Asks user how many meals they ate and finds the total amount of calories
   // they've eaten and returns their net calorie intake for the day
   public static int askForDayInfo(Scanner console, int goal, int day) {
      System.out.println("\nInformation for Day #" + day + ":");
      System.out.print("\tHow many meals did you eat? ");
      int mealsAte = console.nextInt();
      
      int calorieIntake = 0;
      for(int i = 1; i <= mealsAte; i++) {
         System.out.print("\t\thow many calories were consumed in meal " + i + "? ");
         calorieIntake += console.nextInt();
      }
      
      System.out.println("\t-- Total caloric intake = " + calorieIntake + " --");
      
      System.out.println("\twhat was your activity level? 1) not active 2) lightly active");
      System.out.print("\t\t\t\t\t\t\t\t\t\t\t3) active or 4) very active? ");
      
      int activityLevel = console.nextInt();
      int estCalorieBurn = findEstCalorieBurn(activityLevel);
      
      System.out.println("\t-- Estimated active caloric burn = " + estCalorieBurn + " --");
      
      return calorieIntake - estCalorieBurn;
   }
   
   // Finds the estimated calories burned given an activity level
   // Used in askForDayInfo method
   public static int findEstCalorieBurn(int activityLevel) {
      if(activityLevel == 1)
         return 0;
      else if(activityLevel == 2)
         return 250;
      else if(activityLevel == 3)
         return 500;
      else if(activityLevel == 4)
         return 750;
      else
         return 0;
   }
   
   // Prints the user's summary and finds which day was closer
   // to their original goal along with their average net calorie intake
   public static void printSummary(int dayOne, int dayTwo, int goal) {
      System.out.println("\nDay 1 Net Calories = " + dayOne);
      System.out.println("Day 2 Net Calories = " + dayTwo);
      
      int dayOneDifference = goal - dayOne;
      int dayTwoDifference = goal - dayTwo;
      
      if(dayOneDifference > dayTwoDifference)
         System.out.println("You were closer to your goal on Day 1**");
      else if (dayTwoDifference > dayOneDifference)
         System.out.println("You were closer to your goal on Day 2**");
      else
         System.out.println("Both Day 1 and Day 2 net calories were the same**");
         
      System.out.printf("Average Net Calories = %.1f", (double)(dayOne + dayTwo) / 2);
   }
   
   // Prints the disclaimer
   public static void printDisclaimer() {
      System.out.println("\n\n** DISCLAIMER: Summary results are probably wrong.");
      System.out.println("   I wouldn't trust them if I were you.");
   }
}

/*
     ----jGRASP exec: java MyCalorieTracker
 This program compares your daily caloric intake
 for two days and determines which day was better
 in regards to reaching your fitness goals.
 
 What is your calorie goal for the day? > 1200
 
 Information for Day #1:
 	How many meals did you eat? 3
 		how many calories were consumed in meal 1? 350
 		how many calories were consumed in meal 2? 350
 		how many calories were consumed in meal 3? 600
 	-- Total caloric intake = 1300 --
 	what was your activity level? 1) not active 2) lightly active
 											3) active or 4) very active? 1
 	-- Estimated active caloric burn = 0 --
 
 Information for Day #2:
 	How many meals did you eat? 5
 		how many calories were consumed in meal 1? 250
 		how many calories were consumed in meal 2? 180
 		how many calories were consumed in meal 3? 400
 		how many calories were consumed in meal 4? 250
 		how many calories were consumed in meal 5? 600
 	-- Total caloric intake = 1680 --
 	what was your activity level? 1) not active 2) lightly active
 											3) active or 4) very active? 3
 	-- Estimated active caloric burn = 500 --
 
 Day 1 Net Calories = 1300
 Day 2 Net Calories = 1180
 You were closer to your goal on Day 2**
 Average Net Calories = 1240.0
 
 ** DISCLAIMER: Summary results are probably wrong.
    I wouldn't trust them if I were you.
 
  ----jGRASP: operation complete.

*/