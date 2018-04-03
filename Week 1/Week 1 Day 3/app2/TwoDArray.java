/*
 * Author's name and email: Anil Erturk, anilerturk1@gmail.com
 * Program description: Write a program that lists areas in cities using a two 
 *    dimensional array. City and area names are taken from user and displayed.
 * Latest version: 12:14 05/07/2017. 
 * Older versions: 
 */

import java.util.Scanner;

public class TwoDArray
{
   public static void main(String[] args)
   {
      String[][] citiesAndAreas = new String[2][2];
      
      initializeArray(citiesAndAreas);
      displayArray(citiesAndAreas);
   }
   
   private static void initializeArray(String[][] array1)
   {
      Scanner input = new Scanner(System.in);
      
      for(int counter = 0; counter < array1.length; counter++)
      {
         for(int counter2 = 0; counter2 < array1.length; counter2++)
         {
            System.out.printf("Enter name of %d. city and %d. area: ", counter
               , counter2);
            array1[counter][counter2] = input.nextLine();
         }
         System.out.println();   
      }
   }
   
   private static void displayArray(String[][] array1)
   {
      for(int counter = 0; counter < array1.length; counter++)
      {
         for(int counter2 = 0; counter2 < array1.length; counter2++)
         {
            System.out.printf("%d. city, %d. area: %s%n", counter, counter2, 
               array1[counter][counter2]);
         }
         System.out.println();   
      }
   }
}