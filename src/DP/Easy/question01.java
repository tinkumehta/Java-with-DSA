package DP.Easy;

import java.util.Arrays;

public class question01 {
    public static void main(String[] args) {
        int[] cost = { 16, 19, 10, 12, 18 };
        System.out.println(minCostClimbing(cost));
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
