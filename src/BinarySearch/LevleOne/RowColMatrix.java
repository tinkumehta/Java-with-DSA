package BinarySearch.LevleOne;

import java.util.Arrays;

public class RowColMatrix {
    public static void main(String[] args) {
        int arr[][] = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 50, 60}
        };
        System.out.println(Arrays.toString(search(arr, 25 )));
    }
    static int[] search (int [][] matrix, int target)
    {
        int r=0;
        int c = matrix.length-1;
        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] == target) {
                return new int[]{r, c};
            }
            if (matrix[r][c] < target){
                r++;
            } else {
                c--;
            }
        }
        return new int[] {-1, -1};
    }
    static int[] binarySearch(int [][] matrix , int row, int cStart, int cEnd, int target)
    {
        while (cStart <= cEnd) {
            int mid = cStart + (cEnd - cStart)/2;
            if (matrix[row][mid] == target){
                return new int[] {row, mid};
            }
            if (matrix[row][mid] < target) {
                cStart = mid +1;
            } else  {
                cEnd = mid-1;
            }
        }
        return new int[]{-1, -1};
    }
}
