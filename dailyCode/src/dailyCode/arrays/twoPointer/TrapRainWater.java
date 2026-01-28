package dailyCode.arrays.twoPointer;

public class TrapRainWater {

	public static void main(String[] args) {
		int[] arr= {0,1,0,2,1,0,1,3,2,1,2,1}; //ans=6
		System.out.println(trap(arr));
	}
	
	public static int trap(int[] arr) {
		int left=0;
		int right=arr.length-1;
		int leftMax=0;
		int rightMax=0;
		int water=0;
		
		while(left<right) {
			if(arr[left]<arr[right]) {
				//left is the limiting factor
				if(arr[left]>leftMax) {
					leftMax=arr[left];
				}else {
					water += leftMax -arr[left];
				}
				left++;
			}
			else {
				//right is the limiting factor
				if(arr[right]>rightMax) {
					rightMax=arr[right];
				}else {
					water+= rightMax - arr[right];
				}
				right--;
			}
		}
		return water;
	}
}
