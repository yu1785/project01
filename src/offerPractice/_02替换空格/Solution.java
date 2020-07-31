package offerPractice._02替换空格;

/**
 *  请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 *  例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 *  思路：
 *   首先判断空格的个数 增长序列长度 从后向前检索
 *
 *  注意：
 *    1.字符数组转字符串   String.valueOf()
 *    2.字符长度变动时使用stringBuffer更好，其将继续使用原来的内存空间,不新分配
 *    3.不要漏掉字符串第一个为空格的情况
 */

public class Solution {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We are happy");
//        String str = "We are happy";
        String newStr = replaceSpace(str);
        System.out.println(newStr);
    }
    // 方法一：不开辟新空间，对原字符串进行挪动
    /*public static String replaceSpace(StringBuffer str) {
        int len = str.length();
        char[] ch = str.toString().toCharArray();
        int blank = 0;
        for (char c:ch)
            if (c == ' ')
                blank ++;
        int extra = 2*blank;
        for (int i = 0;i < extra;i ++)
            str.append(' ');
        ch = str.toString().toCharArray();
        int newlen = len + extra;
        int startIndex = len-1;
        int endIndex = newlen-1;
        while (startIndex >= 0){     //注意取等于0的情况：字符串第一个为空格
            if (ch[startIndex] == ' '){
                ch[endIndex --] = '0';
                ch[endIndex --] = '2';
                ch[endIndex --] = '%';
                startIndex --;
            }
            else {
                ch[endIndex --] = ch[startIndex --];
            }
        }
//        System.out.println(String.valueOf(ch));
        return String.valueOf(ch);  //字符数组转字符串 String.valueOf(ch)
    }*/

    // 方法一：开辟新空间
    public static String replaceSpace(StringBuffer str){
        // 1.调用自带函数
//        return str.toString().replace(" ","%20");

        // 2.开辟新空间 使用一个字符串存放结果 遇到空格" "就追加"%20"
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' '){
                res.append("%20");
            }else {
                res.append(ch);
            }
        }
        return res.toString();
    }

}
