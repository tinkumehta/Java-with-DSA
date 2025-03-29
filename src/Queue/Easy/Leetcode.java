package Queue.Easy;

import java.util.HashMap;
import java.util.Stack;

public class Leetcode {

    public static void main(String[] args) {
        // System.out.println(isValid("[{()}]"));
      //  System.out.println(removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(removeDuplicates("aabca"));
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
