package Sorting.easy;

import java.util.Arrays;

public class rec {
    public static void main(String[] args) {
        int arr[]= {5, 4, 3, 2,1};
//
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void sort(int []nums, int low,int hi)
    {
        if (low >= hi) return;
        int s = low;
        int e = hi;
        int mid = s + (e - s)/2;
        int pivot = nums[mid];
        while (s <= e) {
            while (nums[s] < nums[pivot]){
                s++;
            }
            while (nums[e] > pivot) {
                e--;
            }
            if (s <= e) {
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }
        // now my pivot is at correct index, please sort two halves now
        sort(nums, low, e);
        sort(nums, s, hi);
    }
    static int [] mergeSort(int arr[])
    {
        if (arr.length == 1){
            return arr;
        }
        int mid = arr.length /2;

        int left[] = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int right[] = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right)
    {
        int mix[] = new int[left.length + right.length];
        int i=0, j=0, k=0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]){
                mix[k] = left[i];
                i++;
            } else {
                mix[k] = right[j];
                j++;
            }
            k++;
        }

        // it may be possible that one of the arrays is not complete
        while (i < left.length) {
            mix[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            mix[k] = right[j];
            j++;
            k++;
        }
        return mix;
    }

    static void bubbleSort(int arr[], int r, int c)
    {
        if (r == 0) {
            return;
        }
        if (c < r) {
            if (arr[c] > arr[c+1]){
                // swap
                int temp = arr[c];
                arr[c] = arr[c+1];
                arr[c+1] = temp;
            }
            bubbleSort(arr, r, c+1);
        } else {
            bubbleSort(arr, r-1, 0);
        }
    }
}
