package leetcodePractice.HOT100._169多数元素;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。
 * 多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class solution {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
    public static int majorityElement(int[] nums) {
        /**
         * HashMap
         * 复杂度过大
         *时间复杂度O(n) 空间复杂度O(n)
         */
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i ++){
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else
                map.put(nums[i],1);
            if (map.get(nums[i]) > nums.length/2)
                return nums[i];
        }
        return 0;

        /**
         * 排序
         * 出现次数大于 ⌊ n/2 ⌋ 
         * 该元素一定会出现在中间位置
         *
         * 时间复杂度O(nlogn) 空间复杂度O(logn)
         */
        /*if (nums.length == 0)
            return 0;
        Arrays.sort(nums);
        return nums[nums.length/2];*/

        /**
         * 摩尔投票法
         * count 记录元素出现次数
         * 出现 +1 没出现 -1
         * count=0 更新元素值和count值
         * 元素出现次数大于 ⌊ n/2 ⌋ 
         * 则一定会有 最后count值大于0
         *
         * 时间复杂度最小O(n) 空间复杂度O(1)
         */
        /*if (nums.length == 0)
            return 0;
        int numCount = nums[0];
        int count = 1;
        for (int nu:nums){
            if (nu == numCount)
                count ++;
            else {
                count --;
                if (count == 0){
                    numCount = nu;
                    count = 1;
                }
            }
        }
        return numCount;*/
    }
}
