/*
 * Author's name and email: Anil Erturk, anilerturk1@gmail.com
 * Program description: Number guessing game. A random number between 1 and 1000
 *    is generated. Players tries to guess it. Computer tells if player guessed
 *    too high or too low.
 * Latest version: 07:38 11/10/2017. Changed some output formatting. But the big
 *  change is old version didnt reset the random number after player guessed it.
 * Older versions: 23:26 02/07/2017.
 */

import java.util.Scanner;
import java.security.SecureRandom;

public class GuessTheNumber
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in); 
      
      int randomNumber; // Between 1 and 1000.
      //int gameState;
      int playersGuess;
      
      randomNumber = randomNumber();
      
      System.out.println("Guess The Number game.()");
      
      do {
         System.out.print("Enter your guess or enter 0 to leave: ");
         playersGuess = input.nextInt();
         
         if (playersGuess < randomNumber)
            System.out.println("Too low, try again.");
         else if (playersGuess > randomNumber)
            System.out.println("Too high, try again.");
         else
         {
            System.out.println("\nCongratulations. You guessed the number!\n");
            randomNumber = randomNumber();
         }
      } while (playersGuess != 0);  
   }
   
   public static int randomNumber()
   {
      int randomNumber;
      SecureRandom randomNumbers = new SecureRandom();
      randomNumber = 1 + randomNumbers.nextInt(1000);
      return randomNumber;
   }
}