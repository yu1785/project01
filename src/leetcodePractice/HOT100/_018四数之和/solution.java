package leetcodePractice.HOT100._018四数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class solution {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(nums,0));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if (len < 4)
            return result;
        Arrays.sort(nums);
        // 四个指针 i j k h
        for (int i = 0;i < len-3;i ++){
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int min1 = nums[i]+nums[i+1]+nums[i+2]+nums[i+3];
            if (min1 > target)
                continue;
            int max1 = nums[i]+nums[len-1]+nums[len-2]+nums[len-3];
            if (max1 < target)
                continue;
            //第二层循环
            for (int j = i+1;j < len-2;j ++){
                if (j > i+1 && nums[j] == nums[j-1])
                    continue;
                int min2 = nums[i]+nums[j]+nums[j+1]+nums[j+2];
                if (min2 > target)
                    continue;
                int max2 = nums[i]+nums[j]+nums[len-1]+nums[len-2];
                if (max2 < target)
                    continue;
                int k = j+1;
                int h = len-1;
                while (k < h){
                    int sum = nums[i]+nums[j]+nums[k]+nums[h];
                    if (sum == target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[k],nums[h]));
                        k ++;
                        h --;
                        while (k < h && nums[k] == nums[k-1])  // 去重
                            k ++;
                        while (k < h && nums[h] == nums[h+1])  // 去重
                            h --;
                    }
                    else if (sum > target)
                        h --;
                    else
                        k ++;
                }
            }
        }
        return result;
    }
}
