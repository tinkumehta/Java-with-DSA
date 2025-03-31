package Queue.Easy;

import java.util.HashMap;
import java.util.Stack;

public class Leetcode {

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4};

    }
    public int[] mostCompetitive(int[] nums, int k)
    {
        int res [] = new int[k];
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i< nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < stack.peek() && nums.length - i > k - stack.size()) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(nums[i]);
            }
        }
            for (int i=k-1; i>=0; i--){
                res[i] = stack.pop();
            }


        return res;
    }
    public static boolean find132pattern(int[] nums)
    {
        if (nums.length < 3) {
            return false;
        }
        int min = Integer.MIN_VALUE;
        int high = nums.length;
        for (int i= nums.length -1; i>=0; i--){
            if (nums[i] < min) {
                return true;
            }
            while (high < nums[i] && nums[i] > nums[high]){
                min = nums[high];
                high++;
            }
            high--;
            nums[high] = nums[i];
        }
        return false;
    }
      static  int i=0;
    public static String decodeString(String s)
    {

     StringBuilder sb = new StringBuilder();
     int count =0;
     String temp ="";
        while (i < s.length()) {
            char c = s.charAt(i);
            i++;
            if (c =='['){
                temp = decodeString(s);
                int j =0;
                while (j < count) {
                    sb.append(temp);
                    j++;
                }
                count =0;
            } else if (c == ']')break;
            else if (Character.isAlphabetic(c))
                sb.append(c);
            else
                count = count * 10 + c-'0';
        }
        return sb.toString();
    }
    public static int minAddToMakeValid(String s)
    {
        int open =0, mismatch =0;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == '('){
                open++;
            } else {
                if (open > 0) {
                    open--;
                }else
                mismatch++;

            }
        }
        return open + mismatch;
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color)
    {
        if (image[sr][sc] == color) return image;
        fill(image, sr, sc, color, image[sr][sc]);
        return image;
    }
    static void fill(int [][] image, int sr, int sc, int color, int curr)
    {
        if (sr <0 ||sc < 0 || sr >= image.length || sc >= image[0].length ) return;
        if (image[sr][sc] != curr) return;
        image[sr][sc]= color;
        fill(image, sr-1, sc, color, curr);
        fill(image, sr+1, sc, color, curr);
        fill(image, sr ,sc-1, color, curr);
        fill(image, sr ,sc+1, color, curr);
    }
    public static String removeDuplicates(String s)
    {
        char ch[] = new char[s.length()];
        int lastIndex = -1;
        for (char c : s.toCharArray()){
            if (lastIndex ==-1 || ch[lastIndex] != c){
                ch[lastIndex+1] = c;
                lastIndex++;
            } else {
                lastIndex--;
            }
        }
        return new String(ch, 0, lastIndex+1);
    }
    public static String removeOuterParentheses(String s)
    {
        StringBuilder ans = new StringBuilder();
        char ch [] = s.toCharArray();
        int n = ch.length;
        int count =0;
        for (int i=1; i<n; i++){
            if (ch[i] == '('){
                count++;
                ans.append('(');
            } else {
                if (count == 0) {
                    i++;
                } else {
                    ans.append(')');
                    count--;
                }
            }
        }
        return ans.toString();
    }
    public static boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()){
            if (ch =='(' || ch == '{' || ch == '['){
                stack.push(ch);
            } else {
                if (ch == ')'){
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                }
                if (ch =='}'){
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                }
                if (ch == ']'){
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums2.length; i++){
            map.put(nums2[i], i);
        }
        int nge[] = new int[nums1.length];
        for (int i=0; i< nums1.length; i++){
            nge[i] = -1;
            int index = map.get(nums1[i]);
            for (int j=index +1; j< nums2.length; j++){
                if (nums2[j] > nums1[i]){
                    nge[i] = nums2[j];
                    break;
                }
            }
        }
        return nge;
    }
}
