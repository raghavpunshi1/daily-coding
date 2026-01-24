package dailyCode.arrays.twoPointer;

//Given an integer array nums sorted in non-decreasing order, 
//remove the duplicates in-place such that each unique element appears only once. 
//The relative order of the elements should be kept the same.
//Consider the number of unique elements in nums to be k​​​​​​​​​​​​​​. 
//After removing duplicates, return the number of unique elements k.
//The first k elements of nums should contain the unique numbers in sorted order.
//The remaining elements beyond index k - 1 can be ignored.

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1,1,1,2,2,3,4,4,5,5};
		int ind = removeDuplicates(arr);
		for(int i=0;i<ind;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public static int removeDuplicates(int[] arr) {
		int slow=1;
		int fast=1;
		
		while(fast<arr.length) {
			if(arr[fast]!=arr[fast-1]) {
				arr[slow]=arr[fast];
				slow++;
				fast++;
			}else {
				fast++;
			}
		}
		return slow;
	}

}
