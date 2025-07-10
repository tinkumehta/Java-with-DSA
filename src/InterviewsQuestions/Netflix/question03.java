package InterviewsQuestions.Netflix;

 /*
  Find the row with maximum number of 1s
  Given a binary 2D array, where each row is sorted. Find the row with the maximum number of 1s.

Examples:

Input matrix : 0 1 1 1
                        0 0 1 1
                        1 1 1 1
                        0 0 0 0
Output: 2
Explanation: Row = 2 has maximum number of 1s, that is 4.

Input matrix : 0 0 1 1
                        0 1 1 1
                        0 0 1 1
                        0 0 0 0
Output: 1
Explanation: Row = 1 has maximum number of 1s, that is 3.
  */

public class question03 {
    static int findMaximumRow(int mat[][], int R, int C)
    {
        int max_Index_row =0, max_Ones=0;
        boolean flag = true;
        for (int i=0; i<R; i++){
            int count=0;
            for (int j=0; j<C; j++){
                if (mat[i][j] == 1) {
                    count++;
                    flag = false;
                }
                if (count > max_Ones) {
                    max_Ones = count;
                    max_Index_row = i;
                }
            }
        }
        if (flag) {
            return -1;
        }
        return max_Index_row;
    }

    public static void main(String[] args) {
        int mat[][] = { {0, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}};
        System.out.println(findMaximumRow(mat, 4, 4));
    }
}









