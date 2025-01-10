package Arrays.Level1;

import java.util.Arrays;
import java.util.Collections;

public class Question03 {

    public static void main(String[] args) {
        Integer a[] = { 2, 3, 4, 10, 40 };
        descendingOrder(a);
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

}
