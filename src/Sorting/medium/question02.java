package Sorting.medium;
import java.util.*;

public class question02 {

    public static void main(String[] args) {
        String[] arr = {"act", "god", "cat", "dog", "tac"};
        ArrayList<ArrayList<String>> res = angram(arr);
        for (List<String> group: res){
            for (String result : group)
                System.out.print(result + " ");
            System.out.println();
        }
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
}
