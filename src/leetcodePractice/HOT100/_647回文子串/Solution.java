package leetcodePractice.HOT100._647回文子串;

/**
 *给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * @author yu
 * @date 2020/8/7 15:06
 */
public class Solution {
    public static void main(String[] args) {
        String str = "aaa";
        int res = countSubstrings(str);
        System.out.println(res);
    }

    /**
     * 方法一：从中心往两侧延伸
     *   在长度为 N 的字符串中，可能的回文串中心位置有 2N-1 个：字母，或两个字母中间
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {
        int count = 0,left,right;
        int n = s.length();
        for (int i = 0; i <= 2*n-1; i++) {
            left = i/2;
            right = left+i%2;
            while (left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                count ++;
                // 从中心往两侧延伸
                left --;
                right ++;
            }
        }
        return count;
    }

    /**
     * 方法二：马拉车算法
     * @param
     * @return
     */


    public static boolean huiWen(String str){
        if (str.length() == 1){
            return true;
        }
        StringBuilder str1 = new StringBuilder(str);
        StringBuilder str2 = str1.reverse();
        // 注意由于StringBuilder没有重写equals函数  所以使用String.valueOf(str1)
        if (String.valueOf(str1).equals(String.valueOf(str2))){
            return true;
        }
        return false;
    }
}
