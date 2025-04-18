package Stack.Hard;

import java.util.Stack;

public class question01 {
    static int MAX_CHAR = 26;

    static boolean addSing(String s, int i)
    {
        if (i == 0) return true;
        if (s.charAt(i -1) == '-') return false;
        return true;
    }
    static void eval(String s, int v[], boolean add)
    {
        Stack<Boolean> stk = new Stack<>();
        stk.push(true);
        int i=0;
        while (i < s.length()) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-'){
                i++;
                continue;
            }
            if (s.charAt(i) == '('){
                if (addSing(s, i))
                    stk.push(stk.peek());
                    else
                        stk.push(!stk.peek());
            } else if (s.charAt(i) == ')') {
                stk.pop();
            } else {
                if (stk.peek())
                    v[s.charAt(i) - 'a'] += (addSing(s, i) ? add ? 1 : -1 : add ? -1 : 1 );
                else
                    v[s.charAt(i) - 'a'] += (addSing(s, i) ? add ? -1 : 1 : add ? 1 : -1);
            }
            i++;
        }
    }
    static boolean areSame(String exp1, String exp2)
    {
        int v []= new int[MAX_CHAR];
        eval(exp1, v, true);
        eval(exp2, v, false);
        for (int i=0; i< MAX_CHAR; i++){
            if (v[i] !=0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String expr1 = "-(a+b+c)", expr2 = "-a-b-c";
        if (areSame(expr1, expr2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
