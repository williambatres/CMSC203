/*
 * Class: CMSC203 
 * Instructor: Khandan Monsh
 * Due: 2/21/2022
 * Description: This program generates a random number then asks the user
 * to guess said number between 0-100 and sets the bounds of the each guess (0-100)
 * based off the wrong guesses of the user depending if the number is higher
 * or lower then the random number that was generated. Once the correct number is guessed
 * program asks user if they would like to try again and iterates until user enters no.
 * Platform/compiler: Java compiler
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: William Batres
*/
import java.util.Scanner;

public class RandomNumberGuesser 
{

	public static void main(String[] args) 
	{
		//object pointing to the RNG class and its members
		RNG random = new RNG();
		
		//random number generated from the rand method of RNG class
		int randNum = random.rand();
		int userGuess;
		int lowGuess = 0, highGuess = 100;
		
		//String variable to hold user input if they would like to try again
		String userYesorNoStringInput;
		
		//user input for wither they would like to continue the game or not
		boolean userDecisionYesOrNo = false,correctGuess = false;
		
		//Gets the user keyboard input for their guess
		Scanner userInput = new Scanner(System.in);
		
		//Header for game
		System.out.println("Hello! Would you like to play a game?" +
					" Try to guess the number.");
		System.out.println("Please enter a number between 0 - 100");
		
		//This do while loop will run until the user has guessed the correct number 
		do
		{
			int firstGuessCounter = 0;
			//If statement used for only the first guess to print the line asking
			//for the first guess otherwise it will just take the users input
			if(firstGuessCounter == 0)
			{
				System.out.println("Please enter first guess");
			}
			userGuess = userInput.nextInt();
			
			// do-while loop to take the users input for the guess
			do
			{
				//if there guess is correct the correctGuess bool var is set to true
				//the the code steps through everything else in the do-while loop
				if(userGuess == randNum)
					correctGuess = true;
				//otherwise the input number gets sent into the else statemnt
				else 
				{
					//if the number is higher then the random number then the number is set
					//as the high bond of the guesses
					if(userGuess > randNum)
					{
						
						System.out.println("Number of guesses is " + random.getCount());
						System.out.println("Your guess is too high!");
						highGuess = userGuess;
						System.out.print("Please enter next guess ");
						displayBounds(lowGuess, highGuess);
						userGuess = userInput.nextInt();
						//while loop validates the input each time and only stops as long as the
						//input is within the bonds other wise it asks for a number inside the bounds
						while(random.inputValidation(userGuess, lowGuess, highGuess) == false)
						{
							userGuess = userInput.nextInt();
						}
						
					}
					//if the number is lower then the random number then the number is set
					//as the low bond of the guesses
					else 
					{
						
						System.out.println("Number of guesses is " + random.getCount());
						System.out.println("Your guess is too low ");
						lowGuess = userGuess;
						System.out.print("Please enter next guess ");
						displayBounds(lowGuess, highGuess);
						userGuess = userInput.nextInt();
						//while loop validates the input each time and only stops as long as the
						//input is within the bonds other wise it asks for a number inside the bounds
						while(random.inputValidation(userGuess, lowGuess, highGuess) == false)
						{
							userGuess = userInput.nextInt();
						}
						
					}
				}
			
				
			}while(correctGuess == false);
			

			System.out.println("Congratulations you guessed correctly!");
			System.out.println("try again? (yes or no)");
			//catches the enter that is left behind from the .nextInt() within
			//the do-while loop
			userInput.nextLine();
			//Takes the user decision as a string
			userYesorNoStringInput = userInput.nextLine();
			switch(userYesorNoStringInput)
			{
				case "yes": 
				case "Yes":
				{
					userDecisionYesOrNo = true;
					break;
				}
				case "no": 
				case "No":
				{
					userDecisionYesOrNo = false;
					break;
				}
			}
			
			
		}
		while(userDecisionYesOrNo == true);
		userInput.close();
		System.out.println("Thanks for playing...");
		System.out.println("Progreammers Name: William Batres");
	
		

	
	}
/**
 * prints the bounds of the guesses
 * @param low - lower bond of the guess
 * @param high - higher bond of the guess
 */

	public static void displayBounds(int low, int high)
	{
		System.out.println("between " + low + " and " + high);
	}

}

