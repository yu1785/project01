package leetcodePractice.HOT100._031下一个排列;

import java.util.Arrays;

public class solution {
    public static void main(String[] args) {
        int[] nums = {3,2,1};
        nextPermutation(nums);
        for (int nu:nums)
            System.out.print(nu+" ");
    }

    /**
     * 思路：
     *      从数组右边找到第一对两个连续的数字 a[i]和 a[i-1]，它们满足 a[i]>a[i-1]
     *      将数字 a[i-1] 替换为位于其右侧区域的数字中从右到左第一个比他大的数字，a[j]
     *      将数字 a[i-1] 右侧区域按升序排列
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        int flag = 0;
        for (int i = len-1;i > 0;i --){
            if (nums[i] > nums[i-1]){
                flag = 1;
                for (int j = len-1;j > i-1;j --){
                    if (nums[j] > nums[i-1]){
                        //交换位置
                        int temp = nums[j];
                        nums[j] = nums[i-1];
                        nums[i-1] = temp;
                        break;
                    }
                }
                Arrays.sort(nums,i,len);
                return;
            }
        }
        if (flag == 0)
            Arrays.sort(nums);
    }
}
