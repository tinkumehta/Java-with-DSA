package DP.Easy;

import java.util.Arrays;

public class question02 {

    public static void main(String[] args) {
        int[] arr = { 1, 5, 3, 7, 4 };
        int sum = 9;

        if (isSubsetSum(arr, sum)) {
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }
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
