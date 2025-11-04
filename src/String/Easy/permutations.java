package String.Easy;

import java.util.ArrayList;

public class permutations {
    public static void main(String[] args) {
       // permutations("", "abc");
//        ArrayList<String> ans = permutationsList("", "abc");
//        System.out.println(ans);
     //   System.out.println(permutationsCount("", "abc"));
     //   pad("", "12");
     //   System.out.println(padRet("", "12"));
        dice("", 4);
    }
    static void dice(String p,int target)
    {
        if (target ==0){
            System.out.println(p);
            return;
        }
        for (int i=1; i<=6 && i<= target; i++){
            dice(p+i, target-i);
        }
    }
    static ArrayList<String> padRet(String p, String up)
    {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        int digit = up.charAt(0) - '0';
        for (int i=(digit -1) *3; i<digit *3; i++){
            char ch = (char) ('a' + i);
            list.addAll(padRet(p +ch, up.substring(1)));
        }
       return   list;
    }
    static void pad(String p, String up)
    {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0'; //this will convert '2' into 2
        for (int i= (digit-1) *3; i<digit *3; i++){
            char ch = (char) ('a' + i);
            pad(p+ch, up.substring(1));
        }
    }
    static int permutationsCount(String p, String up)
    {
        if (up.isEmpty()) {
            return 1;
        }
        int count =0;
        char ch = up.charAt(0);
        for (int i=0; i<=p.length(); i++){
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            count = count + permutationsCount(f + ch+ s, up.substring(1));
        }
        return count;
    }
    static ArrayList<String> permutationsList(String p, String up)
    {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        char ch = up.charAt(0);
        for (int i=0; i<= p.length(); i++){
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            ans.addAll(permutationsList(f+ch+s, up.substring(1)));
        }
        return ans;
    }
    static void permutations(String p, String up)
    {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i=0; i<=p.length(); i++){
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            permutations(f+ch+s, up.substring(1));
        }

    }
}
