package leetcodePractice.HOT100._022括号生成;

import java.util.ArrayList;
import java.util.List;

public class solution {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    /**
     * 回溯算法 深度优先搜索（dfs）
     * @param n
     * @return
     */
    /*public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0)
            return list;
        dfs("",0,0,n,list);
        return list;
    }*/
    public static void dfs(String curStr,int left,int right,int n,List<String> list){
        if (left == n && right == n){
            list.add(curStr);
            return;
        }
        if (left < right){
            return;
        }
        if (left < n)
            dfs(curStr+"(",left+1,right,n,list);
        if (right < n)
            dfs(curStr+")",left,right+1,n,list);
    }

    /**
     * 闭合数 动态规划思想一样
     * 设定一个括号 将剩余括号分为两个部分： 括号里面 括号外面
     * dp[i] = "(" + dp[可能的括号对数] + ")" + dp[剩下的括号对数]
     * 和回溯相比 时间复杂度大
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0)
            list.add("");
        else {
            for (int i = 0;i < n;i ++){
                for (String left : generateParenthesis(i))
                    for (String right : generateParenthesis(n-i-1))
                        list.add("("+left+")"+right);
            }
        }
        return list;
    }
}
