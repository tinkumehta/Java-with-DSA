package InterviewsQuestions.Netflix;

import java.util.Stack;

/*
    Longest Valid Parentheses Substring
    Input: str = "((()"
Output: 2
Explanation: Longest Valid Parentheses Substring is "()".

Input: str = ")()())"
Output: 4
Explanation: Longest Valid Parentheses Substring is "()()".
 */
public class question08 {
    static int maxLength(String s)
    {
        Stack<Integer> st= new Stack<>();
        st.push(-1);
        int maxLength =0;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == '('){
                st.push(i);
            } else {
                if (st.isEmpty()) {
                    st.push(i);
                } else {
                    maxLength = Math.max(maxLength, i -st.peek());
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(maxLength(s));
    }
}
