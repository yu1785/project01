package offerPractice._13调整数组顺序使奇数位于偶数前面;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * 思路：
 *    新创建两个ArrayList存放奇偶数，最后合并
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(array));   // 打印数组 利用Arrays.toString()方法
        reOrderArray(array);
        for (int arr:array) {
            System.out.print(arr+" ");
        }
    }

    public static void reOrderArray(int [] array) {
        //1.ArrayList
        /*ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int arr:array){
            if (arr == 0)
                list2.add(arr);
            else if (arr == 1)
                list1.add(arr);
            else if (arr%2 == 0)
                list2.add(arr);
            else
                list1.add(arr);
        }
        list1.addAll(list2);
        for (int i= 0;i < array.length;i ++)
            array[i] = list1.get(i);*/

        // 2 不开辟新空间 在原数组上进行移位
        int p1 = 0;
        for (int p2 = 0; p2 < array.length; p2++) {
            // 可以使用位运算进行判断 array[p2]&1
            if (array[p2]%2 != 0){
                int temp = array[p2];
                for (int i = p2-1; i >= p1 ; i--) {
                    array[i+1] = array[i];
                }
                array[p1++] = temp;
            }
        }

    }
}
