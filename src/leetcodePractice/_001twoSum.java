package leetcodePractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**题目：
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标
 *
 * 思路：
 *      暴力解法 时间复杂度 O(n^2)
 *      利用哈希表的方式，时间复杂度低 O(n)
 */

public class _001twoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = {3,3};
        int target = 6;
        int[] num = new int[2];
        num = twoSum(nums,target);
        for (int nu:num)
            System.out.print(nu+" ");
    }

    public static int[] twoSum(int[] nums, int target) {
        //Map是一个接口不能实例化，HashMap是Map的一个实现
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
