package leetcodePractice;
/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 1.排序:利用Arrays的sort()方法
 *      时间复杂度 O(nlogn)
 *      空间复杂度 O(1)
 * 2.利用哈希表记录每个字母出现的次数
 *      时间复杂度 O(n)
 *      空间复杂度 O(1)
 */

import java.util.Scanner;

public class _242letterSameOrNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
//        System.out.println("s = \""+s+"\", t = "+t+"\"");
        System.out.println(isAnagram(s,t));

    }

    /**
     * 1.排序:利用Arrays的sort()方法
     * @param s
     * @param t
     * @return
     */
    /*public static boolean isAnagram(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        if (s1.length != t1.length)
            return false;
        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1,t1);
    }*/

    /**
     * 2.利用哈希表记录每个字母出现的次数
     *      s中用++记录 t中用--记录
     *      个数记录中不为0，则输出false
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        if (s1.length != t1.length)
            return false;
        int[] count = new int[26];
        for (int i = 0;i < s1.length;i ++){
            count[s1[i] - 'a'] ++;
            count[t1[i] - 'a'] --;
        }
        for (int con:count){
            if (con != 0)
                return false;
        }
        return true;
    }

    ////////// 排序超时 效率低 //////////////
    public static String sort(String str){
        char[] ch = str.toCharArray();
        for (int i = 0;i < ch.length-1;i ++){
            for (int j = i+1;j < ch.length;j ++){
                if (ch[i] > ch[j]){
                    char temp = ch[i];
                    ch[i] = ch[j];
                    ch[j] = temp;
                }
            }
        }

        ////字符数组转字符串的几种方法////////
//        str = String.valueOf(ch);
//        str = new String(ch);
//        str = ch.getClass().getName();

//        System.out.println(Arrays.toString(ch)); //字符串数组
        return  str;
    }
}
