package leetcodePractice.HOT100._047全排列2;

import java.util.*;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * @author yu
 * @date 2020/8/12 17:10
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {3,0,3,3};
        System.out.println(permuteUnique(nums));
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0){
            return res;
        }
        boolean[] visited = new boolean[nums.length];
        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);
        // 使用 Deque 是 Java 官方 Stack 类的建议
        dfs(nums,visited,res,new ArrayDeque<>());
        return res;
    }
    public static void dfs(int[] nums, boolean[] visited, List<List<Integer>> res, Deque<Integer> list){
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]){
                continue;
            }
            // 在46题的基础上添加下面两行代码
            // visited[i-1] 、!visited[i-1]都可以  但是没有不行 //todo
            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i>0 && nums[i]==nums[i-1] && !visited[i-1])
                continue;
            visited[i] = true;
            list.addLast(nums[i]);
            dfs(nums,visited,res,list);
            visited[i] = false;
            list.removeLast();
        }
    }
}
