package leetcodePractice.HOT100._072编辑距离;

/**
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 *          插入一个字符
 *          删除一个字符
 *          替换一个字符
 */
public class solution {
    public static void main(String[] args) {
        System.out.println(minDistance("horse","ros"));
    }

    /**
     * 动态规划
     * 列表示 word1 字符   行表示 word2 字符
     * 第一列为空 表示 word1 全执行插入操作
     * 第一行为空 表示 word1 全执行删除操作
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        // 第一行
        for (int i = 1;i <= len2;i ++)
            dp[0][i] = dp[0][i-1] + 1;
        // 第一列
        for (int i = 1;i <= len1;i ++)
            dp[i][0] = dp[i-1][0] + 1;
        // 一层一层遍历
        for (int i = 1;i <= len1;i ++)
            for (int j = 1;j <= len2;j ++){
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    // 分别表示 替换，删除，插入 操作
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1]) + 1;
            }
        return dp[len1][len2];
    }
}
