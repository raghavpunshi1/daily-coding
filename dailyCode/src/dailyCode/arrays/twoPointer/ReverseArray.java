package dailyCode.arrays.twoPointer;

import java.util.Arrays;

public class ReverseArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,6,7};
		reverse(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
	public static void reverse(int[] arr) {
		int s=0;
		int e=arr.length-1;
		while(s<e) {
			int temp = arr[s];
			arr[s] = arr[e];
			arr[e] = temp;
			s++;
			e--;
		}
	}

}
