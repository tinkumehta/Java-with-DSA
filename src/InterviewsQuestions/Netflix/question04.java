package InterviewsQuestions.Netflix;
/*
    Find duplicates in O(n) time and O(n) extra space

    Given an array arr[] of n elements that contains elements from 0 to n-1,
     with any of these numbers appearing any number of times. The task is to find the repeating numbers.

Note: The repeating element should be printed only once.

Example:

Input: n = 7, arr[] = [1, 2, 3, 6, 3, 6, 1]
Output: 1, 3, 6
Explanation: The numbers 1 , 3 and 6 appears more than once in the array.

Input : n = 5, arr[] = [1, 2, 3, 4 ,3]
Output: 3
Explanation: The number 3 appears more than once in the array.
 */

import java.util.ArrayList;
import java.util.List;

public class question04 {
    static int [] findDuplicates(int arr[])
    {
        int n = arr.length;
        int freq[] = new int[n];
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<n; i++){
            freq[arr[i]]++;
        }
        for (int i=0; i<n; i++){
            if (freq[arr[i]] > 1) {
                result.add(arr[i]);
                freq[arr[i]] = 0;
            }
        }
        if (result.isEmpty()) {
            result.add(-1);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3,6, 3, 6, 1};
        int find[] = findDuplicates(arr);
        for (int i : find)
            System.out.print(i + " ");
    }
}
