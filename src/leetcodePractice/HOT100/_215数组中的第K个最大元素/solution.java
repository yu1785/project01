package leetcodePractice.HOT100._215数组中的第K个最大元素;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 在未排序的数组中找到第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class solution {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums,2));
    }
    public static int findKthLargest(int[] nums, int k) {
        /**
         * 排序
         */
        /*Arrays.sort(nums);
        return nums[nums.length-k];*/
        
        /**
         * 小顶堆 优先队列
         */
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1,n2) -> n1-n2);
        for (int nu:nums){
            heap.add(nu);
            if (heap.size() > k)
                heap.poll();
        }
        return heap.poll();
    }
}
