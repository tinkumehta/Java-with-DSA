package Sorting.easy;

import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int arr[] = {1, 2, 9, 8, 7, 25, 20, 5, 16, -99};
        int arr1[] = {3, 5, 2, 1, 4};
        //bubble(arr);
       // selection(arr);
       // insertion(arr);
        cycleSort(arr1);
        System.out.println(Arrays.toString(arr1));
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
    static void insertion(int arr[])
    {
        for (int i=0; i<arr.length-1; i++){
            for (int j=i+1; j> 0; j--){
               if (arr[j] < arr[j-1]){
                   swap(arr, j, j-1);
               } else {
                   break;
               }
            }
        }
    }
    static void cycleSort(int arr[])
    {
        int i=0;
        while (i < arr.length) {
            int correct = arr[i] -1;
            if (arr[i] != arr[correct]){
                swap(arr, i, correct);
            }else {
                i++;
            }
        }
    }
}
