package Math.medium;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Question01 {

    public static void main(String[] args) {
      //  System.out.println(uniquePaths(3, 2));
     //   System.out.println(numSquares(13));
        System.out.println(angleClock(12, 30));
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
