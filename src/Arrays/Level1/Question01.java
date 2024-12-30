package Arrays.Level1;

import java.util.Arrays;

public class Question01 {

    public static void main(String[] args) {
        int[][] b = { { 8, 2, 13, 4 },
                { 9, 16, 17, 8 },
                { 1, 22, 3, 14 },
                { 15, 6, 17, 8 } };
        diagonalMatrix(b, 4);
    }

    //the Sum of Diagonals of a Matrix
    static void diagonalMatrix(int arr[][], int n)
    {
        int s =0, t=0;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (i == j)
                    s += arr[i][j];

                if ((i+j) == (n-1))
                    t += arr[i][j];
            }
        }
        System.out.println("Diagonal Matrix1 :" + s);
        System.out.println("Diagonal Matrix2 :" + t);
    }
    static void rottenLeft (int arr[], int d, int n)
    {
        int temp []= new int[n];
        int k=0;
        for (int i=d; i<n; i++){
            temp[k] = arr[i];
            k++;
        }
        for (int j=0; j<d; j++){
            temp[k] = arr[j];
            k++;
        }
        for (int i=0; i<n; i++){
            arr[i] = temp[i];
        }
    }
    static void display(int arr[], int n)
    {
        for (int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    static int Normal(int mat[][], int n)
    {
        int s =0;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++)
                s += mat[i][j] * mat[i][j];
        }
        return (int) Math.sqrt(s);
    }
    static int Trace (int mat[][], int n)
    {
        int c =0;
        for (int i=0; i<n; i++){
            c += mat[i][i];
        }
        return c;
    }


    //Find Transpose of Matrix
    static void transpose(int arr[][], int b[][])
    {
        for (int i=0; i<4; i++){
            for (int j=0; j<3; j++)
                b[i][j] = arr[j][i];
        }
    }

    //  Add Two Matrices in Java
    static int[][] addMatrix(int a[][], int b[][], int size)
    {
        int i,j;
        int c [][] = new int[size][size];
        for ( i=0; i<size; i++)
            for ( j=0; j<size; j++)
                c [i][j] = a[i][j] + b[i][j];


        return c;
    }

    //Check if two Arrays are Equal or not
    static void checkEqual(int arr1[], int arr2[])
    {
       // boolean res = Arrays.deepEquals(arr1, arr2);

        if (Arrays.equals(arr1, arr2)){
            System.out.println("Equal");
        } else {
            System.out.println("Not equal");
        }
    }

    //Array Copy in Java
    static void copyArray(int a[])
    {
        int b [] = new int[a.length];

        for (int x : a){
            System.out.print(x + ",");
        }
        b = a;
        b[0]++;
        System.out.println();
        for (int y : b){
            System.out.print(y);
        }
    }

    // print a 2D-array martix
    //  int mat[][] = { { 1, 2, 3, 4 },
    //                        { 5, 6, 7, 8 },
    //                        { 9, 10, 11, 12 } };

    static void print2DArray(int arr[][])
    {
       for (int row=0; row<arr.length; row++){
           for (int col =0; col<arr[0].length; col++){
               System.out.print(arr[row][col]+",");
           }
       }
    }

    // Java Program to Find Largest Element in an Array
    //  Input : arr[] = {20, 10, 20, 4, 100}
    //Output : 100
    
    static int findLargest(int arr[], int n)
    {
        if (n <0) return -1;
        int max = 0;
        for (int i=0; i<n; i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }
    static void printMatrix(int M[][],int rowSize,int colSize)
    {
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++)
                System.out.print(M[i][j] + " ");

            System.out.println();
        }
    }

}
