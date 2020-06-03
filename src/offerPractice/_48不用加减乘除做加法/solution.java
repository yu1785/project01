package offerPractice._48不用加减乘除做加法;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号
 *
 * 思路：二进制加法 异或相加 进位用与操作实现
 */
public class solution {
    public int Add(int num1,int num2) {
        int result = 0;
        int carry = 0;
        do {
            result = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = result;
            num2 = carry;
        }while (carry != 0); //do... while 条件不满足后才停止循环
        return result;
    }
}
