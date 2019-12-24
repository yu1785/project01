package leetcodePractice;

public class _53maxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        int maxSum = 0,sum = 0;
        for (int nu:nums){
            sum += nu;
            if (sum > maxSum)
                maxSum = sum;
            else
                sum = 0;
        }
        return maxSum;
    }
}
