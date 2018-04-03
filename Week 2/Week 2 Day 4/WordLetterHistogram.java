/*
 * Author's name and email: Anil Erturk, anilerturk1@gmail.com
 * Program description: Reads words from console(next version will read from 
 *    file) and stores how many of which word we have in arrays. Also you have to
 *    sort the words. When you are sorting the string array add a code that also 
 *    swaps positions of counter array elements for those words.
 * Latest version: 11:23 13/07/2017.
 * Older versions: 
 */

import java.util.Scanner;

public class WordLetterHistogram
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      
      String s;
      String[] wordHistogram = new String[10];
      int[] wordCounter = new int[10];
      int wordCounter2 = 0;
      
      System.out.println("Enter1");
      s = input.nextLine();
      
      label1:
      while (!(s.equals("e")))
      {
         int counter = 0;
         while (counter <= wordCounter2)
         {
            if (s.equals(wordHistogram[counter]))
            {
               wordCounter[counter]++;
               wordCounter2++;
               
               System.out.println("Enter3");
               s = input.nextLine();
               continue label1;
            }
            
            counter++;
         }
         
         wordHistogram[counter - 1] = s;
         wordCounter[counter -1]++;
         wordCounter2++;
         
         System.out.println("Enter2");
         s = input.nextLine();
      }
      
      int counter = 0;
      while (wordHistogram[counter] != null)
      {
         System.out.printf("%s: %d%n", wordHistogram[counter], wordCounter[counter]);
         
         counter++;
      }
   }
}