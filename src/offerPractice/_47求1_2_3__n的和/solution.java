package offerPractice._47求1_2_3__n的和;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 * 思路： 位运算
 */
public class solution {
    public int Sum_Solution(int n) {
        int sum = (int)Math.pow(n,2)+n;
        return sum>>1;
    }
}
