package InterviewsQuestions.Atlassian;

/*
    Majority Element
    Given an array arr[], return the element that appears more than n / 2 times,
    where n is the array size. If no such element exists, return -1.
    Input: arr[] = [1, 1, 2, 1, 3, 5, 1]
    Output: 1
    Explanation: Element 1 appears 4 times, which is more than

 */

public class question03 {
    public static int majorityElement(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; i++){
            int count =0;
            for (int j=0; j<n; j++){
                if (arr[i] == arr[j])
                    count++;
                if (count > n/2){
                    return arr[i];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 1, 3, 5, 1};
        System.out.println(majorityElement(arr));
    }
}
