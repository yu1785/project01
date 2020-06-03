package leetcodePractice.HOT100._200岛屿数量;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 * 你可以假设网格的四个边均被水包围。
 */
public class solution {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'},
                        {'1','1','0','0','0'},
                        {'0','0','1','0','0'},
                        {'0','0','0','1','1'}};
        System.out.println(numIslands(grid));
    }
    public static int count = 0;
    /*public static int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int row = 0;row < grid.length;row ++)
            for (int col = 0; col < grid[0].length;col ++)
                if (!visited[row][col] && grid[row][col] == '1'){
                    count ++;
                    dfs(grid,visited,row,col);
                }
        return count;
    }
    public static void dfs(char[][] grid,boolean[][] visited,int row,int col){
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)
            return;
        if (grid[row][col] == '0' || visited[row][col])
            return;
        visited[row][col] = true;
        dfs(grid,visited,row-1,col);
        dfs(grid,visited,row+1,col);
        dfs(grid,visited,row,col-1);
        dfs(grid,visited,row,col+1);
    }*/

    /**
     * 不适用额外的 visited 数组
     * 遍历后将值直接赋为‘0’
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;
        for (int row = 0;row < grid.length;row ++)
            for (int col = 0; col < grid[0].length;col ++)
                if (grid[row][col] == '1'){
                    count ++;
                    dfs(grid,row,col);
                }
        return count;
    }
    public static void dfs(char[][] grid,int row,int col){
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)
            return;
        if (grid[row][col] == '0')
            return;
        grid[row][col] = '0';
        dfs(grid,row-1,col);
        dfs(grid,row+1,col);
        dfs(grid,row,col-1);
        dfs(grid,row,col+1);
    }
}
