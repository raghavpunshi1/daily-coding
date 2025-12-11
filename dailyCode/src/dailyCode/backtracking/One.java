package dailyCode.backtracking;

public class One {

	public static void main(String[] args) {
//		Given a matrix 3x3
//		we will pass the length of rows and columns
		System.out.println(count(3, 3));
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

}
