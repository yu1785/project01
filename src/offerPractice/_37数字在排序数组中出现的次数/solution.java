package offerPractice._37数字在排序数组中出现的次数;

import java.util.Arrays;

/**
 * 统计一个数字在排序数组中出现的次数
 *
 * 思路： 二分查找
 *    直接利用数组的二分搜索函数 Array.binarySearch
 */
public class solution {
    public int GetNumberOfK(int [] array , int k) {
        int index = Arrays.binarySearch(array,k);
        if(index < 0)
            return 0;
        int count = 0;
        for (int i = index;i < array.length && array[i] == k;i ++)
            count ++;
        for(int i = index-1; i >= 0 && array[i] == k;i --)
            count ++;
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,3,3,3,4,5};
        System.out.println(GetNumberOfK2(arr,2));
    }
    public static int GetNumberOfK2(int [] array , int k) {
        StringBuffer str = new StringBuffer();
        for (int arr:array) {
            str.append(arr);
        }
        int first = str.indexOf(k+"");
        int last = str.lastIndexOf(k+"");
        if (first==-1 || last==-1)
            return 0;
        return last-first+1;
    }
}
