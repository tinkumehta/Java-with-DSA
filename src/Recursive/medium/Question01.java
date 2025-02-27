package Recursive.medium;
import java.util.*;
public class Question01 {

    public static void main(String[] args) {

    }
    static List<String> res = null;
     static String [] strMap = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits.length() ==0){
            return res;
        }
        dfs(0, digits, new StringBuilder());
        return res;
    }
    static void dfs(int length, String digits, StringBuilder str)
    {
        if (digits.length() == length) {
            res.add(str.toString());
            return;
        }
        char ch = digits.charAt(length);
        String str1 = strMap[ch - '0'];
        for (char c : str1.toCharArray()){
            str.append(c);
            dfs(length +1, digits, str);
            str.deleteCharAt(str.length()-1);
        }
    }
    public static List<Integer> diffWaysToCompute(String expression)
    {
        return helper(expression);
    }
    static List<Integer> helper(String exp)
    {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0; i<exp.length(); i++){
            char charAt = exp.charAt(i);
            if (charAt == '+' || charAt == '-' || charAt == '*'){
                List<Integer> left = helper(exp.substring(0, i));
                List<Integer> right = helper(exp.substring(i+1));
                for (int l : left){
                    for (int r : right){
                        if (charAt == '+'){
                            result.add(l +r);
                        } else if (charAt == '-') {
                            result.add(l- r);
                        } else {
                            result.add(l *r);
                        }
                    }
                }
            }
        }
        if (result.isEmpty()) {
            result.add(Integer.parseInt(exp));
        }
        return result;
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
