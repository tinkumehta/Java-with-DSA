package Stack.Medium;
import java.util.*;
public class medium {

    public static void main(String[] args) {
        int[] arr = { 2, 1, 8 };
        System.out.println(findMaxDiff(arr));
    }
    public static int findMaxDiff(int[] arr)
    {
        int n = arr.length;
        int res =0;
        for (int i = 0; i < n; ++i) {
            int leftSmaller = 0, rightSmaller = 0;

            for (int j = i - 1; j >= 0; --j) {
                if (arr[j] < arr[i]) {
                    leftSmaller = arr[j];
                    break;
                }
            }
            for (int j = i + 1; j < n; ++j) {
                if (arr[j] < arr[i]) {
                    rightSmaller = arr[j];
                    break;
                }
            }

            int diff = Math.abs(leftSmaller - rightSmaller);

            res = Math.max(res, diff);
        }

        return res;
    }
    static void test(String expression, int index)
    {
        int i;
        if (expression.charAt(index) != '['){
            System.out.print(expression + ", " + index + ": -1\n");
            return;
        }
        Stack<Integer> st = new Stack<>();
        for ( i=index; i<expression.length(); i++){
            if (expression.charAt(i) == '['){
                st.push((int) expression.charAt(i));
            } else if (expression.charAt(i) == ']'){
                st.pop();
                if (st.isEmpty()) {
                    System.out.print(expression + ", "
                            + index + ": " + i + "\n");
                    return;
                }
            }
        }
        System.out.print(expression + ", " + index + ": -1\n");

    }
    static int removeConsecutiveSame(String[] arr)
    {
        List<String> list = new ArrayList<>(Arrays.asList(arr));
        int i=0;
        while (i < list.size() - 1) {
            if (list.get(i).equals(list.get(i +1))){
                list.remove(i);
                list.remove(i);
                if (i > 0) {
                    i--;
                }
            } else {
                i++;
            }

        }
        return list.size();
    }
    public static int longestValidParentheses(String s)
    {
        int leftCount  =0;
        int rightCount =0;
        int maxlength =0;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == '('){
                leftCount++;
            } else  {
                rightCount++;
            }
            if (leftCount == rightCount) {
                maxlength = Math.max(maxlength, 2 * rightCount);
            } else if (leftCount > rightCount) {
                leftCount = rightCount =0;
            }
        }
        leftCount = rightCount =0;
        for (int i=s.length()-1; i>=0; i--){
            if (s.charAt(i) == '('){
                leftCount++;
            } else {
                rightCount++;
            }
            if (leftCount == rightCount) {
                maxlength = Math.max(maxlength, 2 * leftCount);
            } else if (leftCount > rightCount) {
                leftCount = rightCount =0;
            }
        }
        return maxlength;
    }
}
