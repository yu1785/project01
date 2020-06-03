package leetcodePractice.HOT100._136只出现一次的数字;

import java.util.HashMap;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class solution {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(singleNumber(nums));
    }

    /**
     * HashMap 时间复杂度和空间复杂度 O(n)
     * @param nums
     * @return
     */
    /*public static int singleNumber(int[] nums) {
//        if (nums.length == 0)
//            return 0;
//        if (nums.length == 1)
//            return nums[0];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int nu:nums){
            if (!map.containsKey(nu))
                map.put(nu,1);
            else
                map.put(nu,2);
        }
        for (int key:map.keySet())
            if (map.get(key) == 1)
                return key;
        return 0;
    }*/

    /**
     * 位运算 异或
     * 时间复杂度 O(n)  空间复杂度 O(1)
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        if (nums.length == 0)
            return 0;
        int res = nums[0];
        if (nums.length > 1){
            for (int i = 1;i <nums.length;i ++)
                res ^= nums[i];
        }
        return res;
    }
}
