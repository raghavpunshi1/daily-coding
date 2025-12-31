package dailyCode.backtracking;

public class Two {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean[][] maze = { { true, true, true }, { true, true, true }, { true, true, true }, };
		getPaths("", maze, 0, 0);

	}

	public static void getPaths(String ans, boolean[][] maze, int r, int c) {
		if (r == maze.length - 1 && c == maze[0].length - 1) {
			System.out.println(ans);
			return;
		}

		if (!maze[r][c]) {
			return;
		}

		maze[r][c] = false;

		if (r < maze.length - 1) {
			getPaths(ans + "D", maze, r + 1, c);
		}
		if (c < maze[0].length - 1) {
			getPaths(ans + "R", maze, r, c + 1);
		}
		if (r > 0) {
			getPaths(ans + "L", maze, r - 1, c);
		}
		if (c > 0) {
			getPaths(ans + "U", maze, r, c - 1);
		}

		maze[r][c] = true;
	}

}
