package Sorting.medium;
import java.util.*;

public class question02 {

    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1, 0, 1, 1};

        System.out.println(maxLen(arr));
    }
    static final int MAX_CHAR = 26;
    static String getHash(String s)
    {
        int freq[] = new int[MAX_CHAR];
        StringBuilder res = new StringBuilder();
        for (char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
        for (int i=0; i<MAX_CHAR; i++){
            res.append(freq[i]);
            res.append("$");
        }
        return res.toString();
    }
    static ArrayList<ArrayList<String>> angram (String arr[])
    {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++){
            String key = getHash(arr[i]);
            if (!map.containsKey(key)){
                map.put(key, res.size());
                res.add(new ArrayList<>());
            }
            res.get(map.get(key)).add(arr[i]);
        }
        return res;
    }
    static int maxLen(int arr[])
    {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int prevSum =0, res =0;
        for (int i=0; i<arr.length; i++){
            prevSum += (arr[i] == 0) ? -1 : 1;
            if (prevSum == 0)
                res = i+1;
            if (mp.containsKey(prevSum))
                res = Math.max(res, i - mp.get(prevSum));
            else
                mp.put(prevSum, i);
        }
        return res;
    }
}
