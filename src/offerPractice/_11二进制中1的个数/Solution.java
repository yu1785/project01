package offerPractice._11二进制中1的个数;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Solution {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(NumberOf1(n));
    }
    public static int NumberOf1(int n) {
        return Integer.bitCount(n);
//        return 0;
    }
}

