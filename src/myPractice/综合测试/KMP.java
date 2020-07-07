package myPractice.综合测试;

import java.util.Arrays;

/**
 * @author yu
 * @date 2020/7/7 9:20
 */
public class KMP {
    public static void main(String[] args) {
        String str = "BBC ABCDAB ABCDABCDABDE";
        String substr = "ABCDABD";
        int[] next = kmpNext(substr);
        System.out.println(Arrays.toString(next));
        int index = kmpSearch(str,substr,next);
        System.out.println(index);
    }

    public static int kmpSearch(String str,String substr,int[] next){
        int len = 0;
        for (int i = 0; i < str.length(); i++) {
            // 没有匹配
            // 注意这里是 len 大于 0 的情况，刷新 len 的值，再进行值的判断
            // 如果 len = 0 则进入下一次循环
            while (len > 0 && str.charAt(i) != substr.charAt(len)){
                len = next[len-1];
            }
            // 有匹配
            if (str.charAt(i) == substr.charAt(len)){
                len ++;
            }
            if (len == substr.length()){
                return i-len+1;  // 返回第一个匹配的位置
            }
        }
        return -1;
    }

    // 获取字符子串的部分匹配表
    public static int[] kmpNext(String str){
        int[] next = new int[str.length()];
        int len = 0; // 匹配长度
        next[0] = 0; // 第一个字母匹配值为 0
        for (int i = 1; i < str.length(); i++) {
            // 没有匹配
            // 注意这里是 len 大于 0 的情况，刷新 len 的值，再进行值的判断
            // 如果 len = 0 则直接赋值 next[i] = len，即 next[i] = 0
            while (len > 0 && str.charAt(i) != str.charAt(len)){
                len = next[len-1];
            }
            // 有匹配
            if (str.charAt(i) == str.charAt(len)){
                len ++;
            }
            next[i] = len;
        }
        return next;
    }
}
