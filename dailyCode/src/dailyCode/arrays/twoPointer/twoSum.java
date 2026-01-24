package dailyCode.arrays.twoPointer;

import java.util.Arrays;
//Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, 
//find two numbers such that they add up to a specific target number. 
//Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
//Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
//The tests are generated such that there is exactly one solution. You may not use the same element twice.
//Your solution must use only constant extra space.
public class twoSum {

	public static void main(String[] args) {
		int[] sortedArr = {1,6,8,11,13};
		int target = 21;
		
		System.out.println(Arrays.toString(bruteForce(sortedArr, target)));
		System.out.println(Arrays.toString(twoPointer(sortedArr, target)));

	}
	
	public static int[] bruteForce(int[] arr, int target) {
		for(int i=0;i<arr.length; i++) {
			for(int j=0;j<arr.length; j++) {
				if(arr[i]+arr[j]==target) {
					return new int[] {i,j};
				}
			}
		}
		return null;
	}
	
	public static int[] twoPointer(int[] arr, int target) {
		int l=0;
		int r=arr.length-1;
		while(l<r) {
			if(arr[l]+arr[r]==target) {
				return new int[] {l,r};
			}
			if(arr[l]+arr[r]<target) {
				l++;
			}else {
				r--;
			}
		}
		return null;
	}
}
