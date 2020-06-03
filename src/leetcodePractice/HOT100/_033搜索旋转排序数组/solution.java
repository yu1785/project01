package leetcodePractice.HOT100._033搜索旋转排序数组;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 看到 O(log n) 条件反射想到二分查找
 */

public class solution {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums,0));
    }
    public static int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        int start = 0,end = nums.length-1;
        int mid;
        while (start <= end){
            mid = start + (end-start)/2;
            if (nums[mid] == target)
                return mid;
            // 前半部分有序
            if (nums[start] <= nums[mid]){
                if (nums[start] <= target && nums[mid] > target)
                    end = mid-1;
                else
                    start = mid+1;
            }
            // 后半部分有序
            else {
                if (nums[end] >= target && nums[mid] < target)
                    start = mid+1;
                else
                    end = mid-1;
            }
        }
        return -1;
    }
}
