package Stack.Medium;

public class medium {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()))()(("));
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
