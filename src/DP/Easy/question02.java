package DP.Easy;

import java.util.Arrays;

public class question02 {

    public static void main(String[] args) {
        int[] hval = {6, 7, 1, 3, 8, 2, 4};
        System.out.println(maxLoot(hval));
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
