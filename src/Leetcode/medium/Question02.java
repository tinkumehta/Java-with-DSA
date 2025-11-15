package Leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question02 {
    public static void main(String[] args) {
        int num[] = {3,3 ,3, 3};
        System.out.println(findDuplate(num));
    }
    // leetcode 287
    public static int findDuplate(int num[])
    {
        int i=0;
        while (i < num.length - 1) {
            int correct = num[i]-1;
            if (num[i] != num[correct]){
                swap(num, i, correct);
            } else {
                i++;
            }
        }
        for (int index =0; index<num.length; index++){
            if (num[index] != index+1){
                return num[index];
            }
        }
        return -1;
    }
    // leetcode 448
    public static List<Integer> findDissparedArray(int nums[])
    {
        int i=0;
        while (i < nums.length-1){
            int correct = nums[i]-1;
            if (nums[i] != nums[correct]){
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int index=0; index<nums.length; index++){
            if (nums[index] != index+1){
                list.add(index+1);
            }
        }
        return list;
    }
    // leetcode 189
    static void rotatedArray(int num[], int k)
    {
        int n = num.length;
        int rotated = k%n;
        swap01(num, 0, n-1);
        swap01(num, 0, rotated-1);
        swap01(num, rotated, n-1);
    }
    static void swap(int num[], int start, int end)
    {
        int temp = num[start];
        num[start] = num[end];
        num[end] = temp;
        start++;
        end--;
    }
    static void swap01(int num[], int start, int end)
    {
        int temp = num[start];
        num[start] = num[end];
        num[end] = temp;
        start++;
        end--;
    }
}
