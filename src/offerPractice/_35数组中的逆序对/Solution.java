package offerPractice._35数组中的逆序对;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,0};
        System.out.println(InversePairs(array)%1000000007);
    }

    /**
     * 超时
     * @param array
     * @return
     */
    public static int InversePairs(int [] array) {
        int count = 0;
        for (int i = 0;i < array.length-1;i ++){
            for (int j = i+1;j < array.length;j ++)
                if (array[i] > array[j])
                    count ++;
            count %= 1000000007;
        }
        return count;
    }
}
