package DP.Easy;

import java.util.Arrays;

public class question02 {

    public static void main(String[] args) {
        String s1 = "GeeksforGeeks";
        String s2 = "GeeksQuiz";

        System.out.println(longestCommonSubstr(s1, s2));
    }
    static int longestCommonSubstr(String s1, String s2)
    {
        int m = s1.length();
        int n= s2.length();
        int result =0;
        int dp[][] = new int[2][n +1];
        int currRow =0;
        for (int i=0; i<=m; i++){
            for (int j=0; j<=n; j++){
                if (i == 0 || j == 0) {
                    dp[currRow][j] = 0;
                } else if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[currRow][j] = dp[1-currRow][j-1] +1;
                    result = Math.max(result, dp[currRow][j]);
                }else {
                    dp[currRow][j] =0;
                }
            }
            currRow = 1-currRow;
        }
        return result;
    }
    static int minJumps(int arr[])
    {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        int ans = minJumpsRecur(0, arr, dp);
        if (ans == Integer.MAX_VALUE)
            return -1;
        return ans;
    }
    static int minJumpsRecur(int i, int[] arr, int[] memo)
    {
        if (i >= arr.length - 1) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        int ans = Integer.MAX_VALUE;
        for (int j=i+1; j<= i+ arr[i] && j< arr.length; j++){
            int val = minJumpsRecur(j, arr, memo);
            if (val != Integer.MAX_VALUE)
                ans = Math.min(ans,1+ val);
        }
        return memo[i]  = ans;
    }
    static int cutRod(int price[])
    {
        int n = price.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return cutRodRecur(n, price, dp);
    }
    static int cutRodRecur(int i, int[] price, int[] memo)
    {
        if (i ==0) return 0;
        if (memo[i-1] != -1) return memo[i-1];
        int ans =0;
        for (int j=1; j<=i; j++){
            ans = Math.max(ans, price[j-1] + cutRodRecur(i-j, price, memo));
        }
        return memo[i-1] = ans;
    }
    static int countWays(int n, int k)
    {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return countWaysRecur(n, k, dp);
    }
    static int countWaysRecur(int n, int k, int[] memo)
    {
        if (n ==1) return k;
        if (n ==2) return k*k;
        if (memo[n] != -1) return memo[n];
        int cnt1 = countWaysRecur(n-1, k, memo) * (k-1);
        int cnt2 = countWaysRecur(n-2, k, memo) * (k-1);
        return memo[n] = cnt1 + cnt2;
    }
    static int count(int coins[], int sum)
    {
        int n = coins.length;
        int dp[] []= new int[n][sum+1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return countRecur(coins, n, sum, dp);
    }
    static int countRecur(int[] coins, int n, int sum, int[][] memo)
    {
        if (sum == 0) return 1;
        if (sum < 0 || n ==0) return 0;
        if (memo[n-1][sum] != -1) return memo[n-1][sum];
        return memo[n-1][sum] = countRecur(coins, n, sum -coins[n-1], memo)
                + countRecur(coins, n-1, sum, memo);
    }
    static boolean isSubsetSum(int arr[], int sum)
    {
        int n = arr.length;
        int dp[][] = new int[n+1][sum +1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return isSubsetSumRec(arr, n, sum, dp);
    }
    static boolean isSubsetSumRec(int[] arr, int n, int sum, int[][] memo)
    {
        if (sum == 0) {
            return true;
        }
        if (n <= 0) {
            return false;
        }
        if (memo[n][sum] != -1) {
            return memo[n][sum] == 1;
        }
        if (arr[n - 1] > sum) {
            memo[n][sum] = isSubsetSumRec(arr, n-1, sum, memo) ? 1 : 0;
        } else {
            memo[n][sum] = isSubsetSumRec(arr, n-1, sum, memo) ||
                    isSubsetSumRec(arr, n-1, sum - arr[n-1], memo) ? 1 : 0;
        }
        return memo[n][sum] == 1;
    }
    static int decode(String digits)
    {
        int n = digits.length();
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return decodeHelper(digits, 0, dp);
    }
    static int decodeHelper(String digits, int index, int[] memo)
    {
        int n = digits.length();
        if (index >= n) {
            return 1;
        }
        if (memo[index] != -1) {
            return memo[index];
        }
        int ways = 0;
        if (digits.charAt(index) != '0'){
            ways = decodeHelper(digits, index +1, memo);
        }
        if ((index +1 <n) && ((digits.charAt(index) == '1'
                && digits.charAt(index+1) <= '9' )
                || (digits.charAt(index) == '2'
                 && digits.charAt(index +1) <= '6' ) )){
            ways += decodeHelper(digits, index +2, memo);
        }
        memo[index] = ways;
        return ways;
    }
    static int minCost(int cost[][])
    {
        int m = cost.length;
        int n = cost[0].length;
        int dp[] []= new int[m][n];
        for (int row [] : dp){
            Arrays.fill(row, -1);
        }
        return findMinCost(cost, 0, 0, dp);
    }
    static int findMinCost(int[][] cost, int x, int y, int[][] memo)
    {
        int m = cost.length;
        int n = cost[0].length;
        if (x >= m || y >= n) {
            return Integer.MAX_VALUE;
        }
        if (x == m-1 && y== n-1) {
            return cost[x][y];
        }
        if (memo[x][y] != -1) {
            return memo[x][y];
        }
        memo[x][y] = cost[x][y] + Math.min(Math.min(
                findMinCost(cost, x, y+1, memo),
                findMinCost(cost, x+1, y, memo)),
                findMinCost(cost, x+1, y+1, memo));
        return memo[x][y];
    }
    static int maxLoot(int hval[])
    {
        int n = hval.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return maxLootRec(hval, n, dp);
    }
    static int maxLootRec(int[] hval, int n, int[] memo)
    {
        if (n <= 0) return 0;
        if (n ==1) return hval[0];
        if (memo[n] != -1) return memo[n];

        int pick = hval[n-1] + maxLootRec(hval, n-2, memo);
        int notPick = maxLootRec(hval, n-1, memo);
        memo[n] = Math.max(pick, notPick);
        return memo[n];
    }
}
