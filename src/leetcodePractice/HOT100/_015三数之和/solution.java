package leetcodePractice.HOT100._015三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class solution {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    /**
     * 先排序 再利用双指针
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3)
            return result;
        Arrays.sort(nums);      //排序
        for (int i = 0;i < len-2;i ++){
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int left = i+1;
            int right = len-1;
            while (left < right){
                int sum = nums[i]+nums[left]+nums[right];
                if (sum == 0){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left ++;
                    right --;
                    //自加自减在前 避免下面指针越界
                    while (left < right && nums[left] == nums[left+1])    //去重
                        left ++;
                    while (left < right && nums[right] == nums[right-1])
                        right --;
                }
                else if (sum > 0)
                    right --;
                else
                    left ++;
            }
        }
        return result;
    }
}
