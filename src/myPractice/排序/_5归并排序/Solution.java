package myPractice.排序._5归并排序;

import java.util.Arrays;

/**
 * 归并排序
 *     归并排序是建立在归并操作上的一种有效的排序算法。
 *     该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
 *     将已有序的子序列合并，得到完全有序的序列；
 *     即先使每个子序列有序，再使子序列段间有序。
 *     若将两个有序表合并成一个有序表，称为2-路归并
 *
 *     1.把长度为 n 的输入序列分成两个长度为 n / 2 的子序列；
 *     2.对这两个子序列分别采用归并排序；
 *     3.将两个排序好的子序列合并成一个最终的排序序列。
 *
 *  平均时间复杂度为O(nlogn)，最好时间复杂度为O(nlogn)，最坏时间复杂度为O(nlogn)
 *      归并排序的形式就是一棵二叉树，它需要遍历的次数就是二叉树的深度，
 *      而根据完全二叉树的可以得出它在任何情况下时间复杂度均是O(nlogn)
 *  空间复杂度为O(n)
 *  稳定的
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {7,5,6,4,2,3,1};
        array = mergeSort(array);
        for (int arr:array)
            System.out.print(arr);
    }

    /**
     * 归并排序
     * @param array
     * @return
     */
    public static int[] mergeSort(int[] array){
        if (array.length < 2)
            return array;
        int mid = array.length/2;
        int[] left = Arrays.copyOfRange(array,0,mid);
        int[] right = Arrays.copyOfRange(array,mid,array.length);
        return merge(mergeSort(left),mergeSort(right));
    }

    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left,int[] right){
        int[] result = new int[left.length+right.length];
        int leftIndex = 0,rightIndex = 0;
        for (int index = 0;index < result.length;index ++){
            if (leftIndex >= left.length)             // 左边数组用完
                result[index] = right[rightIndex++];
            else if (rightIndex >= right.length)      // 右边数组用完
                result[index] = left[leftIndex++];
            else if (left[leftIndex] > right[rightIndex])      // 左边数组较大 取右边数组元素
                result[index] = right[rightIndex++];
            else                                      // 右边数组较大 取左边数组元素
                result[index] = left[leftIndex++];
        }
        return result;
    }
}
