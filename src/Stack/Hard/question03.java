package Stack.Hard;

import java.util.Stack;

public class question03 {
    public static void main(String[] args) {
        System.out.println(minValidParthentice(")))"));
        System.out.println(lastWord("Hello World"));
    }
    public static int minValidParthentice(String s){
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()){
            if (ch == ')' ){
                if (!st.isEmpty() && st.peek() == '('){
                    st.pop();
                } else {
                    st.push(ch);
                }
            }else {
                st.push(ch);
            }
        }
        return st.size();
    }
    public static int  lastWord(String s){
        int count =0;
        int ch =0;
        for (int i=s.length()-1; i>=0; i--){

            if (s.charAt(i) ==' ' && ch ==1){
                return count;
            }
            if (Character.isLetter(s.charAt(i))){
                count++;
                ch =1;
            }
        }
        return count;
    }
}
