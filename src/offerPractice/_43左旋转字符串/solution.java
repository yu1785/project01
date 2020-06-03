package offerPractice._43左旋转字符串;

import java.util.ArrayList;

/**
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 思路：利用String函数的subString方法
 */
public class solution {
    public static void main(String[] args) {
        String str = "asd";
        int num = 3;
        System.out.println(LeftRotateString(str,num));
    }
    public static String LeftRotateString(String str,int n) {
        //注意边缘条件
        if (str.length() <= n)
            return str;
        return str.substring(n)+str.substring(0,n);
        //考虑list的方法 太复杂。。。
        /*char[] chars = str.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for (int i = n;i < chars.length;i ++)
            list.add(chars[i]);
        for (int i = 0;i < n;i ++)
            list.add(chars[i]);
        String result[] = list.toArray(new String[]{});
        return result.toString();*/
    }
}
