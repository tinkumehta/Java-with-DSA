package InterviewsQuestions.Netflix;

/*
    A Boolean Matrix Question
    Given a boolean matrix mat where each cell contains either 0 or 1,
    the task is to modify it such that if a matrix cell matrix[i][j] is 1
    then all the cells in its ith row and jth column will become 1.

    Input: [[1, 0],
           [0, 0]]
Output: [[1, 1],
              [1, 0]]

Input: [[1, 0, 0, 1],
           [0, 0, 1, 0],
          [0, 0, 0, 0]]
Output: [[1, 1, 1, 1],
               [1, 1, 1, 1],
              [1, 0, 1, 1]]
 */

public class question01 {
    static void booleanMatrix( int mat[][])
    {
        int row = mat.length;
        int col = mat[0].length;
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (mat[i][j] == 1){

                    for (int idx =0; idx<row; idx++) {
                        if (mat[idx][j] == 0) {
                            mat[idx][j] = -1;
                        }
                    }
                    for (int idx=0; idx<col; idx++) {
                        if (mat[i][idx] == 0) {
                            mat[i][idx] = -1;
                        }
                    }
                }
            }
        }
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (mat[i][j] == -1)
                    mat[i][j] = 1;
            }
        }
    }

    public static void main(String[] args) {
        int mat[][] = {{1, 0, 0, 1}, {0, 0, 1, 0}, {0, 0, 0, 0}};
        booleanMatrix(mat);
        for (int row[] : mat){
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }

    }
}
