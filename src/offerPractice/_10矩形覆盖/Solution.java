package offerPractice._10矩形覆盖;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 思路: 递归
 */
public class Solution {
    public int RectCover(int target) {
        //递归
        /*if (target == 0 || target == 1 || target == 2)
            return target;
        else
            return RectCover(target-1)+RectCover(target-2);*/

        //优化递归
        int num1 = 1;
        int num2 = 2;
        int sum = 0;
        if (target == 0 || target == 1 || target == 2)
            return target;
        else {
            for (int i = 3;i <= target;i ++){
                sum = num1 + num2;
                num1 = num2;
                num2 = sum;
            }
            return sum;
        }
    }
}
