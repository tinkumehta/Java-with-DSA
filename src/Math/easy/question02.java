package Math.easy;

public class question02 {
    public static void main(String[] args) {
         factors1(20);
        System.out.println();
      //  System.out.println(gcd(4, 9));
        System.out.println(lcm(4, 2));
    }
    static void factors1 (int n)
    {
        for (int i=1; i<=n; i++){
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
    }
    static int gcd (int a, int b)
    {
        if (a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }
    static int lcm(int a, int b){
        return a*b /gcd(a, b);
    }
}
