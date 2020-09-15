package offerPractice._34第一个只出现一次的字符;

import java.util.HashMap;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置,如果没有则返回 -1（需要区分大小写）
 *
 * 思路：
 *    1.哈希表
 *    2.利用 String 类中的方法： indexOf()  lastIndexOf()
 */
public class Solution {
    public static void main(String[] args) {
        String str = "abcdase";
        System.out.println(FirstNotRepeatingChar(str));
    }

    /**
     * 方法1：哈希表，记录每个字符出现的次数
     * @param str
     * @return
     */
    /*public static int FirstNotRepeatingChar(String str) {
        if (str.length()==0)
            return -1;
        int[] hashCount = new int[128];
        for (int i = 0;i < str.length();i ++){
            hashCount[str.charAt(i)] ++;
        }
        for (int i = 0;i < str.length();i ++){
            if (hashCount[str.charAt(i)] == 1)
                return i;
        }
        return -1;
    }*/
    public static int FirstNotRepeatingChar(String str) {
        HashMap<Character,Boolean> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char ch:chars) {
            map.put(ch,!map.containsKey(ch));
        }
        for (char ch:chars) {
            if (map.get(ch))
                return str.indexOf(ch);
        }
        return -1;
    }

    /**
     * 方法2：利用String类的方法
     * indexOf()    :返回指定字符在此字符串中第一次出现处的索引
     * lastIndexOf():返回指定字符在此字符串中最后一次出现处的索引
     * @param str
     * @return
     */
    /*public static int FirstNotRepeatingChar(String str) {
        if (str.length()==0)
            return -1;
        for (int i = 0;i < str.length();i ++){
            if (str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i)))
                return i;
        }
        return -1;
    }*/
}
