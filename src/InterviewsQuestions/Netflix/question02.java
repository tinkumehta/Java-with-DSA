package InterviewsQuestions.Netflix;

/*
    Capacity To Ship Packages Within D Days
    Given an array weights[] of n packages, the task is to find the least weight capacity of a boat to ship all Packages within d days.
    The weights[i] represent the weight of ith Package. Each day, we load the boat with packages without changing their order.
     We may not load more weight than the maximum weight capacity of the boat.

     Input: weights[] = [1, 2, 3, 4, 5, 6, 7], d = 5
    Output: 7
    Explanation:

Day 1: Load the boat with packages [1, 2, 3] (total weight = 6).
Day 2: Load the boat with package [4] (total weight = 4).
Day 3: Load the boat with package [5] (total weight = 5).
Day 4: Load the boat with package [6] (total weight = 6).
Day 5: Load the boat with package [7] (total weight = 7).
The minimum capacity of boat needed is 7. With this capacity, we can ship all packages within 5 days by optimally distributing the packages as shown above.

Input: weights[] = [5, 2, 7, 4, 1, 4], d = 3
Output: 9
Explanation:

Day 1: Load the boat with packages [5, 2] (total weight = 7).
Day 2: Load the boat with packages [7] (total weight = 7).
Day 3: Load the boat with packages [4, 1, 4] (total weight = 9).
The minimum capacity needed is 9. We can ship all packages within 3 days by distributing the packages as shown above.
 */

import java.util.Arrays;

public class question02 {
    public static int leastWeightCapacity(int weights[], int n, int d)
    {
       int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = (left + right) /2, need =1, curr=0;

            for (int i=0; i<n; i++){
                if (curr + weights[i] > mid) {
                    curr =0;
                    need++;
                }
                curr += weights[i];
            }
            if (need > d)
                left = mid +1;
            else
                right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] weights = { 1, 2, 3, 4, 5, 6, 7 };
        int d =5;
        int n= weights.length;

        System.out.println(leastWeightCapacity(weights, n, d));
    }
}











