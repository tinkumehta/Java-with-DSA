package DP.Easy;

import java.util.Arrays;

public class question03 {
    public static void main(String[] args) {
        String s = "121";
        System.out.println(decode(s));
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
        if (index >=n) return 1;
        if (memo[index] != -1) return memo[index];
        int ways =0;
        if (digits.charAt(index) != '0'){
            ways = decodeHelper(digits, index+1, memo);
        }
        // two digits
        if ((index +1 <n)
                && ((digits.charAt(index) == '1'
                && digits.charAt(index+1) <='9') ||
                (digits.charAt(index) == '2' && digits.charAt(index+1) <='6'))){
            ways += decodeHelper(digits, index+2, memo);
        }
        memo[index] = ways;
        return ways;
    }
    static int minJumps(int arr[])
    {
        int dp[] = new int[arr.length];

           Arrays.fill(dp, -1);
            int ans = minJumpsRecur(0, arr, dp);
            if (ans == Integer.MAX_VALUE)
                return -1;
            return ans;
    }
    static int minJumpsRecur(int i, int[] arr, int[] memo)
    {
        if (i == arr.length-1) return 0;
        if (memo[i] != -1) return memo[i];
        int ans = Integer.MAX_VALUE;
        for (int j=i+1; j<=i+arr[i] && j< arr.length; j++){
            int val = minJumpsRecur(j, arr, memo);
            if (val != Integer.MAX_VALUE)
            ans = Math.min(ans, 1+val);

        }
        return memo[i] = ans;
    }
    static boolean isILPrint(String s1, String s2, String s3)
    {
        int m = s1.length(), n= s2.length();
        if (m +n != s3.length()) return false;
        int dp[][] = new int[m+1][n +1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return isILRec(s1, s2, s3, 0, 0, dp);
    }
    static boolean isILRec(String s1, String s2, String s3,
                           int i, int j, int[][] memo)
    {
        int k = i+j;
        int m = s1.length();
        int n = s2.length();
        if (i == m && j== n && k == s3.length()) return true;
        if (memo[i][j] != -1) return memo[i][j] == 1;
        boolean a = false;
        if (i <m && s1.charAt(i) == s3.charAt(k)){
            a = isILRec(s1, s2, s3, i+1, j, memo);
        }
        boolean b = false;
        if (j <n && s2.charAt(j) == s3.charAt(k)){
            b = isILRec(s1, s2, s3, i, j+1, memo);
        }
        memo[i][j] = a ||b ? 1 : 0;
        return a || b;
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
