package InterviewsQuestions.Netflix;

 /*
 Longest repeating and non-overlapping substring
 Given a string s, the task is to find the longest repeating non-overlapping substring in it.
 In other words, find 2 identical substrings of maximum length which do not overlap. Return -1 if no such string exists.

Note: Multiple Answers are possible but we have to return the substring whose first occurrence is earlier.

Examples:

Input: s = "acdcdacdc"
Output: "acdc"
Explanation: The string "acdc" is the longest Substring of s which is repeating but not overlapping.

Input: s = "geeksforgeeks"
Output: "geeks"
Explanation: The string "geeks" is the longest subString of s which is repeating but not overlapping.
  */

public class question07 {
    static String longestRepeating(String s)
    {
        int n = s.length();
        int dp[][]= new int[n+1][n+1];
        String ans = "";
        int strLen =0;
        for (int i=n-1; i>=0; i--){
            for (int j=n-1; j>=i; j--){
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = 1 + Math.min(dp[i+1][j+1], j-i-1);
                    if (dp[i][j] >= strLen) {
                        strLen = dp[i][j];
                        ans = s.substring(i, i+strLen);
                    }
                }
            }
        }
        return strLen > 0 ? ans : "0";
    }

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(longestRepeating(s));
    }
}
