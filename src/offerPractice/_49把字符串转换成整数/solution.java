package offerPractice._49把字符串转换成整数;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 *
 * 思路：利用正则表达式判断字符串格式是否正确
 *       注意边界条件 整数是否越界
 */
public class solution {
    public static void main(String[] args) {
        System.out.println('9'-0);
    }
    public int StrToInt(String str) {
        if (!str.matches("[1-9,+,-]\\d+")) //正则表达式
            return 0;
        int index = str.length()-1;
        long result = 0;    //long类型，避免溢出。不能用int
        while (index>=0 && str.charAt(index)>='0' && str.charAt(index)<='9'){
            result += Math.pow(10,str.length()-1-index)*(str.charAt(index)-'0');
            index --;
        }
        result = str.charAt(0)=='-' ? -result:result;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;
        return (int)result;
    }
}
