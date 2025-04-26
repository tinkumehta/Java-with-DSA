package DP.Easy;

import java.util.Arrays;

public class question01 {
    public static void main(String[] args) {
        int n = 5;
       int result = bellNumber(n);
        System.out.println(result);
    }
    static int bellNumber(int n)
    {
        int dp[][] = new int[n+1][n+1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        int result =0;
        for (int i=1; i<=n; i++){
            result += stirling(n, i, dp);
        }
        return result;
    }
    static int stirling(int n, int k, int[][] memo)
    {
        if (n ==0 && k ==0) return 0;
        if (n ==0 || k == 0) return 0;
        if (n == k) return 1;
        if (k == 1) return 1;
        if (memo[n][k] != -1) return memo[n][k];
        memo[n][k] = k * stirling(n-1, k, memo) + stirling(n -1, k-1, memo);
        return memo[n][k];
    }
    static int minSquares(int n)
    {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return minSquaresRec(n, dp);
    }
    static int minSquaresRec(int n, int[] memo)
    {
        if (n <=3) return n;
        if (memo[n] != -1) return memo[n];
        int cnt =n;

        for (int x=1; x*x <n; x++){
            cnt = Math.min(cnt, 1 + minSquaresRec(n- x*x , memo));
        }
        return memo[n] = cnt;
    }


    static int maxCut(int n, int x, int y, int z)
    {
        int dp [] = new int[n+1];
        Arrays.fill(dp, -1);
        int res = maxCutHelper(n, x, y, z, dp);
        if (res == -1) return 0;
        return res;
    }
    static int maxCutHelper(int n, int x, int y, int z, int[] memo)
    {
        if (n ==0) return 0;
        if (n < 0) return -1;
        if (memo[n] != -1) return memo[n];

        int cut1 = maxCutHelper(n-x, x, y, z, memo);
        int cut2 = maxCutHelper(n-y, x, y, z, memo);
        int cut3 = maxCutHelper(n-z, x, y, z, memo);

        int max = Math.max(cut1, Math.max(cut2, cut3));
        if (max == -1) {
            return memo[n] = -1;
        }
        return memo[n] = max +1;
    }
    static int minCostClimbing(int cost[])
    {
        int n = cost.length;
        if (n == 1) return cost[0];
        int dp [] = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(minCostRecur(n-1, cost, dp), minCostRecur(n-2, cost, dp));
    }
    static int minCostRecur(int i, int[] cost, int[] memo)
    {
        if (i ==0 || i == 1) return cost[i];
        if (memo[i] != -1) return memo[i];

        return memo[i] = cost[i] +
                Math.min(minCostRecur(i -1, cost, memo), minCostRecur(i-2, cost, memo));
    }
    static int countWay(int n)
    {
        int dp [] = new int[n +1];
        Arrays.fill(dp, -1);
        return countWaysRecur(n, dp);
    }
    static int countWaysRecur(int n, int[] memo)
    {
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (memo[n] != -1) return memo[n];

        return memo[n] = countWaysRecur(n-1, memo) +
                        countWaysRecur(n-2, memo) +
                        countWaysRecur(n -3, memo);
    }
    static int printTrib(int n)
    {
        int dp []= new int[n+1];
        Arrays.fill(dp, -1);
        return printTribRec(n, dp);
    }
    static int printTribRec(int n, int[] dp)
    {
        if (n == 0 || n == 1 || n == 2) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        if (n == 3) {
            return  1;
        }
         else
          return    dp[n] = printTribRec(n-1, dp) +
                     printTribRec(n-2, dp) +
                     printTribRec(n-3, dp) ;
    }
    static int nthFib(int n)
    {
        int meme[] = new int[n+1];
        Arrays.fill(meme, -1);
        return nthFibUtil(n, meme);
    }
    static int nthFibUtil(int n, int meme[])
    {
        if (n <= 1) {
            return n;
        }
        if (meme[n] != -1) {
            return meme[n];
        }
        meme[n] = nthFibUtil(n-1, meme) + nthFibUtil(n-2, meme);
        return meme[n];
    }
}
