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

        //2.递归优化
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
