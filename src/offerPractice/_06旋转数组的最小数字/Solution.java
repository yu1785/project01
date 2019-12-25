package offerPractice._06旋转数组的最小数字;

import java.util.Arrays;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 思路：
 *    1.暴力       时间复杂度：O(n)
 *    2.排序       时间复杂度：O(nlogn)    利用 Arrays 工具类里的排序函数
 *    3.二分查找   时间复杂度：O(logn)
 */

public class Solution {
    public static void main(String[] args) {
        int [] array = {3,4,5,1,2};
        System.out.println(minNumberInRotateArray(array));
    }
    public static int minNumberInRotateArray(int [] array) {
        if (array.length == 0)
            return 0;

        //1.暴力
        /*for (int i = 1;i < array.length;i ++)
            if (array[i] < array[i-1])
                return array[i];
        return array[0];*/

        //2.排序
        Arrays.sort(array);
        return array[0];
    }
}
