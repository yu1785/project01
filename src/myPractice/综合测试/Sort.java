package myPractice.综合测试;

import java.util.Arrays;

/**
 * @author yu
 * @date 2020/7/6 16:54
 */
public class Sort {
    public static void main(String[] args) {

    }

    /*
        经典排序算法  ：
            1. 交换： 冒泡排序
                     快速排序
            2. 插入： 直接插入排序
                     希尔排序
            3. 选择： 直接选择排序
                     堆排序
            4. 归并
    */

    /**
     * 冒泡排序
     * 平均时间复杂度为 O(n^2)，最好时间复杂度为 O(n)，最坏时间复杂度为 O(n^2)
     * 空间复杂度为 O(1)
     * 冒泡排序是稳定的
     * @param arr
     * @return
     */
    public static void bubbleSort(int[] arr){
        if (arr.length == 0 || arr.length == 1)
            return;
        for (int i = 0; i < arr.length-1; i++) {
            boolean isSwap = false;
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSwap = true;
                }
            }
            if (!isSwap){
                break;
            }
        }
    }

    /**
     * 快速排序
     * 平均时间复杂度为O(nlogn)，最好时间复杂度为O(nlogn)，最坏时间复杂度为O(n^2)
     * 平均空间复杂度为O(logn):
     *     在最好情况下，即partition函数每次恰好能均分序列，空间复杂度为O(logn)；
     *     在最坏情况下，即退化为冒泡排序，空间复杂度为O(n)。
     * 不稳定
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr,int left,int right){
        if (arr.length < 2)
            return;
        if (left < right){
            int mid = partition(arr,left,right);
            quickSort(arr,left,mid-1);
            quickSort(arr,mid+1,right);
        }
    }
    public static int partition(int[] arr,int left,int right){
        int start = left;
        int end = right;
        int key = left;
        while (start < end){
            while (start < end && arr[start] <= arr[key])
                start ++;
            while (start < end && arr[end] >= arr[key])
                end -- ;
            swap(arr,start,end);
        }
        swap(arr,start,key);
        return start;
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 直接插入排序
     * 平均时间复杂度：O(n^2)，最好时间复杂度 O(n)，最坏时间复杂度 O(n^2)
     * 空间复杂度: O(1)
     * 稳定
     * @param arr
     */
    public static void insertSort(int[] arr){
        if (arr.length < 2)
            return;
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int preIndex = i-1;
            while (preIndex >= 0 && current < arr[preIndex]){
                arr[preIndex+1] = arr[preIndex];
                preIndex --;
            }
            arr[preIndex+1] = current;
        }
    }


    /**
     *  希尔排序
     *  平均时间复杂度为O(nlogn)，
     *  希尔排序的时间复杂度与增量序列的选取有关
     *  空间复杂度为O(1)
     *  不稳定
     * @param arr
     */
    public static void shellSort(int[] arr){
        if (arr.length < 2)
            return;
        int gap = arr.length/2;
        while (gap > 0){
            for (int i = gap; i < arr.length; i++) {
                int current = arr[gap];
                int preIndex = i-gap;
                while (preIndex >= 0 && current < arr[preIndex]){
                    arr[preIndex+gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex+gap] = current;
            }
            gap /= 2;
        }
    }


    /**
     * 选择排序：
     *    时间复杂度 O(n^2)  空间复杂度 O(1)  不稳定
     * @param arr
     */
    public static void selectSort(int[] arr){
        if (arr.length < 2)
            return;
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            swap(arr,i,minIndex);
        }
    }


    /**
     *  归并排序
     *  平均时间复杂度为O(nlogn)，最好时间复杂度为O(nlogn)，最坏时间复杂度为O(nlogn)
     *  空间复杂度为O(n)
     *  稳定的
     * @param arr
     * @return
     */
    public static int[] mergeSort(int[] arr){
        if (arr.length < 2)
            return arr;
        int mid = arr.length/2;
        int[] left = Arrays.copyOfRange(arr,0,mid);
        int[] right = Arrays.copyOfRange(arr,mid,arr.length);
        return merge(mergeSort(left),mergeSort(right));
    }
    public static int[] merge(int[] left,int [] right){
        int[] result = new int[left.length+right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        for (int index = 0; index < result.length; index++) {
            if (leftIndex >= left.length)
                result[index] = right[rightIndex++];
            else if (rightIndex >= right.length)
                result[index] = left[leftIndex++];
            else if (left[leftIndex] < right[rightIndex])
                result[index] = left[leftIndex++];
            else
                result[index] = right[rightIndex++];
        }
        return result;
    }

}
