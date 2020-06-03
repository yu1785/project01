package leetcodePractice.HOT100._053最大子序和;

public class solution {
    public static void main(String[] args) {
        int[] nums = {-1};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        /**
         * 直接顺序遍历数组
         */
        /*int sum = 0,maxSum = nums[0];
        for (int nu:nums){
            sum += nu;
            maxSum = Math.max(sum,maxSum);
            if (sum < 0){
                sum = 0;
                continue;
            }
        }
        return maxSum;*/

        /**
         * 动态规划
         */
        int maxSum = nums[0];
        for (int i= 1;i < nums.length;i ++){
            nums[i] += nums[i-1] > 0 ? nums[i-1] : 0;
            maxSum = Math.max(nums[i],maxSum);
        }
        return maxSum;
    }
}
