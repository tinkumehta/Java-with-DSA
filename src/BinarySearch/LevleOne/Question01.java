package BinarySearch.LevleOne;

import java.util.Arrays;

public class Question01 {

    public static void main(String[] args) {

    }

    public static boolean search(int[] nums, int target)
    {
       int start =0, end = nums.length;
       while (start <= end) {
           int mid = start + (end - start)/2;
           if (nums[mid] == target){
               return  true;
           }
           if (nums[mid] > target) {
               end  = mid -1;
           } else if (nums[mid] < target) {
               start = mid +1;
           }
       }
        return false;
    }
    public static int singleNonDuplicate(int[] nums)
    {
        int low =0, high = nums.length-1;
        while (low < high) {
            int mid = low + (high - low) /2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] == nums[mid+1]){
                low = mid +2;
            }else {
                high = mid;
            }
        }
        return nums[low];
    }
    static int binarySearch(int num[], int target)
    {
        int start =0;
        int end = num.length;
        while (start <= end) {
            int mid = start + (end - start) /2;
            if (num[mid] > target) {
                end = mid -1;
            } else if (num[mid] < target) {
                start = mid +1;
            } else {
                return mid;
            }
        }
        return 0;
    }
    public static int countNegatives(int[][] grid)
    {
        int row = grid.length;
        int col = grid[0].length-1;
        int count =0, row1=0;
       while (row >= row1 && col >=0){
           if (grid[row1][col] >=0){
               row1++;

           } else {
               count +=row - row1;
               col--;
           }
       }
        return count;
    }
    static int kthMissingNumber(int arr[], int k)
    {
        for (int num : arr){
            if (num <=k){
                k++;
            }else break;
        }
        return k;
    }
    public static int [] sumTwoNumber(int num [], int target)
    {
        int output[] = new int[2];
        int start =0;
        int end = num.length-1;
       while (start < end){
           int add = num[start] + num[end];
           if (add == target){
               output[0] = start+1;
               output[1] = end +1;
               return output;
           } else if (add < target){
               start++;
           } else {

               end--;
           }
       }
       return output;
    }
}
