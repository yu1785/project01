package offerPractice._42和为S的两个数字;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。 输出两个数，小的先输出
 */
public class solution {
    public static void main(String[] args) {
        int[] array = {1,2,4,7,11,15};
        int sum = 15;
        System.out.println(FindNumbersWithSum(array,sum));
    }
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        //注意边缘条件
        if (array.length < 2)
            return list;
        int pHead = 0;
        int pTail = array.length-1;
        int currentSum = array[pHead] + array[pTail];
        while (pHead < pTail){
            if (currentSum < sum)
                currentSum = array[++pHead] + array[pTail];
            else  if (currentSum > sum)
                currentSum = array[pHead] + array[--pTail];
            else {
                //最外层的乘积最小
                list.add(array[pHead]);
                list.add(array[pTail]);
                break;
            }
        }
        return list;
    }
}
