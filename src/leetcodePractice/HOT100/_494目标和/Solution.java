package leetcodePractice.HOT100._494目标和;

/**
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。
 * 现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * @author yu
 * @date 2020/8/7 16:23
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int S = 3;
        int res = findTargetSumWays(nums,S);
        System.out.println(res);
    }
    public static int count = 0;
    public static int findTargetSumWays(int[] nums, int S) {
        dfs(nums,S,0,0);
        return count;
    }
    public static void dfs(int[] nums,int s,int index,int sum){
        if (index == nums.length) {
            // 注意这个判断条件要和上面的条件分开 不能合在一起写
            if (sum == s)
                count++;
        }
        else {
            dfs(nums,s,index+1,sum+nums[index]);
            dfs(nums,s,index+1,sum-nums[index]);
        }
    }
}
