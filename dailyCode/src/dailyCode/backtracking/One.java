package dailyCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class One {

	public static void main(String[] args) {
//		Given a matrix 3x3
//		we will pass the length of rows and columns
		System.out.println(count(3, 3));

		System.out.println(getListOfPaths("", 3, 3));

		System.out.println(getListOfPathsDagonals("", 3, 3));

		boolean[][] maze = { { true, true, true }, { true, false, true }, { true, true, true }, };

		getPathsWithObstracles("", maze, 0, 0);
	}

//	You are given a N x N matrix. you are at (0,0) and you need to reach ((N-1),(N-1))
//	given 3x3 matrix and you need to each (2,2) i.e. end of the matrix
//	you can only move one step at a time
//	you can only go down or right
//	find the number of possible paths

	public static int count(int noRows, int noCols) {
		if (noRows == 1 || noCols == 1) {
			return 1;
		}

		int goDown = count(noRows - 1, noCols);
		int goRight = count(noRows, noCols - 1);

		return goDown + goRight;
	}

//	 prcessed unprocessed string method
//	return a List of answwers
	public static List<String> getListOfPaths(String ans, int noRows, int noCols) {
		if (noRows == 1 && noCols == 1) {
			List<String> tempList = new ArrayList<String>();
			tempList.add(ans);
			return tempList;
		}

		List<String> list = new ArrayList<String>();

		if (noRows > 1) {
			list.addAll(getListOfPaths(ans + "D", noRows - 1, noCols));
		}
		if (noCols > 1) {
			list.addAll(getListOfPaths(ans + "R", noRows, noCols - 1));
		}

		return list;

	}

//	include diagonals as well
	public static List<String> getListOfPathsDagonals(String ans, int noRows, int noCols) {
		if (noRows == 1 && noCols == 1) {
			List<String> tempList = new ArrayList<String>();
			tempList.add(ans);
			return tempList;
		}

		List<String> list = new ArrayList<String>();

		if (noRows > 1 && noCols > 1) {
			list.addAll(getListOfPathsDagonals(ans + "d", noRows - 1, noCols - 1));
		}

		if (noRows > 1) {
			list.addAll(getListOfPaths(ans + "D", noRows - 1, noCols));
		}
		if (noCols > 1) {
			list.addAll(getListOfPaths(ans + "R", noRows, noCols - 1));
		}

		return list;

	}

	// given the same matrix but with obstracle. false is the obstracle. you cannot
	// step into false block
	public static void getPathsWithObstracles(String ans, boolean[][] maze, int rows, int cols) {
		if (rows == maze.length - 1 && cols == maze[0].length - 1) {
			System.out.println(ans);
			return;
		}

		if (!maze[rows][cols]) {
			return;
		}

		if (rows < maze.length - 1) {
			getPathsWithObstracles(ans + "D", maze, rows + 1, cols);
		}
		if (cols < maze.length - 1) {
			getPathsWithObstracles(ans + "R", maze, rows, cols + 1);
		}
	}

}
