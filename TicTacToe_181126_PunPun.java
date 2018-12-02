import java.util.*;
public class TicTacToe_181126_PunPun {
	private static String [][] board = {{"-","-","-"},{"-","-","-"},{"-","-","-"}};
	private static int count = 0;
	private static int row;
	private static int column;
	private static Boolean game = true;
	public static void main (String [] args) {
		System.out.println("Welcome to TicTacToe. Wait for your turn to make a move.");
		System.out.println("Enter either a  1, 2, or 3 for rows and columns");
		do {
			num();
		} while (count < 9 && line());
		System.out.println(winner());
	}
	public static void num() {
		if (count % 2 == 0) {
			System.out.print("Player 1's turn. ");
			askNum();
		} else {
			System.out.println("Player 2's turn. ");
			askNum();
		}		
	}
	public static void askNum() {
		Scanner console = new Scanner (System.in);
		System.out.print("Row: ");
		row = console.nextInt();
		System.out.print("Column: ");
		column = console.nextInt();
		row--;
		column--;
		checkMove(row, column);
		check(row,column);
	}
	public static void checkMove(int r, int c) {
		if (r > 2 || r < 0 || c > 2 || c < 0) {
			System.out.println("Invalid number");
			num();
		}
	}
	public static void check(int row, int column) {
		if (board[row][column].equals("-")) {
			move(row, column);
			count++;
		} else {
			System.out.println("Spot is taken. Please choose another spot");
			num();
		}
	}
	public static void move(int row, int column) {
		if (count % 2 == 0) {
			board[row][column] = "X";
		} else {
			board[row][column] = "O";
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	public static boolean line() {
		for (int x = 0; x < 3; x++) {
			if (board[0][x].equals(board[1][x]) && board[0][x].equals(board[2][x]) && !(board[0][x].equals("-"))) {
				game = false;
			}	else if (board[x][0].equals(board[x][1]) && board[x][0].equals(board[x][2]) && !(board[x][0].equals("-"))) {
				game = false;
			} else if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])  && !(board[0][0].equals("-"))) {
				game = false;
			} else if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])  && !(board[2][0].equals("-"))) {
				game = false;
			}
		}
		return game;
	}
	public static String winner() {
		if (game == false) {
			if (count % 2 == 0) {
				return "Player 2 won";
			} else {
				return "Player 1 won";
			}
		}
		return "It's a draw";
	}
}