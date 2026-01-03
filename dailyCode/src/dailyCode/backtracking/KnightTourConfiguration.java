package dailyCode.backtracking;

public class KnightTourConfiguration {

	public static void main(String[] args) {
		int[][] valid = { 
				{ 0, 11, 16, 5, 20 }, 
				{ 17, 4, 19, 10, 15 }, 
				{ 12, 1, 8, 21, 6 }, 
				{ 3, 18, 23, 14, 9 },
				{ 24, 13, 2, 7, 22 } };

		int[][] invalid = { { 0, 3, 6 }, { 5, 8, 1 }, { 2, 7, 4 } };
		int[][] invalid2 = { { 8, 3, 6 }, { 5, 0, 1 }, { 2, 7, 4 } };

		System.out.println(checkTour(valid, 0, 0, 0));
		System.out.println(checkTour(invalid, 0, 0, 0));
		System.out.println(checkTour(invalid2, 0, 0, 0));
	}

	private static boolean checkTour(int[][] board, int row, int col, int moves) {
		if(board[0][0]!=0) {
			//starting move is invalid
			return false;
		}
		if (moves == board.length * board.length - 1) {
			//completed all the moves. Moves are starting from 0
			return true;
		}
		int[] check = checkNextMove(board, row, col, moves);
		if (check[0] == -1) {
			return false;
		}
		return checkTour(board, check[0], check[1], moves + 1);
	}

	private static int[] checkNextMove(int[][] board, int row, int col, int moves) {
		
		//if knight can move 2 down
		if (row + 2 < board.length) {
			//if knight can move 1 right
			if (col + 1 < board.length) {
				if (board[row + 2][col + 1] == moves + 1) {
					return new int[] { row + 2, col + 1 };
				}
			}
			
			//if knight can move 1 left
			if (col - 1 >= 0) {
				if (board[row + 2][col - 1] == moves + 1) {
					return new int[] { row + 2, col - 1 };
				}
			}
		}
		
		// if knight can move 2 up
		if (row - 2 >= 0) {
			if (col + 1 < board.length) {
				if (board[row - 2][col + 1] == moves + 1) {
					return new int[] { row - 2, col + 1 };
				}
			}
			if (col - 1 >= 0) {
				if (board[row - 2][col - 1] == moves + 1) {
					return new int[] { row - 2, col - 1 };
				}
			}
		}

		//if knight can move 2 right
		if (col + 2 < board.length) {
			if (row + 1 < board.length) {
				if (board[row + 1][col + 2] == moves + 1) {
					return new int[] { row + 1, col + 2 };
				}
			}
			if (row - 1 >= 0) {
				if (board[row - 1][col + 2] == moves + 1) {
					return new int[] { row - 1, col + 2 };
				}
			}
		}
		
		//if knight can move 2 left
		if (col - 2 >= 0) {
			if (row + 1 < board.length) {
				if (board[row + 1][col - 2] == moves + 1) {
					return new int[] { row + 1, col - 2 };
				}
			}
			if (row - 1 >= 0) {
				if (board[row - 1][col - 2] == moves + 1) {
					return new int[] { row - 1, col - 2 };
				}
			}
		}

		return new int[] { -1, -1, };
	}

}
