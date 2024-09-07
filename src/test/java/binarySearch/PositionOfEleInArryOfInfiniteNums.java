package binarySearch;

import java.util.Arrays;

public class PositionOfEleInArryOfInfiniteNums {

    /**
     * Amazon Interview problem - GeeksforGeeks
     * https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
     * Find position of an element in a sorted array of infinite numbers
     */
    public static void main(String[] args) {

        int[] a = {10,20,20,20,20,30,40,60,70,80,90,100,200,300,400,500};
        int target = 40;
        System.out.println(ans(a, target));
    }

    /**
      Since we dont know the length of the array as it is infinite we cannot use e = a.length-1;
     so the approach we will follow is search the array in chunks and in incremental order that is
     in normal approach we divide the array in half and it is continued till we get m=target
     so it follows - N, N/2, N/4,.. till the size of array reaches 1, this is possible when we know the
     size of the array

     Here in this approach we will go in reverse order that is double - N, 2N, 4N, till we get the
     position of the target in infinite array, so we will go in chunks - 1st 2 positions we will chek if not found
     the double the size of the of array to find and so on

     Another condition is we will not look behind in already searched array so we wil keep going forward
     for this we can safely consider a condition that while target > a[e] we proceed further to double
     the size of array with new start position - e+1 and new end position - double the array -
     e = e + (e-(s-1))*2 here we are adding e bcoz we need index position which will be smaller by 1 that actual size
     so we add e to get new size of array which will count the index as well for instance if array index size is 4
     than it must have 5 numbers/elements

     finaly when we get a[e] which is greater that target than we can conclude that the target is b/w this
     new start and end and we will come out of while loop and pass these 2 new values to Binary search logic

     with this the time complexity will remain same as that of binary search - log(N)
     */
    public static int ans(int[] a, int target){

        int s = 0;
        int e = 1;
        // if target > a[e] that means its definitly not bw the array chunk - {s --- e} so we wil
        // check in next chunk of array.
        // Note the array is sorted hence its in ascending order so definitly if target > a[e] then it
        // will not be present before a[e]
        while(target > a[e]){
            // storing new start value in temp bcoz in next step e value wil change and we need old e value for new s
            int temp = e+1;
            // here we are using = e + (e - (s-1))*2
            // that is e + 2 times the size of previous chunk of array
            // last array size was 2
            // so e = 1 + 2*2 = 5
            // so new array will be {20,20,20,30,40}
            e = e + (e - s + 1) * 2;
            // assigning new s value
            s = temp;
        }
        // once target < a[e] we can say target is b/w the array chunk - s and e and we will use binary search on this chunk
        return searchPosition(a, target, s, e);
    }



    public static int searchPosition(int[] a, int target, int s, int e) {

        while(s<=e){
            int m = s+(e-s)/2;

            if(target < a[m]){
                e = m-1;
            } else if(target > a[m]){
                s=s+1;
            } else {
                return m;
            }
        }
        return -1;
    }

}
