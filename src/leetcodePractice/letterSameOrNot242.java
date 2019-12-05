package leetcodePractice;
/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 排序
 */

import java.util.Scanner;

public class letterSameOrNot242 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        if (isAnagram(s,t))
            System.out.println(true);
        else
            System.out.println(false);
    }
    public static boolean isAnagram(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        if (s1.length != t1.length)
            return false;
        sort(s);
        sort(t);
        if (s.equals(t))
            return true;
        else
            return false;
    }
    public static void sort(String str){
        char[] ch = str.toCharArray();
        for (int i = 0;i < ch.length-1;i ++){
            for (int j = i+1;j < ch.length;j ++){
                if (ch[i] < ch[j]){
                    int temp = ch[i];
                    ch[i] = ch[j];
                    ch[j] = ch[temp];
                }
            }
        }
        str = ch.toString();
    }
//    public static void swap()
}
