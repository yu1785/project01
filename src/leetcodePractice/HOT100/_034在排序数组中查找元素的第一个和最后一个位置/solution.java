package leetcodePractice.HOT100._034在排序数组中查找元素的第一个和最后一个位置;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别
 * 如果数组中不存在目标值，返回 [-1, -1]。
 */
public class solution {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] res = new int[2];
        res = searchRange(nums,6);
        System.out.println(res[0]+" "+res[1]);
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int start = 0,end = nums.length-1;
        int mid;
        while (start <= end){
            mid = start + (end-start)/2;
            if (nums[mid] == target){
                int p1 = mid-1;
                int p2 = mid+1;
                while (p1 >= 0 && nums[p1] == target){
                    p1 --;
                }
                res[0] = p1+1;
                while (p2 < nums.length && nums[p2] == target){
                    p2 ++;
                }
                res[1] = p2-1;
                return res;
            }
            else if (nums[mid] < target)
                start = mid+1;
            else if (nums[mid] > target)
                end = mid-1;
        }
        return new int[]{-1,-1};
    }
}
