package dailyCode.arrays.slidingWindow;

public class MaxAverageSubarray {

	public static void main(String[] args) {
		int[] arr = { 1,12,-5,-6,50,3 };
		System.out.println(solve(arr, 4));
	}

	private static double solve(int[] arr, int k) {
		int left = 0;
		int right = 0;
		double sum = 0;
		double avg = Double.NEGATIVE_INFINITY;
		while (right < arr.length) {
			sum += arr[right];

			if (right - left + 1 == k) {
				if(sum/k>avg) {
					avg=sum/k;
				}
				sum=sum-arr[left];
				left++;
			}
			right++;
		}
		
		return avg;
	}
}
