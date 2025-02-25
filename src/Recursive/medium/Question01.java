package Recursive.medium;

public class Question01 {

    public static void main(String[] args) {
      int num[] = {1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays(num, 3));
    }
    public static int findTargetSumWays(int[] nums, int target)
    {
        return helper(nums, 0, 0, target);
    }
    static int helper(int nums[], int index, int currSum, int target)
    {
        if (index == nums.length) {
            if (currSum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        int left = helper(nums, index +1, currSum + nums[index], target);
        int right = helper(nums, index +1, currSum - nums[index], target);
        return left + right;
    }
    public static boolean exist(char[][] board, String word) {
        for (int i=0; i< board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if (board[i][j] == word.charAt(0)){
                    boolean ans = search(board, word, i, j, 0);
                    if (ans){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean search (char maze[][], String word, int row, int col, int idx)
    {
        if (idx == word.length()) return true;
        if (row < 0 || col < 0 || maze.length <= row
                || maze[0].length <= col || maze[row][col] != word.charAt(idx)){
            return false;
        }
        maze[row][col] ='*';
        int r[] = {-1, 1, 0, 0};
        int c[]= {0, 0, -1, 1};
        for (int i=0; i<c.length; i++){
            boolean ans = search(maze, word, row +r[i], col +c[i], idx +1);
            if (ans) return true;
        }
        maze[row][col] = word.charAt(idx);
        return false;
    }
}
