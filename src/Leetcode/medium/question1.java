package Leetcode.medium;

public class question1 {
    public static void main(String[] args) {
        int nums[] = {1,3 , 4, 2, 2};
        System.out.println(findDuplicate(nums));
    }
    // leetcode 287
    public static int findDuplicate(int[] nums) {
        int i=0;
        while (i < nums.length) {
            if (nums[i] != i+1){
                int correct = nums[i]-1;
                if (nums[i] != nums[correct]){
                    swap(nums, i, correct);
                } else {
                    return nums[i];
                }
            }else {
                i++;
            }
        }
        return -1;
    }
    public static void swap(int arr[], int start, int end)
    {
        int temp = arr[start];
        arr[start]= arr[end];
        arr[end]= temp;
    }
}
