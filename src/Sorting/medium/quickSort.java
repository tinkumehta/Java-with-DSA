package Sorting.medium;

import java.util.Arrays;

public class quickSort {

    public static void main(String[] args) {
        int[] arr = {7, 3, 2, 4, 9, 12, 56};
        int m = 3;
        System.out.println(findMinDiff(arr, m));
    }
    static int findMinDiff(int[] arr, int m)
    {
        int n = arr.length;
        Arrays.sort(arr);
        int maxDiff = Integer.MAX_VALUE;
        for (int i=0; i + m-1 <n; i++){
            int diff = arr[i + m-1]- arr[i];
            if (diff < maxDiff) {
                maxDiff = diff;
            }
        }
        return maxDiff;
    }
    static int findFloor(int arr[], int x)
    {
        int low =0;
        int high = arr.length-1;
        int result =-1;

        while (low < high) {
            int mid = low + (high -low) /2;
            if (arr[mid] <= x) {
                result = mid;
                low = mid +1;
            }else {
                high = mid -1;
            }
        }
        return result;
    }
    static void quickSort(int arr[], int low, int high)
    {
        if (low < high){
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi -1);
            quickSort(arr, pi +1, high);
        }
    }
    static int partition(int[] arr, int low, int high)
    {
        int pivate = arr[high];
        int i = low -1;
        for (int j=low; j<= high-1; j++){
            if (arr[j] < pivate) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }
    static void swap(int arr[], int i, int j)
    {
        int temp= arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
