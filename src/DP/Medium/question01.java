package DP.Medium;

import java.util.Arrays;

public class question01 {

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "bcfe";
        System.out.println(editDistance(s1, s2));
    }

    static int editDistance(String s1, String s2)
    {
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m+1][n+1];
        for (int row [] : dp)
            Arrays.fill(row, -1);
        return editDistRec(s1, s2, m, n, dp);
    }
    static int editDistRec(String s1, String s2, int m, int n, int[][] memo)
    {
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        if (s1.charAt(m-1) == s2.charAt(n-1)){
            return memo[m][n] = editDistRec(s1, s2, m-1, n-1, memo);
        }
        return memo[m][n] = 1 + Math.min(
                Math.min(
                        editDistRec(s1, s2, m, n-1, memo),
                        editDistRec(s1, s2, m-1, n, memo)),
                         editDistRec(s1, s2, m-1, n-1, memo)
        );
    }
    static int lis(int arr[])
    {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        int res =0;
        for (int i=0; i<n; i++){
            res = Math.max(res, lisEndingAtIdx(arr, i, dp));
        }
        return res;
    }
    static int lisEndingAtIdx(int[] arr, int idx, int[] memo)
    {
        if (idx == 0) return 1;
        if (memo[idx] != -1) return memo[idx];
        int max = 1;
        for (int i=0; i<idx; i++){
            if (arr[i] < arr[idx])
                max = Math.max(max, lisEndingAtIdx(arr, i, memo) +1);
        }
        memo[idx] = max;
        return memo[idx];
    }
    static int lcs(String s1, String s2)
    {
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m+1][n+1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return lcsRec(s1, s2, m, n,dp);
    }
    static int lcsRec(String s1, String s2, int m, int n, int[][] memo)
    {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        // match
        if (s1.charAt(m-1) == s2.charAt(n -1)){
            return memo[m][n] = 1 + lcsRec(s1, s2, m-1, n-1, memo);
        }
        // do not match

            return memo[m][n] = Math.max(lcsRec(s1, s2, m, n-1, memo) ,
                                    lcsRec(s1, s2, m-1, n, memo) );

    }
    static double waterOverflow(int k, int r, int c)
    {
        double meme[][] = new double[r][r];
        meme[0][0] = k;
        for (int row =0; row < r-1; row++){
            for (int col =0; col<= row; col++){
                double execs = Math.max(0.0, meme[row][col] - 1.0);
                if (execs > 0) {
                    meme[row][col] = 1.0;
                    meme[row+1][col] = execs / 2.0;
                    meme[row+1][col +1] = execs / 2.0;
                }
            }
        }
        return Math.min(1.0, meme[r-1][c-1]);
    }
}
