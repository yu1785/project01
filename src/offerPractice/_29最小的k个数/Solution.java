package offerPractice._29最小的k个数;

/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,
 *
 * 思路：
 *    利用Arrays.sort()方法对数组进行排序，前K个元素即为所求
 *    注意边缘条件
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] array = {4,5,1,6,2,7,3,8};
        int k = 4;
        System.out.println(GetLeastNumbers_Solution(array,4));
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        //注意边缘条件
        if (input == null || k > input.length || k <= 0)
            return list;
        Arrays.sort(input);
        int count = 0;
        for (int i = 0;i < k;i ++)
            list.add(input[i]);
        return list;
    }
}
