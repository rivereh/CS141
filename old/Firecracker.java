// River Hill
// CS 141
// HW Core Topics: Methods, loops, and global variables
//
// This program will output a firecracker in which the size
// is determined by a global variable set by the user 

   
public class Firecracker
{  

   // MAX controls how much the firecracker will be
   public static final int MAX = 3;

   public static void main(String[] args)
   {
      printFirecracker();
   }
   
   // Calls seperate functions to print firecracker
   public static void printFirecracker()
   {
      printTop();
      printMiddle();
      printBottom();
   }
   
   // Prints top of firecracker
   public static void printTop()
   {
      for(int line = 0; line <= MAX; line++)
      {
         for(int space = 1; space <= -1 * line + MAX; space++)
         {
            System.out.print(" ");
         }
         System.out.print("/");
         for(int x = 0; x <= 2 * line; x++)
         {
            System.out.print("x");
         }
         System.out.println("\\");
      }
      printSeperator();
   }
   
   // Prints the firecracker seperator
   public static void printSeperator()
   {
      System.out.print("[=");
      for(int i = 0; i < MAX; i++)
      {
         System.out.print("I=");
      }
      System.out.println("]");
      for(int i = 0; i < MAX * 2 + 3; i++)
      {
         System.out.print("=");
      }
      System.out.println();
   }
   
   // Prints firecracker part above the middle seperator
   public static void printMiddle()
   {
      for(int i = 1; i <= MAX - 2; i++)
      {
         System.out.print("  |");
         for(int j = 1; j <= MAX - 1; j++)
         {
            System.out.print("-|");
         }
         System.out.println();
      }
      printSeperator();
   }
   
   // Prints firecracker part after middle seperator
   public static void printBottom()
   {
      for(int i = 1; i <= MAX; i++)
      {
         System.out.print(" |");
         for(int j = 1; j <= 1 * i - 1; j++)
         {
            System.out.print(".");
         }
         for(int j = 0; j <= MAX * 2 - 2 * i; j++)
         {
            System.out.print("~");
         }
         for(int j = 1; j <= 1 * i - 1; j++)
         {
            System.out.print(".");
         }
         System.out.println("|");
      }
      printSeperator();
      printStand();
   }
   
   // Prints the stand for the firecracker
   public static void printStand()
   {
      for(int line = 0; line < MAX - 1; line++)
      {
         for(int space = 0; space <= MAX - 1 * line; space++)
         {
            System.out.print(" ");
         }
         for(int slash = 0; slash < 1 * line; slash++)
         {
            System.out.print("/");
         }
         for(int pipe = 0; pipe < 1; pipe++)
         {
            System.out.print("|");
         }
         for(int slash = 0; slash < 1 * line; slash++)
         {
            System.out.print("\\");
         }
         System.out.println();
      }
   }
}

/*
  Expected output when MAX = 3
  
 ----jGRASP exec: java Firecracker
    /x\
   /xxx\
  /xxxxx\
 /xxxxxxx\
 [=I=I=I=]
 =========
   |-|-|
 [=I=I=I=]
 =========
  |~~~~~|
  |.~~~.|
  |..~..|
 [=I=I=I=]
 =========
     |
    /|\
 
  ----jGRASP: operation complete.

*/