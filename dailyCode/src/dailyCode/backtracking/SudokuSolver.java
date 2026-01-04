package dailyCode.backtracking;

public class SudokuSolver {

	public static void main(String[] args) {
		String[][] board = {
				{"5","3",".",".","7",".",".",".","."},
				{"6",".",".","1","9","5",".",".","."},
				{".","9","8",".",".",".",".","6","."},
				{"8",".",".",".","6",".",".",".","3"},
				{"4",".",".","8",".","3",".",".","1"},
				{"7",".",".",".","2",".",".",".","6"},
				{".","6",".",".",".",".","2","8","."},
				{".",".",".","4","1","9",".",".","5"},
				{".",".",".",".","8",".",".","7","9"}
				};
		
		solve(board);
		display(board);
		}


	private static boolean solve(String[][] board) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j].equals(".")) {
					for (char k = '1' ; k <= '9'; k++) {
						if (isSafe(board, i, j, (char) k)) {
							board[i][j] = (char) k +"";
							
							if(solve(board)==true) {
								return true;
							}else {
								board[i][j] = ".";
							}
							
						}
							
					}
					return false;
				}
			}
		}
		
		return true;

	}

	private static boolean isSafe(String[][] board, int row, int col, char ch) {
		// check row
		for (int i = 0; i < board.length; i++) {
			if (board[row][i].equals(String.valueOf(ch))) {
				return false;
			}
		}

		// check col
		for (int i = 0; i < board.length; i++) {
			if (board[i][col].equals(String.valueOf(ch))) {
				return false;
			}
		}

		// check sub box
		int rowStart = (int) (row - (row % Math.sqrt(board.length)));
		int colStart = (int) (col - (col % Math.sqrt(board.length)));
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[rowStart + i][colStart + j].equals(String.valueOf(ch))) {
					return false;
				}
			}
		}

		return true;

	}
	
	private static void display(String[][] board) {
		for(String[] row : board) {
			for( String val : row) {
				System.out.print(val+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
