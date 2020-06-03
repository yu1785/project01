package leetcodePractice.HOT100._128最长连续序列;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 */
public class solution {
    public static void main(String[] args) {
        int[] nums = {4,4,5,5,6,6};
        System.out.println(longestConsecutive(nums));
    }

    /**
     * 双指针
     * 先对数组排序
     * 记录连续序列的起始索引
     * 重复的元素减一
     * @param nums
     * @return
     */
    /*public static int longestConsecutive(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        Arrays.sort(nums);
        int maxLen = 0;
        int pLeft = 0,pRight = 1;
        int flag = 0,index = 0;
        while (pRight < nums.length){
            int count = 0;
            // flag 标志位 记录连续序列是否开始
            if (nums[pRight]-nums[pLeft] == 1 && flag == 0){
                index = pLeft;
                flag = 1;
            }
            // 注意 pRight < nums.length 的判断 避免 pRight ++ 后数组越界
            while (pRight < nums.length && nums[pRight]-nums[pLeft] == 1){
                pLeft ++;
                pRight ++;
                while (pRight < nums.length && nums[pRight] == nums[pLeft]){
                    count ++;   // 记录重复元素的个数
                    pLeft ++;
                    pRight ++;
                }
            }
            maxLen = Math.max(maxLen,pRight-index-count);
            flag = 0;
            pLeft ++;
            pRight ++;
            // 一个连续序列结束 给index重新赋值为pLeft 连续序列的起始索引
            index = pLeft;
        }
        return maxLen;
    }*/

    /**
     * 利用 HashSet 存放数组 去掉重复元素
     * @param nums
     * @return
     */
    /*public static int longestConsecutive(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int maxLen = 0;
        Set<Integer> set = new HashSet<>();
        for (int nu:nums)
            set.add(nu);
        for (int nu:set){
            if (!set.contains(nu-1)){
                int curNum = nu;
                int curLen = 1;
                while (set.contains(curNum+1)){
                    curNum ++;
                    curLen ++;
                }
                maxLen = Math.max(maxLen,curLen);
            }
        }
        return maxLen;
    }*/

    /**
     *先排序
     * 对解法1的代码优化
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums){
        if (nums.length < 2)
            return nums.length;
        int maxLen = 0;
        int curLen = 1;
        Arrays.sort(nums);
        for (int i = 0;i < nums.length-1;i ++){
            // 出现重复元素的时候 继续下一步
            if (nums[i] != nums[i+1]){
                if (nums[i+1]-nums[i] == 1)
                    curLen ++;
                else {
                    maxLen = Math.max(maxLen,curLen);
                    curLen = 1;
                }
            }
        }
        return Math.max(maxLen,curLen);
    }
}
