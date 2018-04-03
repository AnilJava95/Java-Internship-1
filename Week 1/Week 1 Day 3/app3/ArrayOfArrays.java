/*
 * Author's name and email: Anil Erturk, anilerturk1@gmail.com
 * Program description: How to declare, initialize, use array of arrays.
 * Latest version: 14:09 05/07/2017.
 * Older versions: 
 */

import java.util.Scanner;

public class ArrayOfArrays
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      
      double[][] array1 = new double[5][];
      
      array1[0] = new double[2];
      array1[1] = new double[5];
      array1[2] = new double[3];
      array1[3] = new double[2];
      array1[4] = new double[3];
      
      for (int counter = 0; counter < array1.length; counter++)
      {
         for (int counter2 = 0; counter2 < array1[counter].length; counter2++)
         {
            System.out.print(array1[counter][counter2]);
         }
         System.out.println("");
      }
   }
}



