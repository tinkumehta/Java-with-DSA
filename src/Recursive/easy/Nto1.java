package Recursive.easy;

public class Nto1 {
    public static void main(String[] args) {
       // System.out.println(prod(505));
        rev1(1234);
        System.out.println(sum);
    }
    static void fun(int n)
    {
        if (n ==0) return;
        fun(n-1);
        System.out.print(n + " ");
    }
    static int fact(int n)
    {
        if (n <= 1) {
            return 1;
        }
        return n * fact(n-1);
    }
    static int sum(int n)
    {
        if (n <= 1) {
            return 1;
        }
        return n + sum(n-1);
    }
    static int sum1 (int n)
    {
        if (n ==0){
            return 0;
        }
        return (n%10) +sum1(n/10);
    }
    static int prod (int n)
    {
        if (n%10 ==n){
            return n;
        }
        return (n%10) *prod(n/10);
    }
    static int sum =0;
    static void rev1(int n)
    {
        if (n ==0) return;
        int rem = n %10;
        sum = sum * 10 + rem;
        rev1(n/10);
    }
}
