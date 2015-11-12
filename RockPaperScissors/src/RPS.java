/*
 * Ben Rockhold
 * CSC 142
 * Assignment 04
 * 10/30/15
 * 
 * Rock - Paper - Scissors
 * 
 */

import java.util.*;
public class RPS {
	public enum Guess {
		Rock,
		Paper,
		Scissors,
		Other
	};
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		// Let's play RPS!
		runRPS(System.out, input, rand);
	}
	
	// Play a nice game of rock-paper-scissors against the computer
	private static void runRPS(java.io.PrintStream out, Scanner in, Random rand){
		int[] gameResults = {0,0,0}; //Wins, Losses, Ties
		do {
			/* Increment the appropriate counter in the array
			 * The counter will be returned by the function computeResult
			 * The arguments of computeResult are returned by weaponSelect and machineWeapon
			 * This whole thing happens repeatedly as long as the user answers 'y'
			 */
			gameResults[
			            computeResult(
			            		out,
			            		in,
			            		weaponSelect(out, in),
			            		machineWeapon(out, rand)
			            		)
			            ]++;
		} while(newGame(out, in));
		// How did the user do?
		finalResults(out, gameResults);
	}
	
	// Get the user's preferred weapon!
	private static Guess weaponSelect(java.io.PrintStream out, Scanner in){
		out.println("Choose your weapon: (R/P/S)");
		String userSelection = in.next();
		return toGuess("rps".indexOf(userSelection.toLowerCase()));
	}
	
	// Convert integers to Guesses! (0 => rock, 1 => paper, 3 => scissors)
	private static Guess toGuess(int i) {
		switch (i) {
		case 0: return Guess.Rock;
		case 1: return Guess.Paper;
		case 2: return Guess.Scissors;
		default:
			return Guess.Other;
		}
	}
	
	// Randomly select the computer's weapon, and declare it
	private static Guess machineWeapon(java.io.PrintStream out, Random rand){
		int machineWeapon = rand.nextInt(3);
		String[] weaponNames = { "Rock", "Paper", "Scissors" };
		out.println("I choose "+weaponNames[machineWeapon]+"!");
		return toGuess(machineWeapon);
	}
	
	// Calculate whether the human won, based on the competing guesses
	private static boolean manWon(Guess man, Guess machine) {
		return (man == Guess.Rock && machine == Guess.Scissors) ||	// rock vs scissors 
				(man == Guess.Paper && machine == Guess.Rock) ||	// paper vs rock 
				(man == Guess.Scissors && machine == Guess.Paper);	// scissors vs paper
	}
	
	// Perform rock-paper-scissors game logic
	// Returns 0 for a win, 1 for a loss, 2 for a tie
	private static int computeResult(java.io.PrintStream out, Scanner in, Guess man, Guess machine){
		if (man == machine){
			out.println("It's a tie!");
			return 2;
		} else {
			if (manWon(man, machine)){
				out.println("You win this time.");
				return 0;
			} else if (man == Guess.Other){
				out.println("I am powerless against your secret weapon!");
				return 0;
			} else {
				out.println("I win, puny human.");
				return 1;
			}
		}
	}
	
	// New game selector; returns true for Y/y and false otherwise
	private static boolean newGame(java.io.PrintStream out, Scanner in){
		out.print("Do you want to play again? (y/n) ");
		if(in.next().toLowerCase().equals("y")) return true;
		return false;
	}
	
	// Present the game's results in attractive text form
	private static void finalResults(java.io.PrintStream out, int[] results){
		int numberOfGames = (results[0]+results[1]+results[2]);
		double winrate = (100.0*results[0]/(numberOfGames));
		out.println("Your overall results:");
		out.println("total games = " + numberOfGames);
		out.println("      wins: = " + results[0]);
		out.println("     losses = " + results[1]);
		out.println("       ties = " + results[2]);
		out.printf( "       win%% = %.2f", winrate);
	}

}
