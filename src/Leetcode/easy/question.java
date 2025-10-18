package Leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class question {
    public static void main(String[] args) {
        int nums []= {1,2,3};
        System.out.println(containDuplate(nums));
    }
    // leetcode 454
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4)
    {
        Map<Integer, Integer> map = new HashMap<>();
        int count =0;
        for (int num1 : nums1){
            for (int num2 : nums2){
                int sum = num1 + num2;
                map.put(sum, map.getOrDefault(sum, 0) +1);
            }
        }
        for (int num3 : nums3){
            for (int num4 : nums4){
                int sum = num3 + num4;
                int targetSum = -sum;
                if (map.containsKey(targetSum)){
                  count += map.get(targetSum);
                }
            }
        }
        return count;
    }
    // leetcode 217
    static boolean containDuplate(int nums[])
    {
        if (nums == null || nums.length == 0) return true;
        Arrays.sort(nums);
        for (int i=1; i< nums.length-1; i++){
            if (nums[i] == nums[i-1]){
                return true;
            }
        }
        return false;
    }
}
