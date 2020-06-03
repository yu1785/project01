package leetcodePractice.HOT100._078子集;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集
 */
public class solution {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
    }

    /**
     * 回溯 dfs
     * 特别注意 相同的值顺序不一样 属于同一个子集
     * @param nums
     * @return
     */
    /*public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int len = 1;len <= nums.length;len ++){
            dfs(nums,result,list,len,0);
        }
        return result;
    }
    public static void dfs(int[] nums,List<List<Integer>> result,List<Integer> list,int length,int index){
        if (list.size() == length){
            result.add(new ArrayList<>(list));
            return;
        }
        //  注意这里的 int i = index 为起始索引值
        for (int i = index;i < nums.length;i ++){
            list.add(nums[i]);
            dfs(nums,result,list,length,i+1);
            list.remove(list.size()-1);
        }
    }*/

    /**
     * 时间复杂度更小
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
//        result.add(new ArrayList<>());
        dfs(nums,result,list,0);
        return result;
    }
    public static void dfs(int[] nums,List<List<Integer>> result,List<Integer> list,int index){
        result.add(new ArrayList<>(list));
        for (int i = index;i < nums.length;i ++){
            list.add(nums[i]);
            dfs(nums,result,list,i+1);
            list.remove(list.size()-1);
        }
    }
}
