package leetcodePractice.HOT100._064最小路径和;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 */
public class solution {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }

    /**
     * 动态规划
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        /**
         * 从右下角开始搜索 一行一行的遍历
         */
        /*int[] dp = new int[grid[0].length];
//        dp[grid[0].length] = grid[grid.length-1][grid[0].length-1];  // 右下角
        for (int i = grid.length-1;i >= 0;i --)
            for (int j = grid[0].length-1;j >= 0;j --){
                if (i == grid.length-1 && j == grid[0].length-1)
                    dp[j] = grid[i][j];
                else if (i == grid.length-1)
                    dp[j] = grid[i][j] + dp[j+1];
                else if (j == grid[0].length-1)
                    dp[j] = grid[i][j] + dp[j];
                else
                    dp[j] = grid[i][j] + Math.min(dp[j],dp[j+1]);
            }
        return dp[0];*/

        /**
         * 从左上角开始搜索 一行一行的遍历
         */
        int[] dp = new int[grid[0].length];
        for (int i = 0;i < grid.length;i ++)
            for (int j = 0;j < grid[0].length;j ++){
                if (i == 0 && j == 0)
                    dp[j] = grid[i][j];
                else if (i == 0)
                    dp[j] = grid[i][j] + dp[j-1];
                else if (j == 0)
                    dp[j] = grid[i][j] + dp[j];
                else
                    dp[j] = grid[i][j] + Math.min(dp[j],dp[j-1]);
            }
        return dp[grid[0].length-1];
    }
}
