package Leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class solution {
    public static void main(String[] args) {
      int nums[] = {0,1,0,1,0,1,99};
      //  System.out.println(findPeakElement(nums));
        System.out.println(singleNumber(nums));
    }
    // leetcode 118
    public List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> trangle = new ArrayList<>();
        if (numRows == 0) {
            return trangle;
        }
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        trangle.add(firstRow);

        for (int i=1; i<numRows; i++){
            List<Integer> prev = trangle.get(i-1);
            List<Integer> current = new ArrayList<>();
            current.add(1);
            for (int j=1; j<i; j++){
                current.add(prev.get(j-1)+ prev.get(j));
            }
            current.add(1);
            trangle.add(current);
        }
        return trangle;
    }
    // leetcode 137
    public static int singleNumber(int[] nums)
    {
        int count =0;
        for (int i=0; i<32; i++){
            int bit =0;
            for (int num : nums){
                if (((num >> i) & 1) ==1){
                    bit++;
                }
            }
            if (bit %3 ==1){
                count = count | (1 <<i);
            }
        }
        return count;
    }
    // leetcode 162
    public static int findPeakElement(int[] nums)
    {
        if (nums == null || nums.length ==0) return 0;
        int start =0, end = nums.length-1;
        while (start < end) {
            int mid = start + (end -start)/2;
            if (nums[mid] > nums[mid+1]){
                end = mid;
            } else {
                start = mid+1;
            }

        }
        return start;
    }
    // leetcode 75
    public static void sortColor(int nums[])
    {
        int low=0, current =0, high = nums.length-1;
        while (current <= high) {
            if (nums[current] == 0) {
                swap(nums, current, low);
                low++;
                current++;
            } else if (nums[current] == 2) {
                swap(nums, low, high);
                high--;
            } else {
                current++;
            }
        }
    }
    public static void swap(int nums[], int start, int end)
    {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    // leetcode 88
    public void merge(int[] nums1, int m, int[] nums2, int n)
    {
        int p1 = m-1;
        int p2 = n-1;
        int writeIndex = m+n -1;
        while (p1 >=0 && p2 >=0){
            if (nums1[p1] > nums2[p2]){
                nums1[writeIndex] = nums1[p1];
                p1--;
            } else {
                nums1[writeIndex] = nums2[p2];
                p2--;
            }
            writeIndex--;
        }
        while (p2 !=0){
            nums1[writeIndex] = nums2[p2];
            p2--;
            writeIndex--;
        }
    }
    // leetcode 33
    public static int search(int nums[], int start, int end, int target)
    {
        if (nums.length == 0 || nums == null){
            return -1;
        }
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[start] < nums[mid]){
                if (target >= nums[start] && target < nums[mid]){
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            } else {
                if (target > nums[mid] && target <= nums[end]){
                    start = mid +1;
                } else {
                    end = mid -1;
                }
            }
        }
        return -1;
    }
}
