package leetcodePractice.HOT100._005最长回文子串;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000
 *
 * 思路：动态规划
 */
public class solution {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
    public static String longestPalindrome(String s) {
        /**
         * 动态规划
         */
        /*int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int maxLen = 0;
        String maxSubString = "";
        for (int len = 1;len <= length;len ++){
            for (int start = 0;start < length;start ++){
                int end = start+len-1;
                if (end >= length)
                    break;
                dp[start][end] = (len == 1 || len == 2 || dp[start+1][end-1])
                        && s.charAt(start) == s.charAt(end);
                if (dp[start][end] && len>maxLen){
                    maxLen = len;
                    maxSubString = s.substring(start,end+1);
                }
            }
        }
        return maxSubString;*/

        /**
         * 马拉车算法 Manacher
         */
        if (s.length() < 2) {
            return s;
        }
        // 第一步：预处理，将原字符串转换为新字符串
        String t = "$";
        for (int i=0; i<s.length(); i++) {
            t += "#" + s.charAt(i);
        }
        // 尾部再加上字符@，变为奇数长度字符串
        t += "#@";
        // 第二步：计算数组p、起始索引、最长回文半径
        int n = t.length();
        // p数组
        int[] p = new int[n];
        int id = 0, mx = 0;
        // 最长回文子串的长度
        int maxLength = -1;
        // 最长回文子串的中心位置索引
        int index = 0;
        for (int j=1; j<n-1; j++) {
            // 参看前文第五部分
            p[j] = mx > j ? Math.min(p[2*id-j], mx-j) : 1;
            // 向左右两边延伸，扩展右边界
            while (t.charAt(j+p[j]) == t.charAt(j-p[j])) {
                p[j]++;
            }
            // 如果回文子串的右边界超过了mx，则需要更新mx和id的值
            if (mx < p[j] + j) {
                mx = p[j] + j;
                id = j;
            }
            // 如果回文子串的长度大于maxLength，则更新maxLength和index的值
            if (maxLength < p[j] - 1) {
                // 参看前文第三部分
                maxLength = p[j] - 1;
                index = j;
            }
        }
        // 第三步：截取字符串，输出结果
        // 起始索引的计算参看前文第四部分
        int start = (index-maxLength)/2;
        return s.substring(start, start + maxLength);
    }
}
