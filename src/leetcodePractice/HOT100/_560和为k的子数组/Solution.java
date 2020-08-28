package leetcodePractice.HOT100._560和为k的子数组;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yu
 * @date 2020/8/12 17:53
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {0,0,0};
        int k = 0;
        int res = subarraySum2(nums,k);
        System.out.println(res);
        final ReentrantLock reentrantLock = new ReentrantLock();
    }

    /**
     * 暴力解
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k){
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k){
                    count ++;
                }
            }
        }
        return count;
    }

    /**
     * 前缀和 + 哈希表优化
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum2(int[] nums, int k){
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre-k))
                count += map.get(pre-k);
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }

    /**
     * 滑动窗口 不对  //TODO
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum1(int[] nums, int k){
        int len = nums.length;
        if (len==1 && nums[0]!=k)
            return 0;
        int count = 0;
        int sum = 0;
        int start = 0,end = 0;
        while (start <= end && end < len){
            if (start == end)
                sum += nums[start];
            else
                sum += nums[start] + nums[end];
            if (sum < k){
                end ++;
            }else if (sum > k){
                sum -= nums[start];
                start ++;
            }else {
                count ++;
                if (end == len-1)
                    start ++;
                else
                    end ++;
            }
        }
        return count;
    }
}
