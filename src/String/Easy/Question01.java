package String.Easy;
import java.util.*;

public class Question01 {
    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }
    public static String convertToTitle(int columnNumber)
    {
        StringBuilder str = new StringBuilder();
        while (columnNumber > 0) {
            int index = (columnNumber -1) % 26;
            str.insert(0, (char) ('A' + index));
            columnNumber = (columnNumber -1) / 26;
        }
        return str.toString();
    }
    public static String reverseWords(String s)
    {
        String str []= s.split(" ");
        int n = str.length;
        StringBuilder st = new StringBuilder("");
        for (int i=0; i<n; i++){
            StringBuilder x = new StringBuilder(str[i]);
            st.append(reverse(x));
            if (i != n-1)
                st.append(" ");
        }
        return st.toString();
    }
    public static String reverse(StringBuilder x)
    {
        return x.reverse().toString();
    }
    public static boolean judgeCircle(String moves)
    {
        int count [] = new int[128];
        for (char ch :  moves.toCharArray()){
            count[ch]++;
        }
        return count['U'] == count['D'] && count['L'] == count['R'];
    }
    public static int numOfStrings(String[] patterns, String word)
    {
        int count =0;
        for (String res : patterns){
            int index = word.indexOf(res);
            if (index != -1) {
                count++;
            }
        }
        return count;
    }
    public static boolean halvesAreAlike(String s)
    {
        int count =0;
        int count1 =0;
        for (int i=0; i<s.length()/2; i++){
            if (isVowel(s.charAt(i))){
                count++;
            }
        }
        for (int j=s.length()/2; j<s.length(); j++){
            if (isVowel(s.charAt(j))){
                count1++;
            }
        }
        if (count == count1) {
            return true;
        }
        return false;
    }
    public static boolean isVowel(char s)
    {
        if (s == 'a' || s== 'e' || s == 'i' || s == 'o' || s == 'u'
                || s == 'A' || s == 'E' || s == 'I' || s == 'O' || s== 'U'){
            return true;
        }
        return false;
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
