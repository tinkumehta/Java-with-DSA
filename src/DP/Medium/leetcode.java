package DP.Medium;
import java.util.*;

public class leetcode {
    public static void main(String[] args) {
        int n =3;
       // System.out.println(isMatch("aa", "a.*"));
        List<String> res = generateParenthesis(n);
        System.out.println(res);
    }
    public int jump(int nums[])
    {
        int ans =0;
        int end=0, farthes =0;
        for (int i=0; i<nums.length-1; i++){
            farthes = Math.max(farthes, i+ nums[i]);
            if (farthes >= nums.length) {
                ++ans;
                end = farthes;
            }
            if (i == end) {
                ++ans;
                end =farthes;
            }
        }
        return ans;
    }
    public int minPathSum(int [][]grid)
    {
        int m = grid.length;
        int n= grid[0].length;
        int dp[][] = new int[m][n];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return minPathSum(grid, m-1, n-1, dp);
    }
    public int minPathSum(int[][] grid, int m, int n, int dp[][])
    {
        if (m ==0 && n==0) return grid[m][n];
        if (m <0 || n<0) return Integer.MAX_VALUE/10;
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        int up = grid[m][n] +minPathSum(grid, m-1, n, dp);
        int down = grid[m][n] + minPathSum(grid, m, n-1, dp);
        return dp[m][n] = Math.min(up, down);
    }

    public static List<String> generateParenthesis(int n)
    {
        List<String> prem = new ArrayList<>();
        char temp[] = new char[n*2];
        generateParenthesis(n,n, temp, 0, prem);
        return prem;
    }
    public static void generateParenthesis(int left, int right, char temp[],
                                           int pos, List<String> prem)
    {
        if (left <0 || right<0 || left > right) return;
        if (left ==0 && right == 0) {
            prem.add(String.copyValueOf(temp));
        }
        if (left > 0) {
            temp[pos] = '(';
            generateParenthesis(left-1, right, temp, pos+1, prem);
        }
        if (right > left) {
            temp[pos] = ')';
            generateParenthesis(left, right -1, temp, pos+1, prem);
        }

    }
    public static boolean isMatch (String s, String p)
    {
        int m = s.length(), n = p.length();
        boolean dp[][] = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int j=2; j<= n; j++){
            if (p.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-2];
            }
        }
        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){
                if (p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-2] || (
                            dp[i-1][j] && (s.charAt(i-1) == p.charAt(j-2) ||
                                    p.charAt(j-2) == '.'));
                } else {
                    dp[i][j] = dp[i-1][j-1] &&  (s.charAt(i-1) == p.charAt(j-1) ||p.charAt(j-1) == '.');
                }
            }
        }
        return dp[m][n];
    }
}
