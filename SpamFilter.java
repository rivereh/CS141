// River Hill
// CS 141
// HW Core Topics: Arrays, PrintStreams, line/token based processing, and strings
//
// This program will read through and email list and figure out which ones are spam,
// it will then print to a new file with a new list of the subject lines and let you
// see which ones contained spam like words and crossed the spam word threshold.

import java.io.*;
import java.util.*;

public class SpamFilter {

   public static final String[] spamWords = new String[] {"offer", "wire", "bank", "fund", "transfer", "lottery"};
   public static final int threshold = 2;
   
   public static void main(String[] args) throws FileNotFoundException {
      
      Scanner emailFile = new Scanner(new File("emails.txt"));
      PrintStream outFile = new PrintStream(new File("summary.txt"));

      int emailCount = findEmailCount("emails.txt");
      String[] emails = createEmailArray("emails.txt", emailCount);
      String[] filteredEmails = filterSpam(emails, emailCount);
              
      for(String email: filteredEmails) {
         outFile.println(email);
      }
   }
   
   // Finds how many emails are in the file
   public static int findEmailCount(String fileName) throws FileNotFoundException {
      
      Scanner in = new Scanner(new File(fileName));
      int emailCount = 0;
      
      while(in.hasNextLine()) {
         String line = in.nextLine();
         if(line.contains("---eom---"))
            emailCount++;
      }
      
      return emailCount;
   }
   
   // Goes through the email file and adding them to an array when it reaches the end of email
   public static String[] createEmailArray (String fileName, int size) throws FileNotFoundException {
   
      Scanner in = new Scanner(new File(fileName));
      String[] emails = new String[size];
      String email = "";
      int count = 0;
      
      while(in.hasNextLine()) {
         String line = in.nextLine();
         email += line + "\n";
         if(line.contains("---eom---")) {
            emails[count] = email;
            email = "";
            count++;
         }
      }
      
      return emails;
   }
   
   // Finds out if an emails contains spam words above the threshold and makes a new array
   // with the subject line of the emails and whether it is spam or not
   public static String[] filterSpam(String[] emailArray, int mailCount) {
   
      System.out.println();
      String[] filteredArray = new String[mailCount + 2];
      int itemCount = 1;
      
      filteredArray[0] = "Ignore the robots reading your emails...\n";
      filteredArray[mailCount + 1] = "\n" + mailCount + " emails processed.";
      
      for(String email: emailArray) {
         
         Scanner eScan = new Scanner(email);
         String subject = ""; 
         int spamCount = 0;
               
         while(eScan.hasNext()) {
            String word = eScan.next();
            
            for(String spam: spamWords) {
               if(word.contains(spam))
                  spamCount++;
            }
         }
         
         String[] lines = email.split("\\r?\\n");
         for(String line: lines) {
         
            if(line.contains("Subject")) {
               if(spamCount >= threshold)
                  filteredArray[itemCount] = ("**SPAM** " + line.substring(line.indexOf(": ") + 2));
               else
                  filteredArray[itemCount] = ("\t\t\t " + line.substring(line.indexOf(": ") + 2));
            }
         }
         
         itemCount++;
      }    
      
      return filteredArray;
   }
}

/*
  ---- summary.txt
 
 Ignore the robots reading your emails...
 
 			 I ran out of cookies
 			 From the bottom of my heart...
 **SPAM** Immediate Attention Requested
 **SPAM** You're a winner!
 **SPAM** Your trees are so happy!
 			 (no subject)
 			 Don't forget!
 **SPAM** SP for PC
 
 8 emails processed.
 
  ---- operation complete.
*/