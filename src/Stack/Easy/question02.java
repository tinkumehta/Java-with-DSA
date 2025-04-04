package Stack.Easy;

import java.util.ArrayList;
import java.util.Stack;

public class question02 {

    public static void main(String[] args) {
        int[] arr = {10, 4, 5, 90, 120, 80};

        ArrayList<Integer> span = calculateSpan(arr);
        for (int x : span){
            System.out.print(x + " ");
        }
    }
    static ArrayList<Integer> calculateSpan(int[] arr)
    {
        int n = arr.length;
        ArrayList<Integer> span = new ArrayList<>();
        for (int i=0; i<n; i++){
            span.add(1);
        }
        for (int i=1; i<n; i++){
            for (int j= i-1; j>=0 && arr[i] >= arr[j]; j--){
                span.set(i, span.get(i) +1);
            }
        }
        return span;
    }

        public static Stack<Integer> sortstack(Stack<Integer> input)
    {
        Stack<Integer> tempStack = new Stack<>();
        while (!input.isEmpty()) {
            int temp = input.pop();
            while (!tempStack.isEmpty() && tempStack.peek() < temp){
                input.push(tempStack.pop());
            }
            tempStack.push(temp);
        }
        return tempStack;
    }
    static void printPrevSmaller(int[] arr)
    {
        System.out.print("_ ,");
        for (int i=0; i<arr.length; i++){
            int j;
            for (j=  i-1; j>=0; j--){
                if (arr[j] < arr[i]){
                    System.out.print(arr[j] +" ");
                    break;
                }
            }
            if (j == -1)
                System.out.print("_ ");
        }
    }
    static ArrayList<Integer> nextLargerElement(int[] arr)
    {
        ArrayList<Integer> res = new ArrayList<>();
        int n = arr.length;
        for (int i=0; i<n; i++){
            res.add(-1);
        }
        for (int i=0; i<n; i++){
            for (int j= i+1; j<n; j++){
                if (arr[j] > arr[i]){
                    res.set(i, arr[j]);
                    break;
                }
            }
        }
        return res;
    }
    static int evaluatePostfix(String[] arr)
    {
        Stack<Integer> stack = new Stack<>();
        for (String token : arr){
            if (token.matches("-?\\d+")){
                stack.push(Integer.parseInt(token));
            } else {
                int val1 = stack.pop();
                int val2 = stack.pop();
                switch (token){
                    case "+":
                        stack.push(val2 + val1);
                        break;
                    case "-" :
                        stack.push(val2 - val1);
                    break;
                    case "*" :
                        stack.push(val2 * val1);
                    break;
                    case "/" :
                        stack.push(val2 / val1);
                    break;
                }
            }
        }
        return stack.pop();
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
