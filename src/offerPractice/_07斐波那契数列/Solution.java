package offerPractice._07斐波那契数列;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请输出斐波那契数列的第n项 （从0开始，第0项为0） n<=39
 *
 * 思路:
 *    1.递归       时间复杂度：O(2^n)
 *    2.递归优化   时间复杂度：O(n)
 */
public class Solution {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(Fibonacci(n));
    }
    public static int Fibonacci(int n) {
        //1.递归
        /**
         * 该方法会重复计算很多值 资源浪费
         */
        /*if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return Fibonacci(n-1)+Fibonacci(n-2);*/

        // 2.递归优化
        // 递归会重复计算大量相同数据，我们用个数组把结果存起来
        // 时间复杂度：O(n)，空间复杂度：O(n)
      /*  int ans[] = new int[40];
        ans[0] = 0;
        ans[1] = 1;
        for(int i=2;i<=n;i++){
            ans[i] = ans[i-1] + ans[i-2];
        }
        return ans[n];*/

        // 3.继续优化
        // 可以发现每次就用到了最近的两个数，所以我们可以只存储最近的两个数
        // 时间复杂度：O(n)，空间复杂度：O(1)
        int num1 = 0;
        int num2 = 1;
        int sum = 0;
        if (n == 0 || n == 1)
            return n;
        else{
            for (int i = 2;i <= n;i ++){
                sum = num1+num2;
                num1 = num2;
                num2 = sum;
            }
            return sum;
        }
    }
}
