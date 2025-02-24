package Recursive.easy;

import java.util.Arrays;

public class Question01 {

    public static void main(String[] args) {
       powerSet("cab");
    }
    static void permuteRec(String str, int n,
                           int index, String curr)
    {
        if (index == n) {
            return;
        }
        System.out.print(curr + " ");
        for (int i=index +1; i<n; i++){
            curr += str.charAt(i);
            permuteRec(str, n, i, curr);
            // backtracking
            curr = curr.substring(0, curr.length() -1);
        }
        return;
    }
    static void powerSet(String str)
    {
        char arr[] = str.toCharArray();
        Arrays.sort(arr);
        permuteRec(new String(arr), str.length(), -1, "");
    }
    public static String deleteConsecutiveStrings(String s)
    {
        String newElement = "";
        int i=0, j=0;
        while (s.length() > j) {
            if (s.charAt(i) == s.charAt(j)){
                j++;
            } else if (s.charAt(j) != s.charAt(i) || j== s.length() -1) {
                newElement += s.charAt(i);
                i =j;
                j++;
            }
        }
        newElement += s.charAt(j-1);
        return newElement;
    }
    public static int numberOfSteps(int num) {
        return  helper(num, 0);
    }
    public static int helper(int num, int step)
    {
        if (num == 0) return step;
        if (num % 2 == 0) {
            return helper(num /2 , step+1);
        }
        return helper(num-1, step+1);
    }
    public static boolean isPowerOfThree(int n) {
        if (n ==0) return false;
        if (n == 1) return true;
        if (n > 1) return n %3 ==0 && isPowerOfThree(n /3);
        else
            return false;
    }
    static boolean isPrime(int n, int i)
    {
        if (n <= 2) {
         return (n ==2) ? true : false;
        }
        if (n % i == 0) return false;
        if (i * i > n) return true;
        return isPrime(n, i+1);
    }
        static int product(int x, int y)
    {
        if (x < y) {
            return product(y, x);
        } else if (y != 0) {
            return (x + product(x, y-1));
        } else
            return 0;
    }
    static int sum_of_digit(int n)
    {
        if (n ==0) return 0;
        return (n % 10 + sum_of_digit(n /10));
    }
        static void insertionSortRecursive(int arr[], int n)
    {
        if (n <=1) return;
        insertionSortRecursive(arr, n-1);
        int last = arr[n-1];
        int j= n-2;
        while (j >= 0 && arr[j] > last){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = last;
    }
        static void bubbleSort(int arr[], int n)
    {
        if (n ==1) return;
        int count =0;
        for (int i=0; i<n -1; i++)
            if (arr[i] > arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                count = count+1;
            }
            if (count ==0) return;
            bubbleSort(arr, n-1);

    }
        static char first(String str, int i)
    {
        if (str.charAt(i) == '\0') return 0;
        if (Character.isUpperCase(str.charAt(i))){
            return str.charAt(i);
        }
        return first(str, i+1);
    }
    public static int findMaxRec(int a[], int n)
    {
        if (n ==1) return a[0];
        return Math.max(a[n-1], findMaxRec(a, n-1));
    }
    public static int findMinRec(int a[], int n)
    {
        if (n ==1) return a[0];
        return Math.min(a[n-1], findMinRec(a, n-1));
    }
    public static void sumofTrangle(int a[])
    {
        // base case
        if (a.length < 1)
            return;
        int temp [] = new int[a.length-1];
        for (int i=0; i<a.length-1; i++){
            int x = a[i] + a[i +1];
            temp[i] = x;
        }
        sumofTrangle(temp);

        System.out.println(Arrays.toString(a));
    }
}
