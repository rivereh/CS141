// River Hill
// CS 141
// HW Core Topics: Methods, passing information to methods, if/else
//
// This program will allow the user to guess a number generated
// by the computer

import java.util.Scanner;
import java.util.Random;

public class GuessingGame {

   public static final int RANGE = 10;

   public static void main(String[] args) {
   
      Scanner console = new Scanner(System.in);
      boolean userWantsToPlay;
      int totalGameCount = 0;
      int totalGuessCount = 0;
      int currentGuessCount = 0;
      int bestGuessCount = 0;
      
      printIntro();
      
      do {
         currentGuessCount = launchGame(console, RANGE);
         userWantsToPlay = askToPlayAgain(console);
         
         if(totalGameCount == 0)
            bestGuessCount = currentGuessCount;
         if(bestGuessCount > currentGuessCount)
            bestGuessCount = currentGuessCount;
         totalGuessCount += currentGuessCount;
         totalGameCount++;
      } while(userWantsToPlay);
      
      printGameStats(totalGameCount, totalGuessCount, bestGuessCount);
   }
   
   // This method will print out the game's intro text
   public static void printIntro() {
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and " + RANGE);
      System.out.println("and will allow you to guess until you get it.");
      System.out.println("For each guess, I will tell you whether the correct");
      System.out.println("answer is higher or lower than your guess.");
   }
   
   
   // This method will launch the game by picking a random number
   // and asking the user to guess until that number is read by the user
   // It will then return the total amount of guesses it took the user
   // and store it in a variable in main which is used to update the
   // total guess score
   public static int launchGame(Scanner console, int range) {
      Random rand = new Random();
   
      System.out.println("\nI'm thinking of a number between 1 and " + RANGE + "...");
      int winningNum = rand.nextInt(range) + 1;
      
      int userGuess;
      int guessCount = 0;
      do {
         System.out.print("Your guess? ");
         userGuess = console.nextInt();
         System.out.println(handleUserInput(userGuess, winningNum));
         guessCount++;
      } while(userGuess != winningNum);
      
      if(guessCount == 1)
         System.out.println("You got it right on the first guess!!");
      else
         System.out.println("You got it right in " + guessCount + " guesses");
         
      return guessCount;   
   }
   
   // This method is used by launchGame to determine if the user's guess
   // is higher or lower than the number the computer chose
   public static String handleUserInput(int userGuess, int winningNum) {
      if(userGuess < winningNum)
         return "It's higher.";
      else if(userGuess > winningNum)
         return "It's lower.";
      else
         return "";
   }
   
   // This method will ask the user if they would like to play
   // again and return a boolean if they say "y" or "yes"
   public static boolean askToPlayAgain(Scanner console) {
      System.out.print("Do you want to play again? ");
      String userChoice = console.next();
      return userChoice.equalsIgnoreCase("y") || userChoice.equalsIgnoreCase("yes");
   }
   
   // This method will print the user's stats from the games they've played
   public static void printGameStats(int totalGames, int totalGuesses, int bestGuessCount) {
      System.out.println("\nGame statistics:");
      System.out.println("\ttotal games\t\t= " + totalGames);
      System.out.println("\ttotal guesses\t= " + totalGuesses);
      System.out.printf("\tguesses/game\t= %.1f\n", (double)(totalGuesses / totalGames));
      System.out.println("\tbest game\t\t= " + bestGuessCount);
   }
}

/*
  ----jGRASP exec: java GuessingGame
 This program allows you to play a guessing game.
 I will think of a number between 1 and 10
 and will allow you to guess until you get it.
 For each guess, I will tell you whether the correct
 answer is higher or lower than your guess.
 
 I'm thinking of a number between 1 and 10...
 Your guess? 4
 It's higher.
 Your guess? 6
 It's lower.
 Your guess? 5
 
 You got it right in 3 guesses
 Do you want to play again? y
 
 I'm thinking of a number between 1 and 10...
 Your guess? 6
 It's lower.
 Your guess? 5
 It's lower.
 Your guess? 3
 It's higher.
 Your guess? 4
 
 You got it right in 4 guesses
 Do you want to play again? yes
 
 I'm thinking of a number between 1 and 10...
 Your guess? 5
 It's lower.
 Your guess? 6
 It's lower.
 Your guess? 3
 It's lower.
 Your guess? 1
 It's higher.
 Your guess? 2
 
 You got it right in 5 guesses
 Do you want to play again? no
 
 Game statistics:
 	total games		= 3
 	total guesses	= 12
 	guesses/game	= 4.0
 	best game		= 3
 
  ----jGRASP: operation complete.
/*