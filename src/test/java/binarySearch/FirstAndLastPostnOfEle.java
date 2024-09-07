package binarySearch;

import java.util.Arrays;

public class FirstAndLastPostnOfEle {

    /**
     * Leetcode problem - https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
     * 34. Find First and Last Position of Element in Sorted Array

     */
    public static void main(String[] args) {

        int[] a = {10,20,20,20,20,30,40,60};
        int target = 20;

        // Brute force approach ---------------------------------------------->>>
        // THIS APPROACH TAKES O(N) time and space complexity
       // System.out.println(Arrays.toString(elementBruteForce(a,target)));

        //Binary search approach
        // its time and space complexity is log(N)
        int[] ans = {-1,-1};
        ans[0] = searchPosition(a, target, true);
        ans[1] = searchPosition(a, target, false);
        System.out.println(Arrays.toString(ans));
    }


    // Brute force approach ---------------------------------------------->>>
    // THIS APPROACH TAKES O(N) time and space complexity
    // here we are traversing from start to end to get the first position of target
    // and we are traversing from end to start to get the last position of target
    public static int[] elementBruteForce(int[] a, int target) {
        int[] t = new int[2];

        // if the target is not present in array then return - [-1,-1]
        if(a.length == 0){
            for(int i = 0; i<t.length; i++) {
                t[i] = -1;
            }

        }

        // here we are traversing from start to end to get the first position of target
        for(int i = 0; i<a.length; i++) {
            if(a[i] == target) {
                t[0] = i;
                break;
            } else{
                t[0] = -1;
            }

        }
        // and we are traversing from end to start to get the last position of target
        for(int j = a.length-1; j>=0; j--) {
            if(a[j] == target) {
                t[1] = j;
                break;
            } else{
                t[1] = -1;
            }
        }
        return t;
    }


    // Binary Search approach ---------------------------------------------->>>
    // Here we are going to run Binary search logic 2 times to get 2 positions
    // in all cases if the target is present in the array it will ultimately be equal to mid position as per
    // binary search logic so we will consider the mid position as the target position and from there:
    // we will add a condition with boolean check to find first or last position
    // if we need to find first position then we need to traverse to left of mid so we wil use e = m-1
    // if we need to find last position then we need to traverse to right of mid so we wil use s = m+1
    // we will do this till while condition(s<=e) is voilated.
    // once the while condition breaks then we will return the previously saved mid value as the anse
    public static int searchPosition(int[] a, int target, boolean searchFirstPosition) {
        int s = 0;
        int e = a.length-1;
        int ans = -1;

        while(s<=e){
            int m = s+(e-s)/2;

            if(target < a[m]){
                e = m-1;
            } else if(target > a[m]){
                s=s+1;
            } else {
                ans = m;
                    if(searchFirstPosition){
                        e=m-1;
                    } else {
                        s=m+1;
                    }
            }
        }
        return ans;
    }

}
