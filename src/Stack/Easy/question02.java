package Stack.Easy;

import java.util.Stack;

public class question02 {

    public static void main(String[] args) {

    }

    static String reverseWords(String str)
    {
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i=0; i<str.length(); i++){
            if (str.charAt(i) != ' '){
                st.push(str.charAt(i));
            } else {
                while (!st.isEmpty()) {
                    res.append(st.pop());

                }
                res.append(" ");
            }
        }
        while (!st.isEmpty()) {
            res.append(st.pop());
        }
        return res.toString();
    }
    static String postToPre(String post_exp)
    {
        Stack<String> s = new Stack<>();
        int n = post_exp.length();
        for (int i=0; i<n; i++){
            if (operands(post_exp.charAt(i))){
                String op1 = s.peek();
                s.pop();
                String op2 = s.peek();
                s.pop();
                String temp = post_exp.charAt(i) + op2 + op1;
                s.push(temp);
            } else {
                s.push(post_exp.charAt(i) + "");
            }
        }
        String ans = "";
        for (String st : s){
            ans += st;
        }
        return ans;
    }
    static boolean operands(char x)
    {
        switch (x){
            case '+' :
            case '-' :
            case '/' :
            case  '*' :
                return true;
        }
        return false;
    }
}
