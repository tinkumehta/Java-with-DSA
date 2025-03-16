package Math.medium;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Question01 {

    public static void main(String[] args) {
     int arr[] = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(arr)));

        System.out.println(integerBreak(10));
    }
    public static int integerBreak(int n)
    {
        if (n == 2 || n == 3) return (n -1);
        int res =1;
        if (n > 4) {
            n -= 3;
            res *=3;
        }
        return (n * res);
    }
    public static int[] productExceptSelf(int[] nums) {
        int left []= new int[nums.length];
        int right []= new int[nums.length];
        left[0] =1;
        for (int i=1; i<nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
            right[nums.length-1] = 1;
            for (int j= nums.length-2; j >=0; j--){
                right[j] = right[j+1] * nums[j+1];
            }
            for (int i=0; i<nums.length; i++){
                nums[i] = left[i] * right[i];
            }
        return nums;
    }
    public static int[] countPoints(int[][] points, int[][] queries)
    {
        int ans [] = new int[queries.length];
        for (int i=0; i<queries.length; i++){
            int x  = queries[i][0];
            int y  = queries[i][1];
            int r  = queries[i][2];
            for (int point[] : points){
                int a = point[0];
                int b = point[1];

                if (Math.pow(x -a,2) + Math.pow(y -b, 2) <= Math.pow(r, 2)){
                    ans[i]++;
                }
            }
        }
        return ans;
    }
    public static int kthFactor(int n, int k)
    {
        int count =0;
        for (int i=1; i<=n; i++){
            if (n % i == 0) {
                count++;
            }
            if (count == k)
                return i;
        }
        return -1;
    }
    public static double angleClock(int hour, int minutes) {
        double hoursAng = (hour % 12) * 30.0 + (minutes / 60.0) * 30.0;
        double minAng = minutes * 6.0;
        double angle = Math.abs(hoursAng - minAng);
        return Math.min(angle, 360.0 -angle);
    }
    public static int numSquares(int n)
    {
        int arr[] = new int[n+1];
        Arrays.fill(arr, -1);
        return solve(n, arr);
    }
    static int solve(int n, int arr[])
    {
        if (arr[n] != -1) return arr[n];
        if (n <= 0) return 0;
        int res =0;
        int min = Integer.MAX_VALUE;
        for (int i=1; i<=Math.sqrt(n); i++){
            res = 1 + solve(n -(i * i), arr);
            min = Math.min(min, res);
        }
        return arr[n]= min;
    }
    public static int uniquePaths(int m, int n)
    {
        int dp [][] = new int[m][n];
        for (int i=0; i<m; i++){
            dp[i][0] = 1;
        }
        for (int j=0; j<n; j++){
            dp[0][j] = 1;
        }
        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
