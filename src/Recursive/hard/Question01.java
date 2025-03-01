package Recursive.hard;
import  java.util.*;

public class Question01 {
    public static void main(String[] args) {
        int grid [][] = {{0,6,0},{5,8,7},{0,9,0}};
        System.out.println(getMaximumGold(grid));
    }
    private static int maxGold;
    public static int getMaximumGold(int[][] grid)
    {
        maxGold =0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (grid[i][j] > 0){
                    dfs(grid, i, j, 0);
                }
            }
        }
        return maxGold;
    }
    static void dfs(int [][] grid, int row, int col, int currentGold)
    {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
            return;
        }
        currentGold += grid[row][col];
        maxGold = Math.max(maxGold, currentGold);
        int temp  = grid[row][col];
        grid[row][col] = 0;
        // check up, down , left, right
        dfs(grid, row -1, col, currentGold);
        dfs(grid, row +1, col, currentGold);
        dfs(grid, row , col-1, currentGold);
        dfs(grid, row , col+1, currentGold);
        grid[row][col] = temp;
    }
    static void sortStack(Stack<Integer> st)
    {
        if (st.isEmpty()) {
            return;
        }
        int top = st.pop();
        sortStack(st);
        Stack<Integer> temp = new Stack<>();
        while (!st.isEmpty() && st.peek() > top) {
            temp.push(st.pop());
        }
        st.push(top);
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }
    }
    public static int numTilePossibilities(String tiles)
    {
        Set<String> set = new HashSet<>();
        boolean vis [] = new boolean[tiles.length()];
        permuta(tiles, "", set, vis);
        return set.size() -1;
    }
    static void permuta(String tiles, String curr, Set<String> set, boolean vis[])
    {
        set.add(curr);
        for (int i=0; i<tiles.length(); i++){
            if (!vis[i]) {
                vis[i] = true;
                permuta(tiles, curr +tiles.charAt(i), set, vis);
                vis[i] = false;
            }
        }
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        findCombination(1, n, k, new ArrayList<>(), result);
        return result;
    }
    static void findCombination(int start, int target, int size,
                                List<Integer> comb, List<List<Integer>> result)
    {
        if (target == 0) {
            if (comb.size() == size) {
                result.add(new ArrayList<>(comb));
            }
            return;
        }
        for (int i=1; i<9; i++){
            if (i <= target) {
                comb.add(i);
                findCombination(i+1, target-i, size, comb, result);
                comb.remove(comb.size() -1);
            } else {
                break;
            }
        }
    }
}
