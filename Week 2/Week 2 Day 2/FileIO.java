/*
 * Author's name and email: Anil Erturk, anilerturk1@gmail.com
 * Program description: Takes 10 integers from user that are even and between 
 *    -1000 and 1000(included) and prints them in the file. Then generates random
 *    numbers between 0 and 100(included) and prints 10 odd ones.
 * Latest version: 15:33 11/07/2017.
 * Older versions: 
 */

import java.util.Scanner;
import java.io.*;
import java.security.SecureRandom;

public class FileIO // Week 2 Day 2
{
   public static void main(String[] args) throws FileNotFoundException
   {
      Scanner input = new Scanner(System.in);
      SecureRandom randomGenerator = new SecureRandom();
      int randomNumber;
      int number;
      
      FileOutputStream f = new FileOutputStream("C:\\Users\\Anil\\Desktop\\txt.txt") ;
      PrintStream write = new PrintStream(f);
      
      int lineCounter = 1;
      do
      {
         System.out.printf("%d. Enter 10 even numbers[-1000, 1000]: %n", lineCounter);
         number = input.nextInt();
         
         if (number % 2 == 0 && number <= 1000 && number >= -1000)
         {
            write.println(number);
            lineCounter++;
         }
         else
         {
            System.out.println("Wrong value.");
         }
      } while (lineCounter <= 10);
      
      write.println();
      
      
      // Writes 10 random number.
      lineCounter = 0;
      do
      {
         randomNumber = randomGenerator.nextInt(1000);
         
         if ( randomNumber % 2 == 1)
         {
            write.println(randomNumber);
            lineCounter++;
         }
      } while (lineCounter < 10);
   }
}