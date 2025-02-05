package BinarySearch.LevleOne;


import java.util.Arrays;

public class Question2 {

    public static void main(String[] args) {

      int arr[]=  {1,2};
      int arr1[] = {3, 4};
        //System.out.println(findDuplicate(arr1));
        System.out.println(findMedianSortedArrays(arr, arr1));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        int n = nums1.length;
        int m = nums2.length;
        int merged [] = new int[n +m];
        int k=0;
        for (int i=0; i<n; i++){
            merged[k++] = nums1[i];
        }
        for(int i=0; i<m; i++){
            merged[k++] = nums2[i];
        }
        Arrays.sort(merged);
        int total = merged.length;
        if (total %2 == 1){
            return (double) merged[total / 2];
        } else  {
            int middle1 = merged[total /2 -1];
            int middle2 = merged[total /2 ];
            return ((double) middle1 + (double) middle2 ) / 2.0;
        }
    }
    // find duplicate  numbers
    static int findDuplicate(int num[])
    {
        int i =0;
        while (i < num.length) {
            if (num[i] != i+1){
                int correct = num[i] -1;
                if (num[i] != num[correct]){
                    swap(num, i, correct);
                } else {
                    return num[i];
                }
            } else {
                i++;
            }
        }
        return -1;
    }

    static void swap(int arr[], int start, int end)
    {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    // search in two 2d matrix
    static  boolean searchMatrix(int matrix[][], int target)
    {
        int row = matrix.length;
        int col = matrix[0].length;
        int st=0, end =row * col -1;
        while (st <= end) {
            int mid = st +(end - st)/2;
            int midCR= matrix[mid/col][mid %col];
            if (midCR == target){
                return true;
            }
            if (target < midCR) {
                end = mid -1;
            } else {
                st = mid +1;
            }
        }
        return false;
    }




    // find the peak element
    static int findPeak(int num[])
    {
        int start =0;
        int end = num.length-1;
        while (start < end) {
            int mid = start + ( end -start ) /2;
            if (num[mid] < num[mid+1]){
                start = mid +1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}

