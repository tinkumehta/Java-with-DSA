package Arrays.Level1;

import java.util.*;

public class Question02 {

    public static void main(String[] args) {
        int a[] = { 64, 25, 12, 22, 11 };
        selectionSort(a);
        for (int i=0; i<a.length; i++){
            System.out.print(a[i] + " ");
        }
    }

    //Program to Implement Selection Sort Java
    static void selectionSort(int a[])
    {
        int n = a.length;
        for (int i=0; i<n; i++){
            int min_index =i;
            for (int j=i+1; j<n; j++){
                if (a[j] < a[min_index])
                    min_index = j;
            }
            int temp = a[min_index];
            a[min_index] = a[i];
            a[i] = temp;
        }
    }
    // Interchange Elements of First and Last in a Matrix Across Columns
    static int N =4;
     static void swap_first_last(int matrix[][])
     {
             for (int j=0; j<N; j++){
                 int temp = matrix[j][0];
                 matrix[j][0] = matrix[j][N-1];
                 matrix[j][N-1] = temp;
             }

     }
     // Java Program to Interchange Elements of First
    // and Last Row in a Matrix
    static void swap_Matrix(int mat[][])
    {
        int row = mat.length;
        for (int j=0; j<mat[0].length; j++){
            // swap
            int temp = mat[0][j];
            mat[0][j] = mat[row-1][j];
            mat[row -1][j] = temp;
        }
    }
    // Find the Common Elements Between Arrays
     static void commonElements(String arr1[], String arr2[])
     {
         Set<String> st = new HashSet<>();
         for (int i=0; i<arr1.length; i++){
             for (int j=0; j<arr2.length; j++){
                 if (arr1[i].equals(arr2[j])){
                     st.add(arr1[i]);
                     break;
                 }
             }
         }
         System.out.println(st.toString());
     }
    //Remove all occurrences of an element from Array
     static int [] removeOccurrences(int a[], int k)
     {
         int index =0;
         for (int i=1; i<a.length; i++){
             if (a[i] != k){
                 a[index++] = a[i];
             }
         }
        return Arrays.copyOf(a, index);
     }
    //Remove duplicates from Sorted Array
    static int removeDuplicates(int arr[])
    {
        int n = arr.length;
        if (n <=1) return n;
        int idx =1;
        for (int i=1; i<n; i++){
            if (arr[i] != arr[i-1]){
                arr[idx++] = arr[i];
            }
        }
        return idx;
    }
    //Boundary Elements of the Matrix
    static void boundaryMatrix(int mat[][])
    {
        for (int i=0; i<mat.length; i++){
            for (int j=0; j<mat[i].length; j++){
                if (i ==0 || i== mat.length-1 || j==0 || j ==mat[i].length-1){
                    System.out.print(mat[i][j] );
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}
