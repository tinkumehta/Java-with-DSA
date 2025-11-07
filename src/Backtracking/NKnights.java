package Backtracking;

public class NKnights {
    public static void main(String[] args) {
        int n = 4;
        boolean board[][] = new boolean[n][n];
      //  knight(board, 0, 0, 4);
        int [][] board1 = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
       // System.out.println(solve(board1));
        if (solve(board1)){
            display01(board1);
        } else {
            System.out.println("Can not'solve");
        }
    }
    static boolean solve(int board[][])
    {
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyLeft = true;
        for (int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            // if you found some one empty element in row, than break
            if (emptyLeft == false) {
                break;
            }
        }
            if (emptyLeft == true) {
                return true;
                // soduko is solved
            }

            // backtrack
            for (int number=1; number <=9; number++){
                if (isSafe(board, row, col, number)){
                    board[row][col] = number;
                    if (solve(board)){
                        // found the answer

                        return true;
                    } else {
                        // backtrack
                        board[row][col] = 0;
                    }
                }
            }
            return false;

    }

    private static void display01(int[][] board)
    {
        for (int row[]: board){
            for (int col : row){
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }

    static boolean isSafe(int [][]board, int row, int col, int num)
    {
        // check row
        for (int i=0; i<board.length; i++){
            // check if number is in the row
            if (board[row][col] == num) {
                return false;
            }
        }
        // check the col
        for (int [] nums: board){
            if (nums[col] == num){
                return false;
            }
        }
        int sqrt = (int) (Math.sqrt(board.length));
        int rowStart = row - row % sqrt;
        int colStart = col - col %sqrt;

        for (int r= rowStart; r<rowStart + sqrt; r++){
            for (int c = colStart; c< colStart +sqrt; c++){
                if (board[r][c] == num){
                    return false;
                }
            }
        }
        return true;
    }
    static void knight(boolean [][] board, int row, int col, int knights)
    {
        if (knights == 0) {
            display(board);
            System.out.println();
            return;
        }
        if (row == board.length - 1 && col == board.length) {
            return;
        }
        if (col == board.length) {
            knight(board, row+1, 0, knights);
            return;
        }
        if (isSafe(board, row, col)){
            board[row][col] = true;
            knight(board, row, col+1, knights-1);
            board[row][col] = false;
        }
        knight(board, row, col+1, knights);
    }
    private static boolean isSafe(boolean board[][], int row, int col)
    {
        if (isValid(board, row-2, col-1)){
            if (board[row-2][col-1]){
                return false;
            }
        }
        if (isValid(board, row-1, col-2)){
            if (board[row-1][col-2]){
                return false;
            }
        }if (isValid(board, row-2, col+1)){
            if (board[row-2][col+1]){
                return false;
            }
        }if (isValid(board, row-1, col+2)){
            if (board[row-1][col+2]){
                return false;
            }
        }
        return true;
    }
    static boolean isValid(boolean [][] board, int row, int col)
    {
        if (row >=0 && col >=0 && row < board.length && col >= 0 && col < board[0].length){
            return true;
        }
        return false;
    }
    private static void display(boolean board[][])
    {
        for (boolean row[]: board){
            for (boolean ele : row){
                if (ele) {
                    System.out.print("K ");

                }else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
