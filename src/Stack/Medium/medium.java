package Stack.Medium;
import java.util.*;
public class medium {

    public static void main(String[] args) {
        String[] arr = {"gfg", "for", "geeks",
                "geeks", "for"};

        System.out.println(removeConsecutiveSame(arr));
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
