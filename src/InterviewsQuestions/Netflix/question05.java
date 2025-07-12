package InterviewsQuestions.Netflix;
/*
    All distinct palindromic sub-strings of a given string
    Given a string str of lowercase ASCII characters.
    The task is to find all the distinct continuous palindromic sub-strings which are present in the string str.

Examples:

Input: str = "abaaa"
Output: [ "a", "aa", "aaa", "aba", "b" ]
Explanation: All 5 distinct continuous palindromic sub-strings are listed above.

Input: str = "geek"
Output: [ "e", "ee", "g", "k" ]
Explanation: All 4 distinct continuous palindromic sub-strings are listed above.
 */

import java.util.ArrayList;
import java.util.HashSet;

public class question05 {
    static ArrayList<String> palindromic (String s)
    {
        int n = s.length();
        boolean dp[][]= new boolean[n][n];
        HashSet<String> st = new HashSet<>();
        for (int gap =0; gap <n; gap++){
            for (int i=0, j=gap; j<n; j++ ,i++){
                if (gap == 0)
                    dp[i][j] = true;
                else if (gap ==1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }
                else
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i+1][j-1];
                if (dp[i][j])
                    st.add(s.substring(i, j+1));
            }

        }
        ArrayList<String> res = new ArrayList<>(st);
        return res;
    }

    public static void main(String[] args) {
        String str = "abaaa";
        ArrayList<String> res = palindromic(str);
        for (String r : res)
            System.out.print(r + " ");
    }
}
