/*
 * Plays a nice game of tic-tac-toe.
 * Does not want to lose.
 * 
 * CS142
 * 11 / 10 / 15
 * 
 * Amy Swanson
 * Ben Rockhold
 * 
 */

import java.util.*;

public class TicTacToe {
	private enum Marking {
		X,
		O,
		Null
	};
	
	public static void main(String[] args) {
		// Initially, the board is blank.
		Marking[][] boardState = {
								 {Marking.Null, Marking.Null, Marking.Null},
								 {Marking.Null, Marking.Null, Marking.Null},
								 {Marking.Null, Marking.Null, Marking.Null}
								 };
		Scanner input = new Scanner(System.in);
		
		playTTT(boardState, input, System.out);
	}
	
	private static void playTTT(Marking[][] boardState, Scanner in, java.io.PrintStream out){
		/*
		 * Choose who goes first
		 *  if human, do the first turn
		 *   otherwise pass
		 *  loop:
		 *  		one side takes a turn
		 *  		score the game, and see if it's over 
		 */
		if (chooseFirst(in, out) == Marking.X){
			drawBoard(boardState, out);
			applyMove(boardState, humanMove(boardState, in, out), Marking.X);
		}
		drawBoard(boardState, out);
		int count = 1; // Swaps between 1 and 2, determines which player goes
		do {
			if (count == 1){
				// temporarily this is always a human-versus-human game
				applyMove(boardState, humanMove(boardState, in, out), Marking.O);
				//applyMove(boardState, computerMove(boardState,  out), Marking.O);
			} else {
				applyMove(boardState, humanMove(boardState, in, out), Marking.X);
			}
			count = count%2 +1; // swap count between 1 and 2
			drawBoard(boardState, out);
			
			Marking score = scoreBoard(boardState);
			if (score != Marking.Null){
				out.println(score+" has won the game!");
				return;
			}
		} while (true);
	}
	
	// Ask the user which player should go first. Return the marker of the resulting first player.
	private static Marking chooseFirst(Scanner in, java.io.PrintStream out){
		String choice;
		do {
			out.println("Do you want to go first? (y/n)");
			choice = in.next();
			if (choice.toLowerCase().equals("y"))
			{
				in.nextLine(); // clear the input
				return Marking.X;
			} else if (choice.toLowerCase().equals("n")) {
				in.nextLine(); // clear the input
				return Marking.O;
			} else {
				out.println("Unrecognised choice, please try again.");
			}
		} while (true);
	}
	
	// Take a given game state, and draw it to the screen
	private static void drawBoard(Marking[][] boardState, java.io.PrintStream out){
		String[][] boardParts = {{" "," | "," | ","\n------------\n"},
								 {" "," | "," | ","\n------------\n"},
								 {" "," | "," | ","\n"}
								 };
		for (int indexA = 0; indexA < boardState.length; indexA++){
			for (int indexB = 0; indexB < boardState[indexA].length; indexB++){
				out.print(boardParts[indexA][indexB]);
				if (boardState[indexA][indexB] == Marking.X){
					out.print("X");
				} else if (boardState[indexA][indexB] == Marking.O){
					out.print("O");
				} else {
					out.print("#");
				}
			}
			// Print the board dividers
			out.print(boardParts[indexA][3]);
		}	
	}
		
	private static int[] humanMove(Marking[][] boardState, Scanner in, java.io.PrintStream out){
		int[] move = {2,2};
		do{
			out.print("Where do you want to move? (1-indexed x y): ");
			String input = in.nextLine();
			// Sanitize the input, or at least try
			if (input.length() == 3){
				move[0] = "0123456789".indexOf(input.toLowerCase().charAt(0))-1;
				move[1] = "0123456789".indexOf(input.toLowerCase().charAt(2))-1;
				if (validateMove(boardState, move))  return move;
			}
			out.println("Designated move is invalid; please try again.");
		} while (true);
	}
	
	// Given a chosen move and the state of the board, verify that the move is acceptable
	private static boolean validateMove(Marking[][] boardState, int[] move){
		// Check to see if the position is valid (0-2),(0-2)
		if (move[0] < 0 || move[0] > 2 || move[1] < 0 || move[1] > 2)
			return false;
		// Check to see if the location on the board is claimed
		if (boardState[move[0]][move[1]] != Marking.Null)
			return false;
		return true;
	}
	
	// Takes a boardState, and adds the new move from the player
	private static Marking[][] applyMove(Marking[][] boardState, int[] move, Marking player){
			boardState[move[0]][move[1]] = player;
			return boardState;
		}
	
	// Given a board state, determine if the game is over, and return the winner
	private static Marking scoreBoard(Marking[][] boardState){
		// Check if the diagonals are equal
		if ((boardState[0][0] == boardState[1][1] && boardState[0][0]== boardState[2][2]) ||
			(boardState[0][2] == boardState[1][1] && boardState[0][2] == boardState[2][0]))
		{
			// Diagonals share the center, so return whatever type currently owns the center
			if (boardState[1][1] != Marking.Null) return boardState[1][1];
		}
		// Check the rows
		for (int indexA = 0; indexA < 3; indexA++){
			if (boardState[indexA][0] == boardState[indexA][1] && boardState[indexA][0] == boardState[indexA][2]){
				if (boardState[indexA][0] != Marking.Null) return boardState[indexA][0];
			}	
		}
		// Check the columns
		for (int indexB = 0; indexB < 3; indexB++){
			if (boardState[0][indexB] == boardState[1][indexB] && boardState[0][indexB] == boardState[2][indexB]){
				if (boardState[0][indexB] != Marking.Null) return boardState[0][indexB];
			}
		}
		// If no winning condition has been met, return the Null
		return Marking.Null;
	}
	
	private static int[] computerMove(Marking[][] boardState, java.io.PrintStream out){
		int[] array = {2,2};
		
		/*
		 * Look at every possible move position -> for every value in the 2d array:
		 * 
		 * Logic:
		 * 	If the value is zero, move there:
		 * 		if moving there results in a win:
		 * 			move there
		 * 		if moving there does not result in a win, iterate deeper
		 * 			run the Planner on the game state
		 * 
		 * Planner:
		 * 	Given a game state, for every possible move, place a human move there
		 * 		Send game state back to Logic
		 * 		
		 * 				
		 * 			
		 */
		
		
		
		return array;
	}

}
