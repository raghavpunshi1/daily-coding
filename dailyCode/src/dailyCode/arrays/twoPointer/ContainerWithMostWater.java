package dailyCode.arrays.twoPointer;

//You are given an integer array height of length n. 
//There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
//Find two lines that together with the x-axis form a container, 
//such that the container contains the most water.
//Return the maximum amount of water a container can store.

public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,8,6,2,5,4,8,3,7};
		
		System.out.println(bruteForce(arr));
		System.out.println(twoPointer(arr));

	}
	
	public static int bruteForce(int[] arr) {
		int max=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				if(i!=j) {
					int area = Math.min(arr[i],arr[j]) * Math.abs(i-j);
					if(area >max) {
						max=area;
					}
				}
			}
		}
		return max;
	}
	
	public static int twoPointer(int[] arr) {
		int s=0;
		int e=arr.length-1;
		int max=0;
		while(s<e) {
			int area = Math.min(arr[s],arr[e]) * Math.abs(e-s);
			if(area>max) {
				max=area;
			}
			if(arr[s]<arr[e]) {
				s++;
			}else {
				e--;
			}
		}
		return max;
	}

}
