package dailyCode.arrays.slidingWindow;

import java.util.Arrays;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		int[] arr = {1,-1};
		System.out.println(Arrays.toString(solve(arr,1)));
	}
	
	private static int[] solve(int[] arr, int k) {
		int slow=0;
		int fast=0;
		int ind=0;
		int[] ans = new int[arr.length-k+1];
		int max=Integer.MIN_VALUE;
		while(fast<arr.length) {
			if(arr[fast]>max) {
				max=arr[fast];
			}
			if(fast-slow+1>k) {
				slow++;
				for(int i=slow;i<=fast;i++) {
					if(arr[i]>max) {
						max=arr[i];
					}
				}
			}
			if(fast-slow+1==k) {
				ans[ind]=max;
				ind++;
			}
			fast++;
		}
		return ans;
	}

}
