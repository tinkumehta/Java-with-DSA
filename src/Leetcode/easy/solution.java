package Leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class solution {
    public static void main(String[] args) {
      int [][]   nums = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    // leetcode 125
    public static boolean isPalindrome(String s)
    {
        StringBuilder res = new StringBuilder();
        for (char ch : s.toCharArray()){
            if (Character.isLetterOrDigit(ch)){
                res.append(Character.toLowerCase(ch));
            }
        }
        int left =0, right = res.length()-1;
        while (left < right) {
            if (res.charAt(left) != res.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    // leetcode 74
    public static boolean searchMatrix(int[][] matrix, int target)
    {
        int m = matrix.length;
        int n = matrix[0].length;
        int stCol =0, stEnd = m*n-1;
        while (stCol <= stEnd) {
            int mid = stCol + (stEnd - stCol)/2;
            int midt = matrix[mid /n][mid %n];
            if (midt == target) {
                return true;
            } else if (target < midt) {
                stEnd = mid-1;
            } else {
                stCol = mid +1;
            }
        }
        return false;
    }
    // leetcode 410
    public static int splitArray(int[] nums, int k)
    {
        int start =0, end = 0;
        for (int i=0; i<nums.length; i++){
            start = Math.max(start, nums[i]);
            end += nums[i];
        }

        while (start < end) {
            int mid = start + (end -start)/2;
            int sum =0;
            int pices =1;
            for (int num : nums){
                if (sum + num > mid) {
                    sum = num;
                    pices++;
                } else {
                    sum += num;
                }
            }
            if (pices > k) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return end;
    }
    // leetcode 67
    public  static String addBinary(String a, String b)
    {
        StringBuilder res = new StringBuilder();
        int i = a.length()-1;
        int j = b.length() -1;
        int carry =0;
        while (i >=0 || j>=0 || carry ==1){
            int digit1 =0;
            if (i >= 0) {
                digit1 = a.charAt(i) - '0';
            }
            int digit2 =0;
            if (j >= 0) {
                digit2 = b.charAt(j) - '0';
            }
            int sum = digit1 +digit2 +carry;
            res.append(sum %2);
            carry = sum /2;
            i--;
            j--;
        }
        return res.reverse().toString();
    }
    // leetcode 66
    public static int[] plusOne(int[] digits)
    {
        for (int i=digits.length-1; i>=0; i--){
            if (digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }
    // leetcode 58
    public static int lengthOfLastWord(String s)
    {
        int count =0, t=0;
        for (int i=s.length()-1; i>=0; i--){
            if (s.charAt(i) == ' ' && t ==1) return count;
            if (Character.isLetter(s.charAt(i))){
                count++;
                t =1;
            }
        }
        return count;
    }
    // leetcode 852
    public static int peakIndexInMountainArray(int[] arr)
    {
        int start =0;
        int end = arr.length-1;
        while (start < end) {
            int mid = start + (end - start)/2;
            if (arr[mid] > arr[mid+1]){
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return start;
    }
    // leetcode 20
    public static boolean isValid(String s)
    {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()){
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if (ch == ')'){
                    if (st.isEmpty() || st.pop() != '(') return false;
                }
                if (ch == '}'){
                    if (st.isEmpty() || st.pop() != '{') return false;
                }
                if (ch == ']'){
                    if (st.isEmpty() || st.pop() != '[') return false;
                }
            }
        }
        return st.isEmpty();
    }
    // leetcode 34
    public static int[] searchRange(int[] nums, int target)
    {
        int ans[] = {-1, -1};
        int start = search(nums, target, true);
        int end = search(nums, target, false);
        ans[0] = start;
        ans[1] = end;
        return ans;
    }
    static int search(int nums[], int target, boolean index)
    {
        int ans = -1;
        if (nums == null || nums.length ==0){
            return ans;
        }
        int start =0, end = nums.length-1;
        while (start <= end) {
            int mid = start + (end -start)/2;
            if (target < nums[mid]){
                end = mid-1;
            } else if (target > nums[mid]) {
                start = mid+1;
            } else {
                ans = mid;
                if (index) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            }
        }
        return ans;
    }
    // leetcode 744
    public static char nextGreaterElement(char letter[], char target)
    {
        int st =0, end = letter.length-1;
        while (st <= end) {
            int mid = st + (end -st)/2;
            if (target < letter[mid]){
                end = mid-1;
            } else {
                st = mid +1;
            }
        }
        return letter[st%letter.length];
    }
    // leetcode 1295
    public static int findEvenCount(int nums[])
    {
        if (nums == null) {
            return 0;
        }
        int count =0;
        for (int num : nums){
            if (even(num)){
                count++;
            }
        }
        return count;
    }
    public static boolean even(int num)
    {
        int number = count(num);
        return number %2 ==0;
    }
    public static int count(int num)
    {
        if (num < 0) {
            num = num * -1;
        }
        return (int) Math.log10(num) +1;
    }
    // leetcode 123
    public static int buyStockShell3(int stock[])
    {
        if (stock == null || stock.length ==0 ){
            return 0;
        }
        int buy1 = -stock[0], sell1 =0;
        int buy2 = -stock[0], sell2 = 0;
        for (int i=1; i<stock.length; i++){
            buy1 = Math.max(buy1, -stock[i]);
            sell1 = Math.max(sell1, buy1 + stock[i]);
            buy2 = Math.max(buy2, sell1 - stock[i]);
            sell2 = Math.max(sell2, buy2 +stock[i]);
        }
        return sell2;
    }
    // leetcode 122
    public static int buyStockShell2(int stock[])
    {
        if (stock == null || stock.length == 0){
            return 0;
        }
        int maxProfit =0;
        for (int i=1; i<stock.length; i++){
            if (stock[i] > stock[i-1]){
                maxProfit += stock[i] - stock[i-1];
            }
        }
        return maxProfit;
    }
    // leetcode 121
    public static int buyStockShell(int stock[]){
        if (stock == null || stock.length == 0){
            return 0;
        }
        int min_value = Integer.MAX_VALUE;
        int maxCurrent = 0;
        for (int price : stock){
            min_value = Math.min(min_value, price);
            int current =  price - min_value;
            maxCurrent = Math.max(maxCurrent, current);
        }
        return maxCurrent;
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
