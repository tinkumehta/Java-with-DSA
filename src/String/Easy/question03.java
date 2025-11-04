package String.Easy;

import OOPS.Polymorphism.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class question03 {
    public static void main(String[] args) {
        int arr[]= {1, 2,2};
        List<List<Integer>> ans = subsetDuplicate(arr);
        for (List<Integer> list : ans){
            System.out.println(list);
        }
//        int arr[]= {1, 2,3};
//        List<List<Integer>> ans = subset(arr);
//        for (List<Integer> list : ans){
//            System.out.println(list);
//        }
    }
    static List<List<Integer>> subsetDuplicate(int arr[])
    {
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start =0, end =0;

        for (int i=0; i<arr.length; i++){
            start =0;
            // if current and previous element is same, s= e+1
            if (i >0 && arr[i] == arr[i-1]){
                start = end-1;
            }
            end = outer.size()-1;
            int n  = outer.size();
            for (int j=start; j<n; j++){
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }
    // debuge
    static List<List<Integer>> subset(int arr[])
    {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for (int num : arr){
            int n = outer.size();
            for (int i=0; i<n; i++){
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }
    static void subseqAscii(String p, String up)
    {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subseqAscii(p+ch, up.substring(1));
        subseqAscii(p, up.substring(1));
        subseqAscii(p+(ch+0), up.substring(1));
    }
    static ArrayList<String> subseqRet(String p, String up)
    {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subseqRet(p +ch, up.substring(1));
        ArrayList<String> right = subseqRet(p, up.substring(1));

        left.addAll(right);
        return left;
    }
    static void subseq(String p, String up)
    {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subseq(p+ch, up.substring(1));
        subseq(p, up.substring(1));
    }
    public static String  skip( String up)
    {
        if (up.isEmpty()) {
          //  System.out.println(p);
            return "";
        }
        char ch = up.charAt(0);
        if (ch == 'a'){
          return   skip(up.substring(1));
        } else {
          return  ch+ skip(up.substring(1));
        }
    }
    public static String  skipApple( String up)
    {
        if (up.isEmpty()) {
          //  System.out.println(p);
            return "";
        }

        if (up.startsWith("app") && !up.startsWith("apple")){
          return   skipApple(up.substring(3));
        } else {
          return  up.charAt(0) + skipApple(up.substring(1));
        }
    }
}
