package String.Easy;
import java.util.*;

public class Question01 {
    public static void main(String[] args) {
        String str [] = {"ab", "c"};
        String str1 [] = {"a", "bc"};
        System.out.println(arrayStringsAreEqual(str, str1));
    }
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2)
    {
        String str = "", str1 ="";
        for (String s : word1){
            str += s;
        }
        for (String t  : word2){
            str1 += t;
        }
        return str.equals(str1);
    }
    public static int countMatches(List<List<String>> items,
                            String ruleKey, String ruleValue)
    {
        int count =0;
        for (int i=0; i<items.size(); i++){
            switch (ruleKey){
                case  "type":
                    if (items.get(i).get(0).equals(ruleValue))
                        count++;
                    break;
                case "color":
                    if (items.get(i).get(1).equals(ruleValue))
                        count++;
                    break;
                case "name":
                    if (items.get(i).get(2).equals(ruleValue))
                        count++;
                    break;
            }
        }
        return count;
    }
    public static String interpret(String command)
    {
        return command.replace("()", "o")
                .replace("(al)", "al");
    }
    public static String restoreString(String s, int[] indices)
    {
        char charr [] = s.toCharArray();
        for (int i=0; i<indices.length; i++){
            charr[indices[i]] = s.charAt(i);
        }
        return new String(charr);
    }
}
