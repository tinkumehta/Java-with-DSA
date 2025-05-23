package DP.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class question01 {

    public static void main(String[] args) {
        System.out.println(calculate(4));
    }
    static int calculate(int n)
    {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return calculate(n, dp);
    }
    static int calculate(int n, int[] memo)
    {
        if (n == 1) return 0;
        if (n == 2) return 1;
        if (memo[n] != -1) return memo[n];
        return memo[n] = (n-1) * (calculate(n-1, memo) + calculate(n-2, memo));
    }
    static List<Integer> Distance(int arr[])
    {
        int n = arr.length;
        int totalSum = Arrays.stream(arr).sum();
        int dp[][] = new int[n+1][totalSum +1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        distSumRec(arr, n, 0, 0, dp);
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<= totalSum; i++){
            if (dp[n][i] == 1) {
                result.add(i);
            }
        }
        return result;
    }
    static void distSumRec(int[] arr, int n, int sum, int i, int[][] memo)
    {
        if (i == n) {
            memo[i][sum] = 1;
            return;
        }
        if (memo[i][sum] != -1) {
            memo[i][sum] = 1;
            return;
        }
        memo[i][sum] = 1;
        distSumRec(arr, n, sum + arr[i], i+1, memo);
        distSumRec(arr, n, sum, i+1, memo);
    }
    static int longestPalinSubseq(String s)
    {
        int n = s.length();
        int dp[][] = new int[n][n];
        for (int row[] : dp)
            Arrays.fill(row , -1);
        return lps(s, 0, n-1, dp);
    }
    static int lps(String s, int low, int high, int[][] memo)
    {
        if (low > high) return 0;
        if (low == high) return 1;
        if (memo[low][high] != -1) {
            return memo[low][high] ;
        }
        if (s.charAt(low) == s.charAt(high)){
            return memo[low][high] = lps(s, low +1, high-1, memo) +2;
        }
       return memo[low][high] = Math.max(lps(s, low, high -1, memo), lps(s, low+1, high, memo));
    }
    static boolean equalPartion(int arr[])
    {
        int n = arr.length;
        int sum =0;
        for (int num : arr){
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int dp[][] = new int[n][sum+1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return isSubsetSum(n, arr, sum/2, dp);
    }
    static boolean isSubsetSum(int n, int[] arr, int sum, int[][] memo)
    {
        if (sum == 0) return true;
        if (n ==0) return false;
        if (memo[n-1][sum] != -1){
            return memo[n-1][sum]== 1;
        }
        if (arr[n - 1] > sum) {
            isSubsetSum(n-1, arr, sum, memo);
        }
        memo[n-1][sum] = (isSubsetSum(n-1, arr, sum, memo) ||
                        isSubsetSum(n-1, arr, sum - arr[n-1], memo) ) ? 1 : 0;
        return memo[n-1][sum] ==1;
    }
    static boolean wordBreakRec(int i, String s, String[] dictionary)
    {
        if (i == s.length()) return true;
        String perfix = "";
        for (int j=i; j<s.length(); j++){
            perfix += s.charAt(j);
            if (Arrays.asList(dictionary).contains(perfix) &&
                        wordBreakRec(j+1, s, dictionary) ){
                return true;
            }
        }
        return false;
    }
    static int knapsack(int W, int val[], int wt[])
    {
        int n = val.length;
        int dp[][]= new int[n+1][W+1];
        for (int row [] : dp)
            Arrays.fill(row, -1);
        return knapsackRec(W, val, wt, n, dp);
    }
    static int knapsackRec(int W, int[] val, int[] wt, int n, int[][] memo)
    {
        if (n ==0 || W ==0) return 0;
        if (memo[n][W] != -1) return memo[n][W];
        int pick =0;
        if (wt[n-1] <= W){
            pick = val[n-1] + knapsackRec(W - wt[n-1], val, wt, n-1, memo);
        }
        int notPick = knapsackRec(W, val, wt, n-1, memo);
        return memo[n][W] = Math.max(pick, notPick);
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
