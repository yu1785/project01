package leetcodePractice.HOT100._039组合总和;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 * 回溯算法
 */
public class solution {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        System.out.println(combinationSum(candidates,7));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
//        int len = candidates.length;
        Arrays.sort(candidates);
        dfs(candidates,target,0,new ArrayDeque<>(),list);
        return list;
    }

    public static void dfs(int[] candidates, int residue,
                           int begin, Deque<Integer> path, List<List<Integer>> list){
        if (residue == 0){
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin;i < candidates.length;i ++){
            if (residue - candidates[i] < 0)
                break;
            path.addLast(candidates[i]);
            dfs(candidates,residue-candidates[i],i,path,list);
            path.removeLast();
        }
    }
}
