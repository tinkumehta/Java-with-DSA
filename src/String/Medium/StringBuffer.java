package String.Medium;
import java.math.BigDecimal;
import  java.util.*;
import java.math.BigInteger;

public class StringBuffer {
    public static void main(String[] args) {
//      StringBuilder sb = new StringBuilder();
//      sb.append("WeMake Devs");
//      String str = sb.toString();
//        System.out.println(str);
        BigInteger a = BigInteger.valueOf(242);
        BigInteger b = BigInteger.valueOf(45755544);
        BigInteger d =  new BigInteger("45755544465795425");
        BigInteger w =  new BigInteger("45755544465795425789456751521");

        // const
        BigInteger c = BigInteger.ONE;
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//        BigInteger s = d.add(w);
//        System.out.println(s);

        BigDecimal X = new BigDecimal("0.03");
        BigDecimal Y = new BigDecimal("0.04");
        BigDecimal ans = Y.subtract(X);
        System.out.println(ans);
    }
}
