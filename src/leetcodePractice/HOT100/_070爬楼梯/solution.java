package leetcodePractice.HOT100._070爬楼梯;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class solution {
    public static void main(String[] args) {
        System.out.println(climbStairs(1));
    }
    public static int climbStairs(int n) {
        /*int[] dp = new int[n+1];
        for (int i = 0;i < n;i ++){
            if (i >= 2)
                dp[i] = dp[i-1] +dp[i-2];
            else if (i >= 1 && i < 2)
                dp[i] = dp[i-1] + 1;
            else
                dp[i] = 1;
        }
        return dp[n-1];*/

        /**
         * 代码简化
         */
        // 注意边缘条件 防止数组越界
        if (n == 1)
            return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3;i <= n;i ++)
            dp[i] = dp[i-1] +dp[i-2];
        return dp[n];
    }
}
