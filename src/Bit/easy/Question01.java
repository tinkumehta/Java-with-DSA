package Bit.easy;

import java.util.HashSet;
import java.util.Set;

public class Question01 {
    public static void main(String[] args) {
        System.out.println(longestNiceSubstring("Bb"));
    }
    public static String longestNiceSubstring(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()){
            set.add(c);
        }
        for (int i=0; i<s.length(); i++){
            if (set.contains(Character.isUpperCase(s.charAt(i))) &&
                  set.contains(Character.isLowerCase(s.charAt(i))))
                continue;
                String s1 = longestNiceSubstring(s.substring(0, i));
                String s2 = longestNiceSubstring(s.substring(i+1));
                return s1.length() >= s2.length() ? s1 : s2;
        }
        return s;
    }
    public static String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i= a.length() -1;
        int j= b.length() -1;
        int carry =0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >=0) sum += a.charAt(i--) - '0';
            if (j >=0 )sum += b.charAt(j--) - '0';
            carry = sum >1 ? 1: 0;
            res.append(sum % 2);
        }
        if (carry != 0) res.append(carry);
        return res.reverse().toString();
    }
}
