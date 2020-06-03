package leetcodePractice.HOT100._032最长有效括号;

import java.util.Stack;

public class solution {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
    }
    public static int longestValidParentheses(String s) {
        /**
         * 两个指针 挨个遍历 暴力解
         * 时间复杂度太大
         */
        /*int max = 0;
        for (int i = 0;i < s.length();i ++){
            if (s.length() - i < max)
                break;
            if (s.charAt(i) == ')')
                continue;
            int left = 0,right = 0;
            for (int j = i;j < s.length();j ++){
                if (s.charAt(j) == '(')
                    left ++;
                if (s.charAt(j) == ')')
                    right ++;
                if (right > left)
                    break;
                else if (left < right)
                    continue;
                else if (left == right)
                    max = Math.max(max,j-i+1);
            }
        }
        return max;*/

        /**
         * 栈
         * 时间复杂度： O(n) 。 n 是给定字符串的长度.
         * 空间复杂度： O(n) 。栈的大小最大达到 n 。
         */
        /*int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);   // 括号出现在最前面的情况
        for (int i = 0;i < s.length();i ++){
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                stack.pop();
                if (stack.empty())
                    stack.push(i);
                else {
                    max = Math.max(max,i-stack.peek());
                }
            }
        }
        return max;*/

        /**
         * 动态规划
         * 时间复杂度： O(n) 。遍历整个字符串一次，就可以将 dp 数组求出来。
         * 空间复杂度： O(n) 。需要一个大小为 n 的 dp 数组。
         */
       /* int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 0;i < s.length();i ++){
            if (i-1 >= 0 && s.charAt(i) == ')'){
                if (s.charAt(i-1) == '(')
                    // dp[i]=dp[i−2]+2
                    dp[i] = (i>=2 ? dp[i-2]:0) + 2;
                else if (s.charAt(i-1) == ')' && i-1-dp[i-1] >= 0 && s.charAt(i-1-dp[i-1]) == '('){
                    // dp[i]=dp[i−1]+dp[i−dp[i−1]−2]+2
                    dp[i] = dp[i-1] + ( (i-dp[i-1])>=2 ? dp[i-dp[i-1]-2]:0 ) + 2;
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;*/

        /**
         * 两个指针 优化解
         * 从左到右遍历 再从右到左遍历
         * 时间复杂度： O(n) 。遍历两遍字符串。
         * 空间复杂度： O(1) 。仅有两个额外的变量 left 和 right 。
         */
        int left = 0,right = 0,max = 0;
        for (int i = 0;i < s.length();i ++){
            if (s.charAt(i) == '(')
                left ++;
            else
                right ++;
            if (left == right)
                max = Math.max(max,left*2);
            else if (right > left){
                right = 0;
                left= 0;
            }
        }
        right = 0;
        left= 0;
        for (int i = s.length()-1;i >= 0;i --){
            if (s.charAt(i) == ')')
                left ++;
            else
                right ++;
            if (left == right)
                max = Math.max(max,left*2);
            else if (right > left){
                right = 0;
                left= 0;
            }
        }
        return max;
    }
}
