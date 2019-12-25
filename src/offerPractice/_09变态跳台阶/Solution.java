package offerPractice._09变态跳台阶;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 思路： n 级台阶有f(n)种跳法，根据最后一次跳台阶的数目可以分解为:
 *    最后一次一级，则前面需要跳n-1级，有f(n-1)种跳法；
 *    最后一次跳两级，则前面需要跳n- 2n−2 级，有f(n-2) f(n−2) 种跳法。
 *    以此类推
 *      f(n) = f(n-1)+f(n-2)+...+f(1)
 *      f(n-1)= f(n-2)+...f(1)
 *      得:f(n)= 2*f(n-1)
 */

public class Solution {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(JumpFloorII(n));
    }
    public static int JumpFloorII(int target) {
        if (target==0 || target==1 || target==2)
            return target;
        else if (target == 3)
            return 4;
        else
            return 2*JumpFloorII(target-1);
    }
}
