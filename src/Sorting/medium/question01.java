package Sorting.medium;

import java.util.*;

public class question01 {

    public static void main(String[] args) {
        System.out.println(firstNonRepeating("aabc"));
    }
    public static String firstNonRepeating(String s)
    {
        int n = s.length();
        StringBuilder res = new StringBuilder();
        Map<Character, Integer> freq = new HashMap<>();
        for (int i=0; i<n; i++){
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i) ,0) +1);
            boolean found = false;
            for (int j=0; j<=i; j++) {
                if (freq.get(s.charAt(j)) == 1) {
                    res.append(s.charAt(j));
                    found = true;
                    break;
                }
            }
            if (!found){
                res.append("#");
            }
        }
        return res.toString();
    }

    //Time complexity: O(n * log n)
    //Auxiliary Space: O(1)
    static ArrayList<Integer> kLargest(int[] arr, int k)
    {
        int n = arr.length;
        Integer arrInteger [] = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(arrInteger, Collections.reverseOrder());
        ArrayList<Integer> res = new ArrayList<>();
        for (int i=0; i<k; i++){
            res.add(arrInteger[i]);
        }
        return res;
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
