package InterviewsQuestions.Atlassian;

/*
    Smallest window in a String containing all characters of other String
    Given two strings s (length m) and p (length n), the task is to find the smallest substring in s that contains all characters of p,
    including duplicates. If no such substring exists, return "-1".
    If multiple substrings of the same length are found, return the one with the smallest starting index.

    nput: s = "timetopractice", p = "toc"
    Output: toprac
    Explanation: "toprac" is the smallest substring in which "toc" can be found.

    Input: s = "zoomlazapzo", p = "oza"
    Output: apzo
    Explanation: "apzo" is the smallest substring in which "oza" can be found.
 */

import java.util.Arrays;

public class question04 {
    static boolean containingString(String s, String  p)
    {
        int count[] = new int[256];
        Arrays.fill(count, 0);
        for (char ch : p.toCharArray())
            count[ch]++;

        for (char ch : s.toCharArray()){
            if (count[ch] > 0)
                count[ch]--;
        }
        for (int ch : count){
            if (ch > 0)
                return false;
        }
        return true;
    }
    static String findTheSmallestSubstring(String s, String p)
    {
        int m = s.length();
        int n = p.length();
        String smallestSub = "";
        int minLen = Integer.MAX_VALUE;
        for (int i=0; i<m; i++){
            for (int j=i; j<m; j++){
                String subStr = s.substring(i, j+1);
                if (containingString(subStr, p)){
                    int currlen = subStr.length();
                    if (currlen < minLen){
                        minLen = currlen;
                        smallestSub = subStr;
                    }
                }
            }
        }
        return smallestSub;
    }

    public static void main(String[] args) {
        String s = "timetopractice" , p= "toc";
        System.out.println(findTheSmallestSubstring(s, p));
    }
}
