package Leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

public class solution {
    public static void main(String[] args) {
      int []   nums = {0,1,2,2,3,0,4,};

        System.out.println(removeDuplicates(nums, 2));
    }
    // leetcode 26, 27 same as change only value
    public static int removeDuplicates(int[] nums, int val)
    {
        if (nums.length ==0) return 0;
        int k=1;
        for (int i=1; i<nums.length; i++){
            if (nums[i] != val){
                nums[k]= nums[i];
                k++;
            }
        }
        return k;
    }
    // leetcode 1
    public static int[] twoSum(int[] nums, int target)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            int current = nums[i];
            int completed = target - current;
            if (map.containsKey(completed)){
                return new int[] {map.get(completed), i};
            }
            map.put(current, i);
        }
        return new int[0];
    }
    // leetcode 9
    public static boolean isPalindrome(int x)
    {
        if (x < 0 || (x %10 ==0 && x !=0)) {
            return false;
        }
        int num =0;
        while (x > num) {
            num = num * 10 + x %10;
            x /= 10;
        }
        return x == num || x == num /10;
    }
    // leetcode 13
    public static int romanToInt(String s)
    {
        int ans =0, num=0, prev =0;
        for (int i=s.length()-1; i>=0; i--){
            switch (s.charAt(i)){
                case 'M' -> num = 1000;
                case 'D' -> num = 500;
                case 'C' -> num = 100;
                case 'L' -> num = 50;
                case 'X' -> num = 10;
                case 'V' -> num = 5;
                case 'I' -> num = 1;
            }
            if (num < prev) {
                ans -= num;
            }else {
                ans += num;
            }
            prev = num;
        }
        return ans;
    }
    // leetcode 7
    public static int reverse(int x)
    {
        long rev = 0;
        while (x !=0) {
            int digit = x %10;
            rev = rev * 10 + digit;
            x /=10;
            if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) rev;
    }
    // leetcode 14
    public static String longestPalindrome(String strs[])
    {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String first = strs[0];
        for (int i=0; i<first.length(); i++){
            char currentChar = first.charAt(i);
            for (int j=1; j<strs.length; j++){
                if (i == strs[j].length() || currentChar != strs[j].charAt(i)){
                    return first.substring(0, i);
                }
            }
        }
        return first;
    }
}
