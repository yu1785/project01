package leetcodePractice;
/**
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，
 * 我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 *
 * 思路：
 *   回溯算法
 *   大小写字母转换   相差 32   异或 1<<5 即可
 */

import java.util.ArrayList;
import java.util.List;

public class _784letterCasePermutation {
    public static void main(String[] args) {
        String S = "a1b2";
        List<String> list = letterCasePermutation(S);
        System.out.println(list);
    }
    public static List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        pre(S.toCharArray(),0,list);
        return list;
    }
    public static void pre(char[] ch,int i,List<String> list){
        if (i == ch.length){
            list.add(String.valueOf(ch));
            return;
        }
        pre(ch,i+1,list);
        if (ch[i] < '0' || ch[i] > '9'){
            ch[i] ^= (1<<5);
            pre(ch, i+1, list);
        }
    }
}
