package myPractice.排序._4希尔排序;

/**
 *希尔排序
 *    是直接插入排序的改进版。又叫缩小增量排序
 *    按标的一定增量分组，对每组使用直接插入排序算法排序；
 *    随着增量逐渐减少，每组包含的关键词越来越多，
 *    当增量减至1时，整个文件恰被分成一组，算法便终止
 *
 *    平均时间复杂度为O(nlogn)，
 *    希尔排序的时间复杂度与增量序列的选取有关
 *    空间复杂度为O(1)
 *    不稳定
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {7,5,6,4,2,3,1};
        shellSort(array);
        for (int arr:array)
            System.out.print(arr);
    }

    /**
     * 希尔排序
     * @param array
     */
    public static void shellSort(int[] array){
        int len = array.length;
        if (len == 0 || len == 1)
            return;
        int gap = len/2;
        while (gap > 0){
            for (int i = gap;i < len;i ++){
                int current = array[i];
                int preIndex = i-gap;
                while (preIndex >= 0 && array[preIndex] > current){
                    array[preIndex+gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex+gap] = current;
            }
            gap /= 2;
        }
    }
}
