package Graph.Medium;

public class gfg {

    public static void main(String[] args) {
        char[][] grid = {
                { 'L', 'L', 'W', 'W', 'W' },
                { 'W', 'L', 'W', 'W', 'L' },
                { 'L', 'W', 'W', 'L', 'L' },
                { 'W', 'W', 'W', 'W', 'W' },
                { 'L', 'W', 'L', 'L', 'W' }
        };
        System.out.println(numberOfLands(grid));
    }
    static int numberOfLands(char grid[][])
    {
        int row = grid.length;
        int col = grid[0].length;
        boolean vis[][] = new boolean[row][col];
        int count =0;
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (grid[i][j] == 'L' && !vis[i][j]){
                    dfs(grid, i, j, vis);
                    count++;
                }
            }
        }
        return count;
    }
    static void dfs(char grid[][], int r, int c, boolean vis[][])
    {
        int[] rNbr = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] cNbr = { -1, 0, 1, -1, 1, -1, 0, 1 };
        vis[r][c] = true;

        for (int i=0; i<8; i++){
            int newR = r + rNbr[i];
            int newC = c + cNbr[i];
            if (isSafe(grid, newR, newC, vis))
                dfs(grid, newR, newC, vis);
        }
    }
    static boolean isSafe (char grid[][], int r, int c, boolean vis[][])
    {
        int row = grid.length;
        int col = grid[0].length;
        return (r >=0) && (r <row) &&
                (c >=0) && (c < col) &&
                (grid[r][c] == 'L' && !vis[r][c]);
    }
}
