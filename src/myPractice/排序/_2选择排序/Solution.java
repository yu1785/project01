package myPractice.排序._2选择排序;

/**
 * 选择排序
 *     一种简单直观的排序算法。它的工作原理：
 *     首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 *     然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 *     以此类推，直到所有元素均排序完毕。
 *
 * 表现最稳定的排序算法之一，因为无论什么数据进去都是O(n^2)的时间复杂度，
 * 所以用到它的时候，数据规模越小越好
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {7,5,6,4,2,3,1};
        int[] result = selectSort(array);
        for (int res:result)
            System.out.print(res);
    }

    /**
     * 选择排序：
     *     时间复杂度 O(n^2)  空间复杂度 O(1)  稳定
     * @param array
     * @return
     */
    public static int[] selectSort(int[] array){
        if (array.length == 0 || array.length == 1)
            return array;
        for (int i = 0;i < array.length;i ++){
            //记录最小元素的下标
            int minIndex = i;
            //找出最小的元素，并记录下标
            for (int j = i;j < array.length;j ++){
                if (array[j] < array[minIndex])
                    minIndex = j;
            }
            //交换当前元素与最小元素的值
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }
}
