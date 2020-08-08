package leetcodePractice.HOT100._139单词拆分;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
 * 判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：
 *      拆分时可以重复使用字典中的单词。
 *      你可以假设字典中没有重复的单词。
 *
 * 思路：
 *      动态规划
 *      dp[i]=dp[j] && check(s[j..i−1])
 *      dp[i] 表示字符串 s 前 i 个字符组成的字符串
 */
public class solution {
    public static void main(String[] args) {
        String str = "leetcode";
        List<String> wordDict = new ArrayList<>(Arrays.asList("leet", "code")) ;
        System.out.println(wordBreak(str,wordDict));
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        // 注意这里要对初始dp[0]赋值
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
