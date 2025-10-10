import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       int nums []= {1, 2, 3,15, 4, 5, 6, 7};
        System.out.println(maxRange(nums, 1, nums.length-1));
       // System.out.println(linearSearch3(nums, -9));
    }
    static int maxRange(int nums[], int start, int end)
    {
        int maxVal = nums[start];
        for (int i = 0; i <= end; i++) {
            if(nums[i] > maxVal){
                maxVal = nums[i];

            }
        }
        return maxVal;
    }
    static boolean linearSearch3(int arr[], int target){
        if (arr.length ==0){
            return false;
        }
        for(int element : arr){
            if (element == target) {
                return true;
            }
        }
        return false;
    }
}
