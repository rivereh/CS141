// River Hill
// CS 141
// HW Core Topics: Arrays, Methods, I/O
//
// This program will allow the user to play a
// phrase guessing game in which to user has
// to guess a randomly selected phrase by
// entering letters until they complete the phrase
// or run out of guesses

import java.util.*;
import java.io.*;

public class PhraseGuess {

    // how many times the user can guess a wrong letter
    public static final int MAX_WRONG = 3;

    public static void main(String[] args) throws FileNotFoundException {
        printIntro();
        String[] phrases = loadInput("hangman.txt");
        String puzzle = pickPuzzle(phrases);
        playGame(puzzle);
    }
   
    // prints intro text
    public static void printIntro() {
        System.out.println("Let's play a game of word guess.");
        System.out.println("You can guess wrong up to " + MAX_WRONG + " times.\n");
    }

    // loads a file in and returns a string array of all the phrases in the file
    public static String[] loadInput(String file) throws FileNotFoundException {
        Scanner phraseScan = new Scanner(new File(file));
        int arraySize = phraseScan.nextInt();
        phraseScan.nextLine(); // used since nextInt() doesn't return a new line
        String[] phrases = new String[arraySize];

        for(int i = 0; i < arraySize; i++) {
            phrases[i] = phraseScan.nextLine();
        }
        return phrases;
    }

    // returns a random string from the phrases array
    public static String pickPuzzle(String[] arr) {
        Random r = new Random();
        return arr[r.nextInt(arr.length)];
    }

    // allows the user to play one game of the guessing game
    public static void playGame(String puzzle) {
        Boolean[] letterCheck = new Boolean[puzzle.length()];
        initializeBooleans(letterCheck, puzzle);
        Scanner console = new Scanner(System.in);
        int guessCount = 0;
        Boolean solvedPuzzled = false;

        while(guessCount < MAX_WRONG && !solvedPuzzled) {
            System.out.println(printPuzzle(letterCheck, puzzle));
            System.out.print("Guess a letter > ");
            char guess = console.next().charAt(0);
            int guessesFound = checkGuess(puzzle, letterCheck, guess);
            
            if(0 < guessesFound)
                System.out.println(guess + " was found in the puzzle " + guessesFound + " times.\n");
            else {
                guessCount++;
                System.out.println(guess + " was not in the puzzle.");
                System.out.println("You have " + (MAX_WRONG - guessCount) + " more incorrect tries.\n");
            }
            
            if(checkIfSolved(letterCheck)) {
                System.out.println("You solved the puzzle! Good job!");
                solvedPuzzled = true;
            }
            else if(guessCount == MAX_WRONG) {
                System.out.println("You have reached the max guesses.");
                System.out.println("The puzzle was " + puzzle);
            }
        }
    }

    // checks for special characters in the puzzle and sets them to true
    // in the letterCheck array
    public static void initializeBooleans(Boolean[] letterCheck, String puzzle) {
        Arrays.fill(letterCheck, false);
        for(int i = 0; i < puzzle.length(); i++) {
            if(puzzle.charAt(i) == ',' || puzzle.charAt(i) == ' ' || puzzle.charAt(i) == '.' ||
                    puzzle.charAt(i) == '!' || puzzle.charAt(i) == '-' || puzzle.charAt(i) == '\'')
                letterCheck[i] = true;
        }
    }

    // prints puzzle according to the letterCheck array
    public static String printPuzzle(Boolean[] letterCheck, String puzzle) {
        String str = "";
        for(int i = 0; i < puzzle.length(); i++) {
            if(letterCheck[i])
                if(i == 0)
                    str += puzzle.charAt(i);
                else
                    str += " " + puzzle.charAt(i);
            else
                if(i == 0)
                    str += "_";
                else
                    str += " _";
        }
        return str;
    }
    
    // checks the users guess against the puzzle and returns how many times it occurs   
    public static int checkGuess(String puzzle, Boolean[] letterCheck, char guess) {
        int count = 0;
        for(int i = 0; i < puzzle.length(); i++) {
            if(Character.toLowerCase(puzzle.charAt(i)) == Character.toLowerCase(guess)) {
                count++;
                letterCheck[i] = true;
            }
        }
        return count;
    }
   
    // checks if the boolean array is all true or not
    public static Boolean checkIfSolved(Boolean[] letterCheck) {
        for(Boolean bool: letterCheck) {
            if(bool == false)
                return false;
        }
        return true;
    }
}

/*
  ----jGRASP exec: java PhraseGuess
 Let's play a game of word guess.
 You can guess wrong up to 3 times.
 
 _ _ _ _ !   _   _ _ _ _   _ _ _ _ _ _ _ _ .
 Guess a letter > h
 h was found in the puzzle 1 times.
 
 H _ _ _ !   _   _ _ _ _   _ _ _ _ _ _ _ _ .
 Guess a letter > E
 E was found in the puzzle 4 times.
 
 H e _ _ !   _   _ e e _   _ _ _ e _ _ _ _ .
 Guess a letter > l
 l was found in the puzzle 1 times.
 
 H e l _ !   _   _ e e _   _ _ _ e _ _ _ _ .
 Guess a letter > l
 l was found in the puzzle 1 times.
 
 H e l _ !   _   _ e e _   _ _ _ e _ _ _ _ .
 Guess a letter > y
 y was found in the puzzle 1 times.
 
 H e l _ !   _   _ e e _   _ _ _ e _ _ _ y .
 Guess a letter > r
 r was not in the puzzle.
 You have 2 more incorrect tries.
 
 H e l _ !   _   _ e e _   _ _ _ e _ _ _ y .
 Guess a letter > p
 p was found in the puzzle 1 times.
 
 H e l p !   _   _ e e _   _ _ _ e _ _ _ y .
 Guess a letter > i
 i was found in the puzzle 1 times.
 
 H e l p !   I   _ e e _   _ _ _ e _ _ _ y .
 Guess a letter > N
 N was found in the puzzle 1 times.
 
 H e l p !   I   n e e _   _ _ _ e _ _ _ y .
 Guess a letter > d
 d was found in the puzzle 2 times.
 
 H e l p !   I   n e e d   _ _ _ e _ _ d y .
 Guess a letter > s
 s was found in the puzzle 1 times.
 
 H e l p !   I   n e e d   s _ _ e _ _ d y .
 Guess a letter > o
 o was found in the puzzle 2 times.
 
 H e l p !   I   n e e d   s o _ e _ o d y .
 Guess a letter > m
 m was found in the puzzle 1 times.
 
 H e l p !   I   n e e d   s o m e _ o d y .
 Guess a letter > b
 b was found in the puzzle 1 times.
 
 You solved the puzzle! Good job!
 
  ----jGRASP: operation complete.
*/