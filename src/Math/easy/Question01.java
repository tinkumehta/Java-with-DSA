package Math.easy;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Question01 {

    public static void main(String[] args) {
      //  System.out.println(climbStairs(3));
      //  System.out.println(selfDividingNumbers(47, 85));
        System.out.println(addBinary("11", "1"));
    }

    public static String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry =0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >=0) sum += b.charAt(j--) - '0';
            carry = sum >1 ? 1 : 0;
            res.append(sum % 2);
        }
        if (carry !=0) res.append(carry);
        return res.reverse().toString();
    }
    public static List<Integer> selfDividingNumbers(int left, int right)
    {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i= left ; i<=right; i++){
            if (check(i))
                res.add(i);

        }
        return res;
    }
    static boolean check(int num)
    {
        int temp = num;
        while (num > 0) {
            int rem = num % 10;
            if ( rem ==0) return  false;
            if (temp % rem != 0) return false;
            num /= 10;
        }
        return true;
    }
    public static int climbStairs(int n)
    {
        int dp[] = new int[n +1];
        dp[0]= 1;
        dp[1] = 1;
        for (int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i -2];
        }
        return dp[n];
    }
    public static int maximumProduct(int[] nums)
    {
        Arrays.sort(nums);
        int case1 = nums[0] * nums[1] * nums[nums.length-1];
        int case2 = nums[nums.length -1] * nums[nums.length -2] * nums[nums.length -3];
        int max = Math.max(case1, case2);
        return max;
    }
    public static String convertToTitle(int columnNumber)
    {
        StringBuilder str = new StringBuilder();
        while (columnNumber > 0) {
            int index = (columnNumber -1) % 26;
            str.insert(0, (char) ('A' + index));
            columnNumber = (columnNumber -1) / 26;
        }
        return str.toString();
    }
    static boolean armstrongNumber(int n)
    {
        int temp = n;
        int res =0;
        while (n != 0) {
            int digit = n % 10;
            res += Math.pow(digit, 3);
            n /= 10;
        }
        if (res == temp) {
            return true;
        } else {
            return false;
        }
    }

    public static int romanToInt(String s)
    {
        int num =0, ans =0;
        for (int i=s.length() -1; i>= 0; i--){
            switch (s.charAt(i)) {
                case  'I' : num =1;
                break;
                case  'V' : num = 5;
                break;
                case  'X' : num = 10;
                break;
                case  'L' : num = 50;
                break;
                case   'C' : num = 100;
                break;
                case  'D' : num = 500;
                break;
                case  'M' : num = 1000;
                break;
            }
            if (4 * num < ans) ans -= num;
            else
                ans += num;
        }
        return ans;
    }
}
