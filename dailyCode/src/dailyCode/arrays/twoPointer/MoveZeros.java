package dailyCode.arrays.twoPointer;

import java.util.Arrays;

public class MoveZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {0 ,1,0,2,0,3,0};
		moveZero(arr);
		System.out.println(Arrays.toString(arr));

	}
	
	public static void moveZeroWithoutOrder(int[] arr) {
		int s=0;
		int e=arr.length-1;
		
		while(s<e) {
			while(s<e && arr[s]!=0) {
				s++;
			}
			while(s<e && arr[e]==0) {
				e--;
			}
			
			int temp = arr[s];
			arr[s] = arr[e];
			arr[e] = temp;
		}
	}
	
	public static void moveZero(int[] arr) {
		int slow=0;
		int fast=0;
		
		while(fast<arr.length) {
			if(arr[fast]!=0) {
				arr[slow]=arr[fast];
				slow++;
				fast++;
			}else {
				fast++;
			}
		}
		
		for(int i=slow;i<arr.length;i++) {
			arr[i]=0;
		}
	}

}
