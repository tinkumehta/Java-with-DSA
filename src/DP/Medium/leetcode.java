package DP.Medium;
import java.util.*;

public class leetcode {
    public static void main(String[] args) {
        int n =3;
       // System.out.println(isMatch("aa", "a.*"));
        List<String> res = generateParenthesis(n);
        System.out.println(res);
    }
    public int rob2(int nums[])
    {
        int n = nums.length;
        if (n ==1) return nums[0];
        if (n ==2) return Math.max(nums[0], nums[1]);
        return Math.max(rob( nums, 0, n-2), rob(nums, 1, n-1));
    }
    public int rob(int nums[], int start, int end)
    {
        int prev1 = nums[start];
        int prev2 = Math.max(nums[start], nums[start +1]);
        for (int i=start+2; i<=end; i++){
            int cur = Math.max(nums[i] +prev1, prev2);
            prev1 = prev2;
            prev2 = cur;
        }
        return prev2;
    }
    public int rob(int[] nums)
    {
        int l = nums.length;
        if (l == 1) return nums[0];
        if (l == 2) return Math.max(nums[0], nums[1]);
        if (l ==3) return Math.max(nums[0] + nums[2], nums[1]);
        int res [] = new int[l];
        res[0] = nums[0];
        res[1] = nums[1];
        res[2] = nums[0] + nums[2];
        for (int i=3; i<l ; i++){
            res[i] = Math.max(res[i-2] + nums[i],res[i-3] + nums[i] );
        }
        return Math.max(res[l-1],res[l-2] );
    }
    public int maxProfit(int[] prices)
    {
        int buyPrice = prices[0];
        int profit =0;
        for (int i=0; i<prices.length; i++){
            if (buyPrice > prices[i]){
                buyPrice = prices[i];
            }
            profit = Math.max(profit, prices[i] - buyPrice);
        }
        return profit;
    }
    public int numTree(int n)
    {
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i<=n; i++){
            int x =0;
            int y = i-1;
            int sum =0;
            while (x < i && y >=0){
                sum += dp[x] * dp[y];
                x++;
                y--;
            }
            dp[i] = sum;
        }
        return dp[n];
    }
    public int uniquePaths(int m, int n)
    {
        int dp[][]= new int[m][n];
        for (int i=0; i<m; i++){
            dp[i][0] = 1;
        }
        for (int i=0; i<n; i++){
            dp[0][i] = 1;
        }
        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
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
