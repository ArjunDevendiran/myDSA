package binarySearch;

import java.util.Scanner;

public class Floor {
	
	/**
	  Find the floor of the target number
	  This code does following:
	  - Finds the target number if present in the array
	  - Finds the largest number which is smaller or equal to the target 
	  	number in the array 
	 */
	public static void main(String[] args) {
		
		System.out.println("hello world");
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
	
		
		int[] a = {10,20,30,40,60};
		
		System.out.println(getCeilingOfTarget(a,t));
		sc.close();
		
	}

	public static int getCeilingOfTarget(int[] a, int t) {
		
		// to avoid ArrayIndexOutOfBoundsException in case the target is greater than last number in the array
		if(t > a[a.length -1]) {
			return -1;
		}
		
		int start = 0;
		int end = a.length - 1;
		
		while(start <= end) {
			
			int mid = start + (end-start)/2;
			
			if(a[mid] > t) {
				end = mid - 1;
			
			} else if(a[mid] < t) {
				start = mid + 1;
			
			} else if(a[mid] == t){
				return a[mid];
			}
		}
		// end will be the largest number which is smaller or equal to the target
		return a[end];
	}

}
