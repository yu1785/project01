package leetcodePractice.HOT100._152乘积最大子数组;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）。
 */
public class solution {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }

    /**
     * 动态规划
     * 最大最小值
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curMax = 1,curMin = 1;
        for (int i = 0;i < nums.length;i ++){
            // 当为负数的时候 交换最大最小值
            if (nums[i] < 0){
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }
            curMax = Math.max(curMax*nums[i],nums[i]);
            curMin = Math.min(curMin*nums[i],nums[i]);
            max = Math.max(max,curMax);
        }
        return max;
    }
}
