package Bit.easy;

public class question03 {
    public static void main(String[] args) {
        int n= 40;
        int arr[] = {2, 3, 3, 4, 2, 6, 4};

        System.out.println(sqrt(n, 3));

        // power of 2
//        int m = 32;
//        boolean ans = (m & (m-1)) ==0;
//        System.out.println(ans);
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

    // time O(log(N))
    static double sqrt(int n, int p)
    {
        int st = 0, e= n;
        double root = 0.0;
        while (st <= e) {
            int mid = st + (e - st)/2;
            if (mid * mid == n) {
                return mid;
            }
            if (mid * mid > n) {
                e = mid -1;
            } else {
                st = mid+1;
            }
        }
        double incr = 0.1;
        for (int i=0; i<p; i++){
            while (root * root <= n){
                root += incr;
            }
            root -= incr;
            incr /=10;
        }
        return root;
    }
    static void sieve(int n, boolean []primes){
        for (int i=2; i*i <=n; i++){
            if (!primes[i]){
                for (int j=i*2; j<= n; j+=i){
                    primes[j] = true;
                }
            }
        }
        for (int i=2; i<=n; i++){
            if (!primes[i]){
                System.out.print(i + " ");
            }
        }
    }
    static boolean isPrime (int n)
    {
        if (n <= 1) {
            return false;
        }
        int c= 2;
        while (c * c <= n) {
            if (n % c == 0) {
                return false;
            }
            c++;
        }
        return true;
    }
    private static int setBits (int n)
    {
        int count =0;
        while (n > 0) {
            count++;
            n -= (n & -n);
        }
        return count;
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
