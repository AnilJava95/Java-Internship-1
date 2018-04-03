/*
 * Author's name and email: Anil Erturk, anilerturk1@gmail.com
 * Program description: Create a gradebook calculator that takes a number of 
 *    grades and calculates average, input = 101 will break the program.
 * Latest version: 16:55 04/07/2017. 
 * Older versions: 
 */

import java.util.Scanner;

public class Gradebook
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      
      int grade;
      int totalOfGrades = 0;
      int gradeCounter = 0;
      float averageOfGrades;
      
      do {
         System.out.print("Enter your grade or enter 101 to exit: ");
         grade = input.nextInt();
      
         if (grade == 101)
         {
            System.out.println("You left the program.");
            break;
         }
         else if (grade > 100 || grade < 0)
         {
            System.out.printf("Wrong value. Enter values between 0 and 100.%n%n");
         }

         gradeCounter++;
         totalOfGrades += grade;
      } while (true);
      
      
      if (gradeCounter == 0)
      {
         System.out.println("No grades were entered.");
      }
      else
      {
         averageOfGrades = (float)totalOfGrades / gradeCounter;
         
         //System.out.println(averageOfGrades);
         System.out.printf("Number of grades: %d, total of grades: %d, "
            + "averageOfGrades: %f%n", gradeCounter, totalOfGrades, averageOfGrades);
      }
   }
}