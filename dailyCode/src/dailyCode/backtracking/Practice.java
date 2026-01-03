package dailyCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Practice {

	public static void main(String[] args) {
		System.out.println(solveNQueens(4));
	}

	public static List<List<String>> solveNQueens(int n) {
		boolean[][] board = new boolean[n][n];
		List<List<String>> ans =new ArrayList<>();
		
		solve(board, 0, ans);
		return ans;

	}

	private static void solve(boolean[][] board, int row, List<List<String>> ans) {
		int n = board.length;

		if (row == n) {
			ans.add(makeList(board));
			return;
		}
		// row wise traversal
		for (int col = 0; col < n; col++) {
			if (isSafe(board, row, col)) {
				board[row][col] = true;
				solve(board, row+1, ans);
				board[row][col] = false;
			}
		}
	}

	private static boolean isSafe(boolean[][] board, int row, int col) {
		// check vertical up
		for (int i = row - 1; i >= 0; i--) {
			if (board[i][col]) {
				return false;
			}
		}

		// check left diagonal
		int maxLeft = Math.min(row, col);
		for (int i = 1; i <= maxLeft; i++) {
			if (board[row - i][col - i]) {
				return false;
			}
		}

		// check right diagonal
		int maxRight = Math.min(row, board.length - 1 - col);
		for (int i = 1; i <= maxRight; i++) {
			if (board[row - i][col + i]) {
				return false;
			}
		}

		return true;
	}

	private static List<String> makeList(boolean[][] board) {
		List<String> l = new ArrayList<String>();
		for (boolean[] row : board) {
			String a = "";
			for (boolean val : row) {
				if (val)
					a+="Q";
				else
					a+=".";
			}
			l.add(a);
		}
		return l;
	}

}
