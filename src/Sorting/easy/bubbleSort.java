package Sorting.easy;

import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int arr[] = {1, 2, 9, 8, 7, 25, 20};
        //bubble(arr);
        selection(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void bubble(int arr[])
    {
        boolean swapped = false;
        for (int i=0; i<arr.length; i++){
            // for each step, max item will come at the last respective index
            for (int j=1; j< arr.length-i; j++){

                if (arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
    static void swap(int arr[], int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    static void selection(int arr[])
    {
        for (int i=0; i<arr.length; i++){
            // find the max item in the remaining array and swap with correct index
            int last = arr.length -i-1;
            int maxIndex = getMaxIndex(arr, 0, last);
            swap(arr, maxIndex, last);
        }
    }
    static int getMaxIndex (int arr[], int start, int end)
    {
        int max = start;
        for (int i=start; i<= end; i++){
            if (arr[max] < arr[i]){
                max = i;
            }
        }
        return max;
    }
}
