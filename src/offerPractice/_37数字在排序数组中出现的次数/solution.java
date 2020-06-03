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
}
