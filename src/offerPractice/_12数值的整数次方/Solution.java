package offerPractice._12数值的整数次方;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。保证base和exponent不同时为0
 *
 * 思路：
 *     1.直接调用pow()方法
 *     2.快速幂算法   更快  还可优化
 */
public class Solution {
    public static void main(String[] args) {
        double base = 2;
        int  ex = 3;
        System.out.println(Power(base,ex));
    }
    public static double Power(double base, int exponent) {
        //1.调用pow()方法
//        return Math.pow(base,exponent);

        //2.快速幂算法
        double result = 1;
        int ex = exponent > 0 ? exponent : -exponent;
        for (int i = 0;i < ex;i ++)
            result *= base;
        return exponent > 0 ? result : 1/result;
    }
}
