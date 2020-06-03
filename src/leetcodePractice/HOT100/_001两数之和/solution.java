package leetcodePractice.HOT100._001两数之和;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */
public class solution {
    public int[] twoSum(int[] nums, int target) {
        /**
         * 暴力揭发 遍历数组 复杂度过大
         */
        /*int[] res = new int[2];
        for(int i = 0;i < nums.length;i ++){
            for (int j = i+1;j < nums.length; j ++){
                if (nums[j] == target-nums[i]){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;*/

        /**
         * 两遍哈希表
         */
        /*int[] res = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i ++)
            map.put(nums[i],i);
        for (int i = 0;i < nums.length;i ++){
            target -= nums[i];
            if (map.containsKey(target) && map.get(target) != i){
                res[1] = map.get(target);
                res[0] = i;
                return res;
            }
            target += nums[i];
        }
        return res;*/

        /**
         * 一遍哈希表
         */
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i ++){
            int val = target - nums[i];
            if (map.containsKey(val))
                return new int[] {map.get(val),i};
            map.put(nums[i],i);
        }
        return new int[2];
    }
}