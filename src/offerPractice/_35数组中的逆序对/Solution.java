package offerPractice._35数组中的逆序对;

import java.util.Arrays;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * 思路：利用并归排序
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,0};
        System.out.println(InversePairs(array));
    }

    /**
     * 超时
     * @param array
     * @return
     */
    /*public static int InversePairs(int [] array) {
        int count = 0;
        for (int i = 0;i < array.length-1;i ++){
            for (int j = i+1;j < array.length;j ++)
                if (array[i] > array[j])
                    count ++;
            count %= 1000000007;
        }
        return count;
    }*/

    public static int count = 0;

    /**
     *
     * @param array
     * @return
     */
    public static int InversePairs(int [] array) {
        mergeSort(array,0,array.length-1);
        return count;
    }

    /**
     *
     * @param array
     * @param start
     * @param end
     */
    public static void mergeSort(int[] array,int start,int end){
        if (start >= end)
            return;
        int mid = (start+end)/2;
        mergeSort(array,start,mid);
        mergeSort(array,mid+1,end);
        merge(array,start,mid,end);
    }

    /**
     *
     * @param array
     * @param start
     * @param mid
     * @param end
     */
    public static void merge(int[] array,int start,int mid,int end){
        int[] result = new int[end-start+1];
        int k = 0, i = start, j = mid+1;
        while (i <= mid && j <= end){
            if (array[i] < array[j])
                result[k ++] = array[i ++];
            else {
                result[k ++] = array[j ++];
                count = (count + (mid-i+1))%1000000007;
            }
        }
        while (i <= mid)
            result[k ++] = array[i ++];
        while (j <= end)
            result[k ++] = array[j ++];
        for(int l=0; l<k; l++){              //重写排序后的数组array
            array[start+l] = result[l];
        }
    }
}
