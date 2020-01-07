package offerPractice._30连续子数组的最大和;

/**
 * 给一个数组，返回它的最大连续子序列的和(子向量的长度至少是1)
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)
 *
 * 思路：
 *    1.
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {6,-3,-2,7,-15,1,2,2};
//        int[] array = {-2,-8,-1,-5,-9};
//        int[] array = {1,- 2, 3, 10, -4, 7, 2, -5};
        System.out.println(FindGreatestSumOfSubArray(array));
    }

    /**
     * 方法1：遍历数组，若当前元素 arr < 0，则记前面元素和为最大 maxSum；
     *       若后面继续累加和 sum > maxSum,更新 maxSum 的值
     *       若当前sum < 0，则舍弃前面元素，重新开始
     * @param array
     * @return
     */
    /*public static int FindGreatestSumOfSubArray(int[] array) {
        if (array == null)
            return 0;
        if (array.length == 1)
            return array[0];
        int sum = 0;
        int maxSum = array[0];
        for (int arr:array){
            if (sum < 0)
                sum = arr;
            else
                sum += arr;
            if (sum > maxSum)
                maxSum = sum;
        }
        return maxSum;
    }*/

    /**
     * 方法2：动态规划
     *      用函数f(i)表示以第i个数字结尾的子数组的最大和
     *      f(i) = array[i]          , i=0 || f(i-1)<0
     *           = f(i-1)+array[i]   , i>0 && f(i-1)>0
     * @param array
     * @return
     */
    public static int FindGreatestSumOfSubArray(int[] array) {
        if (array == null)
            return 0;
        int maxSum = array[0];
        for (int i = 1;i < array.length;i ++){
            array[i] += array[i-1]>0 ? array[i-1]:0;
            maxSum = Math.max(maxSum,array[i]);
        }
        return maxSum;
    }
}
