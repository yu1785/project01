package offerPractice._27字符串的排列;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba
 */
public class Solution {
    public static void main(String[] args) {
        String str = new String("aa");
        System.out.println(Permutation(str));
    }
    public static ArrayList<String> list = new ArrayList<>();
    public static TreeSet<String> set = new TreeSet<>();
    public static StringBuilder charList = new StringBuilder();
    public static boolean[] visited;
    public static ArrayList<String> Permutation(String str) {
        if (str.length() == 0)
            return list;
        char[] ch = str.toCharArray();
        visited = new boolean[ch.length];
        Permutation(ch,0);
        list.addAll(set);
        return list;
    }
    public static void Permutation(char[] ch,int length){
        if (ch.length == length){
            set.add(charList.toString());
            return;
        }
        for (int i = 0;i < ch.length;i ++){
            if (!visited[i]){
                visited[i] = true;
                charList.append(ch[i]);
                Permutation(ch,length+1);
                visited[i] = false;
                charList.deleteCharAt(charList.length()-1);
            }
        }
    }
}
