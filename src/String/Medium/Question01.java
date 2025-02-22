package String.Medium;
import java.util.*;

public class Question01 {

    public static void main(String[] args) {
     //   System.out.println(lastSubstring("abab"));
        System.out.println(orderlyQueue("baaca", 3));

    }
    public static String orderlyQueue(String s, int k)
    {
        if (k > 1) {
            char chars[] = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
        String ss = s;
        for (int i=1; i<s.length(); i++){
            String rot = s.substring(i) + s.substring(0, i);
            if (ss.compareTo(rot) >0)
                ss = rot;
        }
        return ss;
    }

    public static String lastSubstring(String s)
    {
        int i=0, k=0, j=1;
        int n = s.length();
        char ch [] = s.toCharArray();
        while (j + k < n) {
            if (ch[i+k] == ch[j+k]){
                k++;
            } else if (ch[i+k] > ch[j+k]) {
                j = j+k+1;
                k=0;
            } else {
                i = Math.max(i+k+1, j);
                j = i+1;
                k=0;
            }
        }
        return s.substring(i);
    }
    public static int findMinDifference(List<String> timePoints)
    {
        int res = Integer.MAX_VALUE;
        int n = timePoints.size();
        int c [] = new int[n];
        for (int i=0; i<n; i++){
            String s = timePoints.get(i);
            c[i] = Integer.parseInt(s.substring(0, 2)) * 60 +
                    Integer.parseInt(s.substring(3, 5));
        }
        Arrays.sort(c);
        for (int i=1; i<n; i++){
            res = Math.min(res, c[i] - c[i-1]);
        }
        res = Math.min(res, c[0] + (24*60 - c[n-1]));
        return res;
    }
    public static String shiftingLetters(String s, int[] shifts)
    {
        char ans[] = s.toCharArray();
        long sum =0;
        for(int i= shifts.length-1; i>-1; i--){
            sum += shifts[i];
            ans[i] = (char) (((ans[i] - 'a' + sum) % 26) + 'a');
        }
        return String.valueOf(ans);
    }
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num =0;
        char prev = '+';
        for(int i=0; i<= s.length(); i++){
            char ch = (i < s.length()) ? s.charAt(i) : '\0';

            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }

            if(!Character.isDigit(ch) && ch != ' ' || i== s.length()){
                if(prev == '+') stack.push(num);
                if(prev == '-') stack.push(-num);
                if(prev == '*') stack.push(stack.pop() * num);
                if(prev == '/') stack.push(stack.pop() / num);

                prev = ch;
                num =0;
            }
        }
        int result =0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }

    public static int repeatedStringMatch(String a, String b)
    {
        StringBuilder s = new StringBuilder(a);
        int count =1;
        while (s.length() < b.length()) {
            s.append(a);
            count++;
        }
        if (s.indexOf(b) != -1) {
            return count;
        }
        s.append(a);
        count++;
        if (s.indexOf(b) != -1) {
            return count;
        }
        return -1;
    }
}
