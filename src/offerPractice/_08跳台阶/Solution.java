package offerPractice._08跳台阶;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * 思路： 与斐波那契数列类似
 */

public class Solution {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(JumpFloor(n));
    }
    public static int JumpFloor(int target) {
        //1.递归
        /*if (target==0 || target==1 || target==2)
            return target;
        else
            return JumpFloor(target-1) + JumpFloor(target-2);*/

        //2.递归优化
        int num1 = 1;
        int num2 = 2;
        int sum = 0;
        if (target==0 || target==1 || target==2)
            return target;
        else {
            for (int i = 3;i <= target;i ++){
                sum = num1+num2;
                num1 = num2;
                num2 = sum;
            }
            return sum;
        }
    }
}
