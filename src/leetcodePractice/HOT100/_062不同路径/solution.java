package leetcodePractice.HOT100._062不同路径;

import java.util.Arrays;

public class solution {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,2));
    }
    /**
     * 动态规划
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        /*int[][] dp = new int[m][n];
        // 只能 向右 向下 走，所以第一行第一列的位置路径仅有一条
        for (int i = 0;i < m;i ++)
            dp[i][0] = 1;
        for (int i = 0;i < n;i ++)
            dp[0][i] = 1;
        for (int i = 1;i < m;i ++)
            for (int j = 1;j < n;j ++)
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
        return dp[m-1][n-1];*/

        /**
         * 优化空间复杂度
         */
        int[] dp = new int[n]; // 记录一行的数据
        Arrays.fill(dp,1);
        // 一行一行的遍历
        for (int i = 1;i < m;i ++)
            for (int j = 1;j < n;j ++)
                dp[j] += dp[j-1];
        return dp[n-1];
    }
}
