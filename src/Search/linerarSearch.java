package Search;

import java.util.Arrays;

public class linerarSearch {
    public static void main(String[] args) {
       int arr[] = {50,3,2, 1, 5, 7};
      int arr2[][] = {{1, 2, 3}, {5, 6, 8}, {33, 22, 55}};
      int ans[] = serch2dArray(arr2, 99);
      //int result []= maxValue2dArray(arr2);
        System.out.println(maxValue2dArray(arr2));
      //  System.out.println(Arrays.toString(ans));
    }
    static boolean search(String str, char target)
    {
        if (str.length() == 0){
            return false;
        }
        for (char ele : str.toCharArray()){
            if (ele == target) {
                return true;
            }
        }
        return false;
    }
    static int lineraSearch(int arr[], int target, int start, int end)
    {
        if (arr.length == 0) {
            return 0;
        }
        for (int index =start; index<=end; index++){
            int element = arr[index];
            if (element == target) {
                return index;
            }
        }
        return -1;
    }
    static int minNumber(int arr[])
    {
        if (arr.length == 0) {
            return 0;
        }
        int ans = arr[0];
        for (int i=1; i<arr.length; i++){
            if (ans > arr[i]){
               ans = arr[i];
            }
        }
        return ans;
    }
    static int[] serch2dArray(int arr[][], int target)
    {
        int m = arr.length;
        int n = arr[0].length;
        for (int i=0; i<m; i++){
            for (int col =0; col<n; col++){
                if (arr[i][col] == target) {
                    return new int[] {i, col};
                }
            }
        }
        return new int[0];
    }
    static int maxValue2dArray(int arr[][])
    {
        int max = Integer.MIN_VALUE;
        for (int row =0; row<arr.length; row++){
            for (int col =0; col < arr[0].length; col++){
                if (arr[row][col] > max) {
                    max = arr[row][col];
                }
            }
        }
        return max;
    }
}
