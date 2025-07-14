package InterviewsQuestions.Netflix;

 /*
 Find the Largest number with given number of digits and sum of digits
 Given an integer s and d, The task is to find the largest number with given digit sum s and the number of digits d.

Examples:

Input: s = 9, d = 2
Output: 90

Input: s = 20, d = 3
Output: 992
  */

import java.util.Collections;

public class question09 {
    public static int findLargest(int s, int d)
    {
        if (s == 0)
            return 0;
        if (s >= 9 * d) {
            return -1;
        }
        String result = "";
        for (int i=0; i<d; i++){
            if (s >= 9) {
                result += '9';
                s -=9;
            } else  {
                result = Integer.toString(s);
                s =0;
            }
            if (s == 0 && i < d - 1) {
                result += String.join("", Collections.nCopies(d- i-1, "0"));
                break;
            }
        }
        return Integer.parseInt(result);
    }

    public static void main(String[] args) {
        System.out.println(findLargest(9, 2));
    }
}
