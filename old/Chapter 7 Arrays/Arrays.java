import java.util.*;
import java.io.*;

public class Arrays {

   public static void main(String[] args) {
      
      
      //arrayBasics();
      int[] nums = buildOddArray(5);
      fillWithOdds(numArr);
      System.out.println(numArr);
      
   }
   
   
   public static void arrayBasics() {
   
      Scanner console = new Scanner(System.in);
   
      double[] temperature = new double[3];
      
      for (int i = 0; i < temperature.length; i++) {
         System.out.print("Enter temperature: ");
         temperature[i] = console.nextDouble();
      }

      System.out.println(temperature);
   }
   
   public static int[] buildOddArray(int size) {
      int[] data = nw int[size];
      for(int i = 0; i < data.length; i++)
         data[i] = 2 * 1 + 1;
      return data;     
   }
   
   

}