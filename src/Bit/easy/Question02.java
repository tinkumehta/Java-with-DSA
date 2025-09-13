package Bit.easy;

public class Question02 {
    public static void main(String[] args) {
        int num =10;
       int a = 2;
      a = a^num;
      num = a ^num;
      a = a^num;
       // swap(num, a);

        System.out.println(a);
        System.out.println(13<<2);
    }
    static void swap(int a, int b)
    {
        a = a^b;
        b = a^b;
        a = a^b;
    }
}
