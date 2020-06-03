package leetcodePractice.HOT100._010正则表达式匹配;

public class solution {
    public static void main(String[] args) {
        System.out.println(isMatch("aab","c*a*b"));
    }
    public static boolean isMatch(String s, String p) {
        /**
         * 回溯算法
         */
        /*if(p.isEmpty())
            return s.isEmpty();
        boolean firstMatch = (!s.isEmpty())
                && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if(p.length() >= 2 && p.charAt(1) == '*')
            return isMatch(s,p.substring(2)) || (firstMatch && isMatch(s.substring(1),p));
        else
            return firstMatch && isMatch(s.substring(1),p.substring(1));*/

        /**
         * 动态规划  自顶向下
         */
        /*if (p.isEmpty())
            return s.isEmpty();
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) { // here's the p's length, not s's
            if (p.charAt(i) == '*' && dp[0][i - 1])
                dp[0][i + 1] = true; // here's y axis should be i+1
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i))
                    dp[i + 1][j + 1] = dp[i][j];
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.')
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    else
                        dp[i + 1][j + 1] = (dp[i][j + 1] || dp[i + 1][j] || dp[i + 1][j - 1]);
//                    dp[i][j] = dp[i-1][j] // 多个字符匹配的情况
//                    or dp[i][j] = dp[i][j-1] // 单个字符匹配的情况
//                    or dp[i][j] = dp[i][j-2] // 没有匹配的情况
                }
            }
        }
        return dp[s.length()][p.length()];*/

        /**
         * 动态规划  自底向上
         */
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[s.length()][p.length()] = true;
        for (int i = s.length();i >= 0;i --)
            for (int j = p.length()-1;j >= 0;j --){
                boolean firstMatch = i < s.length()
                        && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');
                if (j+1 < p.length() && p.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || (firstMatch && dp[i+1][j]);
                }
                else
                    dp[i][j] = firstMatch && dp[i+1][j+1];
            }
        return dp[0][0];
    }
}
