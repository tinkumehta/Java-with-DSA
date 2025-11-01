package Arrays.Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Question03 {

    public static void main(String[] args) {
        int a[] = { 2,4, 3, 4, 10,5, 40 };
      //  descendingOrder(a);
      //  System.out.println(sorted(a, 0));
       // System.out.println(find(a, 0, 5));
     //   System.out.println(findIndex(a, 0, 2));
        findAllIndex(a, 4, 0);
        System.out.println(list);
    }

    static ArrayList<Integer> list = new ArrayList<>();
    static void findAllIndex(int arr[], int target, int index)
    {
        if (index == arr.length) {
            return;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        findAllIndex(arr, target, index+1);
    }
    static boolean find(int arr[], int index , int target)
    {
        if (index == arr.length) {
            return false;
        }
        return arr[index] == target || find(arr, index+1, target);
    }
    static int findIndex(int arr[], int index, int target)
    {
        if (index == arr.length) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        }else {
            return findIndex(arr, index+1, target);
        }
    }
    //Java Program to Sort the Elements of an Array in Descending Order
    static void descendingOrder(Integer a[])
    {
        Arrays.sort(a, Collections.reverseOrder());
        System.out.println(Arrays.toString(a));

    }
    //Methods for Java Binary Search
    static int binarySearch(int arr[], int l, int h, int x)
    {
        while (l <= h) {
            int mid = (l+h)/2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                h = mid -1;
            } else {
                l = mid +1;
            }
        }
        return -1;
    }
    static boolean sorted(int arr[], int index)
    {
        if (index == arr.length - 1) {
            return true;
        }
        return arr[index] < arr[index+1] && sorted(arr, index+1);
    }

}
