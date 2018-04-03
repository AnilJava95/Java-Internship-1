/*
 * Author's name and email: Anil Erturk, anilerturk1@gmail.com
 * Program description: Write a method that reverses an array
 * Latest version: 13:37 05/07/2017. 
 * Older versions: 
 */

import java.util.Scanner;

public class ArrayReverse
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      
      int[] array1 = { 1, 2, 3, 4, 5 };
      
      displayArray(array1);
      array1 = reverseArray(array1);
      displayArray(array1);
   }
   
   private static void displayArray(int[] array1)
   {
      System.out.print("Array: ");
      
      for(int counter = 0; counter < array1.length; counter++)
      {
         System.out.print(array1[counter]);
      }
      
      System.out.println();
   }
   
   private static int[] reverseArray(int[] array1)
   {
      int[] array2 = new int[5];
      
      for(int counter = array1.length - 1; counter >= 0; counter--)
      {
         array2[counter] = array1[array1.length - counter - 1 ];
      }
      
      return array2;
      
   }
}