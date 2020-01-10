package myPractice.排序._3插入排序;

/**
 * 插入排序
 *     一种简单直观的排序算法。它的工作原理是:
 *     通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 *
 *     平均时间复杂度：O(n^2)，最好时间复杂度 O(n)，最坏时间复杂度 O(n^2)
 *     空间复杂度: O(1)      稳定
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {7,5,6,4,2,3,1};
        int[] result = insertSort(array);
        for (int res:result)
            System.out.print(res);
        System.out.println();
        binaryInsertSort(array);
        for (int arr:array)
            System.out.print(arr);
    }

    /**
     * 直接插入排序：
     *     平均时间复杂度：O(n^2)，最好时间复杂度 O(n)，最坏时间复杂度 O(n^2)
     *     空间复杂度: O(1)
     *     稳定
     * @param array
     * @return
     */
    public static int[] insertSort(int[] array){
        if (array.length == 0 || array.length == 1)
            return array;
        for (int i = 0;i < array.length-1;i ++){
            int current = array[i+1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]){
                array[preIndex+1] = array[preIndex];
                preIndex --;
            }
            array[preIndex+1] = current;
        }
        return array;
    }

    /**
     * 二分插入排序：
     *     在直接插入排序中，待插入的元素总是在有序区线性查找合适的插入位置，
     *     没有利用有序的优势，考虑使用二分查找搜索插入位置进行优化
     *
     *     二分插入排序是稳定的。它的平均时间复杂度是O(n^2)，
     *     最好时间复杂度为O(nlogn)，最坏时间复杂度为O(n^2)。
     * @param array
     */
    public static void binaryInsertSort(int[] array){
        if (array.length == 0 || array.length == 1)
            return;
        for (int i = 0;i < array.length-1;i ++){
            int left = 0;
            int right = i;
            int current = array[i+1];
            while (left <= right){
                int mid = left+(right-left)/2;
                if (array[mid] > current)
                    right = mid-1;
                else
                    left = mid+1;
            }
            for (int j = i;j >= left;j --)
                array[j+1] = array[j];
            array[left] = current;
        }
    }
}
