package DP.Medium;

import java.util.Arrays;

public class question02 {
    public static void main(String[] args) {
        String str = "geeks";
        System.out.println(findMinInsertions(str));
    }
    static int findMinInsertions(String str)
    {
        int n = str.length();
        int dp[][] = new int[n+1][n+1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return getMinPeliAns(str, 0, n-1, dp);
    }
    static int getMinPeliAns(String str, int l, int h, int[][] memo)
    {
        if (l >= h) return Integer.MAX_VALUE;
        if (l == h) return 0;
        if (l == h-1) return (str.charAt(l) == str.charAt(h)) ? 0: 1;
        if (memo[l][h] != -1) return memo[l][h];
        if (str.charAt(l) == str.charAt(h)){
            return memo[l][h] = getMinPeliAns(str, l+1, h-1, memo);
        }
        return memo[l][h] = Math.min(getMinPeliAns(str, l+1, h, memo),
                             getMinPeliAns(str, l, h-1, memo)) +1;
    }
}
