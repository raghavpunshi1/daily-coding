package dailyCode.arrays.slidingWindow;

public class MinSizeSubarraySum {

	public static void main(String[] args) {
		int[] arr = {2,3,1,2,4,3};
		System.out.println(solve(arr,7));
	}
	private static int solve(int[] arr, int target) {
		int left=0;
		int sum=0;
		int minLen=Integer.MAX_VALUE;
		
		for(int right=0;right<arr.length;right++) {
			sum+= arr[right];
			
			while(sum>=target) {
				minLen = Math.min(minLen, right-left+1);
				sum-=arr[left];
				left++;
			}
		}
		return minLen!=Integer.MAX_VALUE? minLen: 0;
	}
}
