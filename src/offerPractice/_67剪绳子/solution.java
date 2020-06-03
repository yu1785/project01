package offerPractice._67剪绳子;

/**
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 思路：动态规划 、 贪婪算法
 */
public class solution {
    public static void main(String[] args) {
        System.out.println(cutRope(8));
    }

    /**
     *1.动态规划
     * @param target
     * @return
     */
    /*public static int cutRope(int target) {
        if (target < 2)
            return 0;
        else if (target == 2)
            return 1;
        else if (target == 3)
            return 2;
        int[] dp = new int[target+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4;i <= target;i ++){
            for (int j = 1;j <= i/2;j ++){
                dp[i] = Math.max(dp[i],dp[j]*dp[i-j]);
            }
        }
        return dp[target];
    }*/

    /**
     * 2.贪婪算法
     * @param target
     * @return
     */
    public static int cutRope(int target) {
        if (target < 2)
            return 0;
        else if (target == 2)
            return 1;
        else if (target == 3)
            return 2;
        int timesOf3 = target/3;
        if (target - timesOf3*3 == 1)
            timesOf3 -= 1;
        int timesOf2 = (target-timesOf3*3)/2;
        return (int) ((int)Math.pow(2,timesOf2)*Math.pow(3,timesOf3));
    }
}
