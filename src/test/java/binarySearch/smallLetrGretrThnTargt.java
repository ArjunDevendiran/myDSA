package binarySearch;

public class smallLetrGretrThnTargt {
	
	/**
	 * Leetcode problem - https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
	 * 744. Find Smallest Letter Greater Than Target

	  This is same as ceiling of number problem, only difference is we dont need to find a number/char equal to the target
	  and the array wraps arround that means if the target is greater than the last element in the array then we need to return the
	  0th index element
	 */
	public static void main(String[] args) {
		
		char[] letters = {'c','f','j'};
		char target = 'j';
		System.out.println(nextGreatestLetter(letters,target));		
	}
	
	public static char nextGreatestLetter(char[] letters, char target) {
        
				int start = 0;
				int end = letters.length - 1;
				
				while(start <= end) {
					
					int mid = start + (end-start)/2;
					
					if(letters[mid] > target) {
						end = mid - 1;
						// This condition letters[mid] > target is taken becoz this will help us tol wrap around that is
						// once code reached last index in array and the target is met then this will return 0th index  
					
					} else {
						start = mid + 1;
					// we have not defined letters[mid] < target as it will keep looping infinitly
					}
				}
				return letters[start % (letters.length)];
				// start mod letters.length will give the reminder
				// we take reminder becoz ans should be a char which is smaller than the target and if the target itself 
				// is greater than the last element in array then it should print char at 0th index so the modulus will return
				// 0 reminder which will be the 0th index
				
				// Like ceiling we wont print -1 instaed we print 0th index value
				// and we dont use a[mid] == target bcoz here question wants only the smallest number
    }

}
