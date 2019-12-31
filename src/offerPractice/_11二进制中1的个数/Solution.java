package offerPractice._11二进制中1的个数;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * 思路：
 *   1.利用 Integer类中的 bitCount()方法 计算二进制补码表示形式的 1 的数量
 *   2.n=n&(n-1) 与操作后消掉原n中的一个1 当n=0时结束
 */
public class Solution {
    public static void main(String[] args) {
        int n = -1;
        System.out.println(NumberOf1(n));
    }
    public static int NumberOf1(int n) {
        //1.Integer类中的 bitCount()方法
        return Integer.bitCount(n);

        //2.二进制与运算
        /*int count = 0;
        while (n != 0){
            count ++;
            n = n&(n-1);
        }
        return count;*/
    }
}

