package myPractice.排序._1冒泡排序;

/**
 *冒泡排序
 *    比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 *    对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，
 *    这样在最后的元素应该会是最大的数；
 *
 * 平均时间复杂度为 O(n^2)，最好时间复杂度为 O(n)，最坏时间复杂度为 O(n^2)
 * 空间复杂度为 O(1)
 * 冒泡排序是稳定的
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {7,5,6,4,2,3,1};
        int[] result = bubbleSort(array);
        for (int res:result)
            System.out.print(res);
        System.out.println();
        cocktailSort(array);
        for (int arr:array)
            System.out.print(arr);
    }

    /**
     * 冒泡排序
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array){
        if (array.length == 0 || array.length == 1)
            return array;
        for (int i = 0;i < array.length-1;i ++){
            boolean isSwap = false;
            //注意这里 j 的范围 j < array.length-1-i
            for (int j = 0;j < array.length-1-i;j ++){
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    isSwap = true;
                }
            }
            //如果没有交换，说明数组已经有序，不必再排序了
            if (!isSwap)
                break;
        }
        return array;
    }

    /**
     * 算法拓展:
     *    鸡尾酒排序，又称定向冒泡排序、搅拌排序等，是对冒泡排序的改进。
     *    在把最大的数往后面冒泡的同时，把最小的数也往前面冒泡，
     *    同时收缩无序区的左右边界，有序区在序列左右逐渐累积。
     *
     *    鸡尾酒排序是稳定的。它的平均时间复杂度为O(n^2)，
     *    最好情况是待排序列原先就是正序的，时间复杂度为O(n)，
     *    最坏情况是待排序列原先是逆序的，时间复杂度为O(n^2)。
     *    空间复杂度为O(1)。
     * @param array
     */
    public static void cocktailSort(int[] array){
        int left = 0,right = array.length-1;
        while (left < right){
            for (int i = left;i < right;i ++) {
                if (array[i] > array[i + 1])
                    swap(array, i, i + 1);
            }
            right --;
            for (int i = right;i > left;i --) {
                if (array[i] < array[i - 1])
                    swap(array, i, i - 1);
            }
            left ++;
        }
    }

    public static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
