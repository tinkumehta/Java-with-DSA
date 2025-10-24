package Bit.easy;

public class question03 {
    public static void main(String[] args) {
        int n= 5;
        int arr[] = {2, 3, 3, 4, 2, 6, 4};

        // power of 2
        int m = 32;
        boolean ans = (m & (m-1)) ==0;
        System.out.println(ans);
//        int a = 34567;
//        int b = 10;
//        int ans = (int) (Math.log10(a)/Math.log10(b)) +1;
//        System.out.println(ans);
//        int n =5;
//        int ans =0;
//        int base =5;
//        while (n > 0) {
//            // magical number
//            int last = n &1;
//            n = n>> 1;
//            ans += last * base;
//            base = base *5;
//        }
//        System.out.println(ans);
    }

    private static int unique(int[] arr)
    {
        int ans = 0;
        for (int i : arr){
            ans ^= i;
        }
        return ans;
    }

    private static boolean isOdd(int n)
    {
        return (n & 1) ==1;
    }
}
