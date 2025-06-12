package Trie.easy;

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
}
