package BinarySearch.LevleOne;


import java.util.Arrays;

public class Question2 {

    public static void main(String[] args) {

    }

    public static int maximizeSweetness(int[] nums, int m)
    {
        m++;
        long l= Integer.MAX_VALUE, r =0;
        for (int n : nums){
            r += n;
            l = Math.min(l, r);
        }
        while (l < r) {
            long mid = l + (r - l) /2;
            if (canSplit(nums, m, mid)){
                l = mid;
            } else {
                r = mid -1;
            }
        }
        if (canSplit(nums, m, r)) return (int) r;
        else  return (int) l;
    }
    public static boolean canSplit(int nums[], int m, long target)
    {
        int cnt =0, sum =0;
        for (int n : nums){
            if (sum + n >= target){
                sum =0;
                cnt++;
            } else {
                sum +=n;

            }
        }
        return cnt >=m;
    }
    public static int splitArray(int[] nums, int m)
    {
        int start =0;
        int end =0;
        for (int i=0; i<nums.length; i++){
            start = Math.max(start, nums[i]);
            end += nums[i];
        }
        while (start < end) {
            int mid = start + (end - start) /2;
            int pice =1;
            int sum =0;
            for (int num : nums){
                if (sum + num > mid) {
                    sum = num;
                    pice++;
                } else {
                    sum += num;
                }
            }
            if (pice > m) {
                start = mid +1;
            } else {
                end = mid;
            }
        }
        return end;
    }
    static int findPage(int arr[], int k)
    {
        if (arr.length <= k) return -1;
        int lo = Arrays.stream(arr).max().getAsInt();
        int hi = Arrays.stream(arr).sum();
        int res = 0;

        while (lo <= hi) {
            int mid = lo + (hi - lo) /2;
            if (check(arr, k, mid)){
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return res;
    }
    static boolean check(int arr[], int k, int pageLimit)
    {
        int cnt =1;
        int pageSum =0;
        for (int i=0; i<arr.length; i++){
            if (pageSum + arr[i] > pageLimit){
                cnt++;
                pageSum = arr[i];
            } else {
                pageSum += arr[i];
            }
        }
        return (cnt <=k);
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

