package leetcodePractice.HOT100._003无重复字符的最长字串;

import java.util.HashMap;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class solution {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }
    public static int lengthOfLongestSubstring(String s) {
        /**
         * hashMap 两个指针
         */
        /*int maxLength = 0;
        int p1 = 0,p2 = 0;
        Map<Character,Integer> map = new HashMap<>();
        char[] str = s.toCharArray();
        for (int i = 0;i < str.length;i ++){
            if (map.containsKey(str[i])){
                maxLength = Math.max(maxLength,i-p2);
                p1 = p2;
                p2 = map.get(str[i])+1;
                for (int j = p1;j < p2;j ++){
                    map.remove(str[j]);
                }
            }
            maxLength = Math.max(maxLength,i-p2+1);
            map.put(str[i],i);
        }
        return maxLength;*/

        /**
         * 代码优化 滑动窗口
         */
        HashMap<Character,Integer> map = new HashMap<>();
        int pLfet = 0;
        int maxLength = 0;
        for (int i = 0;i < s.length();i ++){
            if (map.containsKey(s.charAt(i)))
                pLfet = Math.max(pLfet,map.get(s.charAt(i))+1);
            map.put(s.charAt(i),i);
            maxLength = Math.max(maxLength,i-pLfet+1);
        }
        return maxLength;
    }
}
