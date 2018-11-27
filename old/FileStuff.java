import java.io.*;
import java.util.*;

public class FileStuff {


   public static void main(String[] args) throws FileNotFoundException {
      
      
      //File f = new File("test.txt");
      //System.out.println("exists returns " + f.exists());
      //System.out.println("canRead returns " + f.canRead());
      //System.out.println("length returns " + f.length());
      //System.out.println("getAbsolutePath returns " + f.getAbsolutePath());
      
      countWords();
      
   }
   
   public static void countWords() throws FileNotFoundException {
      Scanner input = new Scanner(new File("test.txt"));
      int count = 0;
      while(input.hasNext()) {
         String word = input.next();
         count++;
      }
      System.out.println("total words: " + count);
   }

}