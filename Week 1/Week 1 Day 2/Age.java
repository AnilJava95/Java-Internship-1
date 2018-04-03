/*
 * Author's name and email: Anil Erturk, anilerturk1@gmail.com
 * Program description: Create a program that informs people if they are old or 
 *    young according to the input provided.
 * Latest version: 16:56 04/07/2017. 
 * Older versions: 
 */

import java.util.Scanner;

public class Age
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      
      double age;
      
      do {
         System.out.print("Enter your age to see if you are young or old or enter -1"
            + " to exit: ");
         try
         {
            age = Integer.parseInt(input.nextLine());

            if (age == -1)
            {
               System.out.println("You left the program.");
               System.exit(0);
            }
            else if (age >= 0 && age <= 35)
            {
               System.out.printf("You are young.%n%n");
            }
            else if (age > 35 && age <= 123)
            {
               System.out.printf("You are old.%n%n");
            }
            else
            {
               System.out.printf("Wrong value.%n%n");
            }
         }
         catch(Exception exception)
         {
            System.out.println("This is not an integer");
         }
      } while (true);
   }
}