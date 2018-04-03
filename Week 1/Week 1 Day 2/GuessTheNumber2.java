/*
 * Author's name and email: Anil Erturk, anilerturk1@gmail.com
 * Program description: Player guesses a random number between 1 and 1000. Difference
 *   between the other version is that this one counts number of tries. 
 * Latest version: 07:41 11/10/2017. Changed some output formatting. But the big
 *  change is old version didnt reset the random number after player guessed it.
 * Older versions: 23:58 02/07/2017.
 */

import java.util.Scanner;
import java.security.SecureRandom;

public class GuessTheNumber2
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in); 
      
      int randomNumber; // Between 1 and 1000.
      //int gameState;
      int playersGuess;
      int guessCounter = 0;
      
      randomNumber = randomNumber();
      
      System.out.println("Guess The Number game.");
      
      System.out.print("Enter your guess or enter 0 to leave: ");
         playersGuess = input.nextInt();
         guessCounter++;
      
      while (playersGuess != 0)
      {
         if (playersGuess < randomNumber)
            System.out.println("Too low, try again.");
         else if (playersGuess > randomNumber)
            System.out.println("Too high, try again.");
         else
         {
            System.out.printf("%nCongratulations. You guessed the number!%nNumber"
               + " of guesses: %d ", guessCounter);
            randomNumber = randomNumber();
            
            if (guessCounter < 10)
               System.out.println("Either you know the secret or you got lucky!\n");
            else if(guessCounter == 10)
               System.out.println("Aha! You know the secret!\n");
            else
               System.out.println("You should be able to do better!\n");
         }
         
         System.out.print("Enter your guess or enter 0 to leave: ");
         playersGuess = input.nextInt();
         guessCounter++;
      }  
   }
   
   public static int randomNumber()
   {
      int randomNumber;
      SecureRandom randomNumbers = new SecureRandom();
      randomNumber = 1 + randomNumbers.nextInt(1000);
      return randomNumber;
   }
}