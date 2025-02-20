package String.Medium;
import java.util.*;

public class Question01 {

    public static void main(String[] args) {
        System.out.println(calculate("4+3*3"));
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
