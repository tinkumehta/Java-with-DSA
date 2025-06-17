package Trie.easy;

import java.util.Arrays;

public class UnioueFind {

    public static void main(String[] args) {
        int M[][] = { { 0, 1, 0, 0, 1 },
                { 1, 0, 1, 1, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 1, 0, 0 } };
        findUniqueRows(M);
    }
    static int Row = 4;
    static int Col = 5;

    static void findUniqueRows(int M[][])
    {
        for (int i=0; i<Row; i++){
            int flag =0;
            for (int j=0; j<i; j++){
                flag =1;
                for (int k=0; k<Col; k++)
                    if (M[i][k] != M[j][k])
                        flag =0;
                if (flag == 1)
                    break;

            }
            if (flag == 0) {
                for (int j=0; j<Col; j++)
                    System.out.print(M[i][j] + " ");
                System.out.println();
            }
        }
    }
    public static String longestCommonPrefix(String[] v)
    {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(v);
        String first = v[0];
        String last = v[v.length -1];
        for (int i=0; i<Math.min(first.length(), last.length()); i++){
            if (first.charAt(i) != last.charAt(i))
                return ans.toString();
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }
}
