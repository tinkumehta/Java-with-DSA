package String.Easy;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Stack;

public class Question02 {
    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }
    public static String multiply(String num1, String num2)
    {
        return new BigInteger(num1).multiply(new BigInteger(num2)).toString();
    }
    public static int lengthOfLastWord(String s)
    {
        int length =0;
        boolean forward = false;
        for(int i=s.length() -1; i>=0; i--){
            char c = s.charAt(i);
            if (c == ' ' && forward){
                return length;
            }
            if (Character.isLetter(c)){
                length++;
                forward = true;
            }
        }
        return length;
    }
    // (), {}, []
    public static boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()){
            if (ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            } else {
                if (ch == ')'){
                    if (stack.isEmpty() || stack.pop() != '(') return  false;
                }
                if (ch == '}'){
                    if (stack.isEmpty() || stack.pop() != '{') return  false;
                }
                if (ch == ']'){
                    if (stack.isEmpty() || stack.pop() != '[') return  false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static String reversePrefix(String word, char ch)
    {
        int j = word.indexOf(ch);
        if (j != -1) {
            return new StringBuilder(word.substring(0, j+1))
                    .reverse().toString() + word.substring(j+1);
        }
        return word;
    }
    public static String mergeAlternately(String word1, String word2)
    {
        int m = word1.length();
        int n = word2.length();
        StringBuilder ans = new StringBuilder();
        for (int i=0; i<m || i<n; i++){
            if (i < m) {
                ans.append(word1.charAt(i));
            }
            if (i < n) {
                ans.append(word2.charAt(i));
            }
        }
        return ans.toString();
    }
    public static int maxRepeating(String sequence, String word)
    {
        int count =0;
        String add = word;
        while (sequence.contains(word) == true) {
            count++;
            word += add;
        }
        return count;
    }
    public static String longestCommonPrefix(String[] v)
    {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(v);
        String left = v[0];
        String last = v[v.length-1];
        for (int i=0; i<Math.min(left.length(), last.length()) ; i++){
            if (left.charAt(i) != last.charAt(i)){
                return ans.toString();
            }
            ans.append(left.charAt(i));
        }
        return ans.toString();
    }
}
