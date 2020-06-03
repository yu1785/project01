package leetcodePractice.HOT100._221最大正方形;

import java.util.Scanner;

/**
 * @author yu
 * @date 2020/5/6 21:15
 *
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 动态规划
 */
public class solution {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},
                {'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(matrix));
    }
    public static int maximalSquare(char[][] matrix) {
        /*int maxLen = 0;
        // 注意边界条件
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1'){
                    if (i == 0 || j == 0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
                maxLen = Math.max(maxLen,dp[i][j]);
            }
        }
        return maxLen*maxLen;*/

        int maxLen = 0;
        // 注意边界条件
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row+1][col+1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1')
                        dp[i+1][j+1] = Math.min(Math.min(dp[i][j],dp[i+1][j]),dp[i][j+1])+1;
                maxLen = Math.max(maxLen,dp[i+1][j+1]);
            }
        }
        return maxLen*maxLen;
    }
}
