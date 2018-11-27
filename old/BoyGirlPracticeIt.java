import java.util.*;
import java.io.*;

public class BoyGirlPracticeIt {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner input = new Scanner(new File("Day11/boyGirlNames.txt"));
      boyGirl(input);
   }
   
   public static void boyGirl(Scanner in) {
      
      int boyNamesTotal = 0;
      int girlNamesTotal = 0;
      int boyGroups = 0;
      int girlGroups = 0;
      
      while(in.hasNext()) {
         String name = in.next();
         boyGroups++;
         boyNamesTotal += in.nextInt();
         if(in.hasNext()) {
            name = in.next();
            girlGroups++;
            girlNamesTotal += in.nextInt();
         }
      }
      
      System.out.println(boyGroups + " boys, " + girlGroups + " girls");
      System.out.println("Difference between boys' and girls' sums: " + Math.abs(boyNamesTotal - girlNamesTotal));
      
   }
   
}