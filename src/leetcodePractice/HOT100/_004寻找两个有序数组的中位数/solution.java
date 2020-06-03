package leetcodePractice.HOT100._004寻找两个有序数组的中位数;
/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 思路：看到时间复杂度为log 因想到二分查找
 */

import java.util.ArrayList;
import java.util.Collections;

public class solution {
    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {1};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /**
         * 先合并 再找中位数
         * 时间复杂度大
         */
        /*ArrayList<Integer> list = new ArrayList<>();
        for (int nu:nums1)
            list.add(nu);
        for (int nu:nums2)
            list.add(nu);
        Collections.sort(list);
        int length = list.size();
        if (length%2 == 0)
            return (double) (list.get(length/2)+list.get(length/2-1))/2;
        else
            return (double) list.get((length-1)/2);*/

        /**
         * 不用合并 直接找中位数
         * 时间复杂度减小
         */
        /*int length = nums1.length+nums2.length;
        int left=0,right=0;
        int p1 = 0,p2 = 0;
        for (int i = 0;i <= length/2;i ++){
            left = right;
            //先判断指针p1是否越界，再判断p2指针是否越界，在比较数组中值的大小
            if (p1 < nums1.length && (p2 >= nums2.length || nums1[p1] <= nums2[p2]))
                right = nums1[p1 ++];
            else
                right = nums2[p2 ++];
        }
        if (length%2 == 0)
            return (left+right)/2.0;
        else
            return right;*/

        /**
         * 二分查找
         */
        int len1 = nums1.length;
        int len2 = nums2.length;
        int p1 = 0,p2 = 0;
        int len = len1+len2;
        int k = len/2;
        while (k > 1){
            int index1 = p1+k-1;
            int index2 = p2+k-1;
            index1 = index1<nums1.length-1 ? index1:nums1.length-1;
            index2 = index2<nums2.length-1 ? index2:nums2.length-1;
            if (nums1[index1] < nums1[index2]){
                if (index1 == nums1.length-1)
                    return nums2[len-nums2.length-1];
                p1 += k;
            }
            else
                p2 += k;
            len -= k;
            k = len/2;
        }
        return nums1[p1] < nums2[p2] ? nums1[p1] : nums2[p2];
    }
}
