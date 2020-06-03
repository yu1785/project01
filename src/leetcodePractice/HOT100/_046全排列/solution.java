package leetcodePractice.HOT100._046全排列;

import java.util.ArrayList;
import java.util.List;

public class solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

    /**
     * 回溯
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] visited = new int[nums.length];
        dfs(nums,visited,new ArrayList<Integer>(),result);
        return result;
    }
    public static void dfs(int[] nums,int[] visited,ArrayList<Integer> list,List<List<Integer>> result){
        if (list.size() == nums.length){
            // 注意这里一定要new 如果直接传list 这里传的是地址 list发生改变 result也会跟着改变
            // 所以这里的 new ArrayList<>(list) 相当于对list里面内容的拷贝
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0;i < nums.length;i ++){
            if (visited[i] == 0){
                list.add(nums[i]);
                visited[i] = 1;
                dfs(nums,visited,list,result);
                visited[i] = 0;
                list.remove(list.size()-1);
            }
        }
    }
}
