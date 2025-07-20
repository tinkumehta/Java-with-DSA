package Sorting.medium;

import java.util.*;

public class question01 {

    public static void main(String[] args) {
        int[] arr = { 1, 4, 45, 6, 10, 8 };
        if (hasTripletSum(arr, 13)){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }
    static boolean hasTripletSum(int[] arr, int target)
    {
        int n = arr.length;
        for (int i=0; i< n-2; i++){
            Set<Integer> st = new HashSet<>();
            for (int j=i+1; j<n; j++){
                int sum = target- arr[i] - arr[j]  ;
            if (st.contains(sum)){
                return true;
            }
            st.add(arr[j]);
            }
        }
        return false;
    }
    public static void mergeArrays(int a[], int b[])
    {
        int i = a.length-1;
        int j=0;
        while (i >= 0 && j < b.length) {
            if (a[i] <b[j]){
                i--;
            } else {
                int temp = b[j];
                b[j] = a[i];
                a[i] = temp;
                i--;
                j++;
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }
}
