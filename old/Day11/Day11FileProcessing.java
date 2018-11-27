import java.io.*;
import java.util.*;

public class Day11FileProcessing {
  public static void main(String[] args) throws FileNotFoundException {
		Scanner numFile = new Scanner(new File("data/numbers2.txt"));
		//echo10(numFile);
     //echoAll(numFile);
	   //sumAll(numFile);
		//System.out.println("Are all tokens increasing? " + isIncreasing(numFile));

		//Scanner wordsFile = new Scanner(new File("words.txt"));
		//echoWords(wordsFile);
		//abcWords(wordsFile);

		Scanner checkFile = new Scanner(new File("data/grades.txt"));
		gradeReport(checkFile);
	}

	// echos the first 10 ints in a file
	public static void echo10(Scanner in ) {
		for (int i = 1; i <= 10; i++) {
			int token = in.nextInt();
			System.out.println("number = " + token);
		}
	}

	// echos all the ints in a file
	public static void echoAll(Scanner in ) {
		while (in.hasNextInt()) {
			int token = in.nextInt();
			System.out.println("number = " + token);
		}
	}

	// reads all int tokens from an input file, adding them up
	// prints total ints found, sum of all numbers, and the average
	public static void sumAll(Scanner in) {
      int sum = 0;
      int count = 0;
      while (in.hasNextInt()) {
   		int token = in.nextInt();
         sum += token;
         count++;
		}
      System.out.println("Total numbers: " + count);
      System.out.println("Sum: " + sum);
      System.out.printf("Average: %.2f", (double)(sum / count));
  }

	// determines whether or not all the tokens in an input file
	// are in increasing order (compares token to token)
	public static boolean isIncreasing(Scanner in) {
      int previousToken = 0;
      while (in.hasNextInt()) {
   		int token = in.nextInt();
         int token2 = in.nextInt();
         if(token >= token2)
            return false;
		}
		return true;
	}

	// echos all the words in a file
	public static void echoWords(Scanner in) {
      while (in.hasNext()) {
   		System.out.print(in.next() + " ");
		}
  }

	// prints the number of A, B, and C words in a file
	public static void abcWords(Scanner in) {
      int aWords = 0;
      int bWords = 0;
      int cWords = 0;
      while (in.hasNext()) {
         String token = in.next();
         token = token.toLowerCase();
   		if(token.charAt(0) == 'a')
            aWords++;
         else if(token.charAt(0) == 'b')
            bWords++;
         else if(token.charAt(0) == 'c')
            cWords++;
		}
      System.out.println("Total A Words: " + aWords);
      System.out.println("Total B Words: " + bWords);
      System.out.println("Total C Words: " + cWords);
  }

	// Reads file containing a series of student grade summaries:
	//    each summary contains a name followed by GPA grades
	// Report each student's average in the following format:
	//    Nikita = 3.83 average for 3 grades
	public static void gradeReport(Scanner in) throws FileNotFoundException {
   
      PrintStream outFile = new PrintStream(new File("report.txt"));
      
      while(in.hasNext()) {
         String name = in.next();
         
         double total = 0;
         int count = 0;
         while(in.hasNextDouble()) {
            total += in.nextDouble();
            count++;
         }
         
         double avg = total / count;
         
         System.out.printf("%s = %.2f average for %d grades\n", name, avg, count);
         outFile.printf("%s = %.2f average for %d grades\n", name, avg, count);  
      }
   }
}
