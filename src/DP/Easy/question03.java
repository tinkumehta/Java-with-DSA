package DP.Easy;

import java.util.Arrays;

public class question03 {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 3, 7, 4 };
        int sum = 12;
        if (isSubsetSum(arr, sum)){
            System.out.println("True");
        } else {
            System.out.println("false");
        }
    }
    static boolean isSubsetSum (int arr[], int sum)
    {
        int n = arr.length;
        int dp [][] = new int[n+1][sum+1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return isSubsetSumRec(arr, n, sum, dp);
    }
    static boolean isSubsetSumRec(int[] arr, int n, int sum, int[][] memo)
    {
        if (sum == 0) return true;
        if (n <=0 ) return false;
        if (memo[n][sum] != -1){
            return memo[n][sum] ==1;
        }
        if (arr[n - 1] > sum) {
            memo[n][sum] = isSubsetSumRec(arr, n-1, sum, memo) ? 1 : 0;
        } else {
            memo[n][sum] = isSubsetSumRec(arr, n-1, sum, memo) ||
                        isSubsetSumRec(arr, n-1 , sum - arr[n-1], memo) ? 1 : 0;
        }
        return memo[n][sum] == 1;
    }
    static int countCoins(int coins[], int sum)
    {
        int dp[][] = new int[coins.length][sum+1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return countRecur(coins, coins.length, sum, dp);
    }
    static int countRecur(int[] coins, int n, int sum, int[][] memo)
    {
        if (sum ==0) return 1;
        if (sum < 0 || n ==0) return 0;
        if (memo[n-1][sum] != -1) return memo[n-1][sum];
        return memo[n-1][sum] = countRecur(coins, n, sum - coins[n-1], memo) +
                             countRecur(coins, n-1, sum, memo);
    }
    static int knapSackRecur(int i, int capacity, int[] val,
                             int[] wt, int[][] memo)
    {
        if (i == val.length) return 0;
        if (memo[i][capacity] != -1){
            return memo[i][capacity];
        }
        int taken =0;
        if (wt[i] <= capacity){
            taken = val[i]+ knapSackRecur(i, capacity - wt[i], val, wt, memo);
        }
        int notTaken = knapSackRecur(i+1, capacity, val, wt, memo);
        return memo[i][capacity] = Math.max(taken, notTaken);
    }
    static int knapSack(int capacity, int val[], int wt[])
    {
        int dp[][] = new int[val.length][capacity+1];
        for (int i=0; i<val.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return knapSackRecur(0, capacity, val, wt, dp);
    }
}
