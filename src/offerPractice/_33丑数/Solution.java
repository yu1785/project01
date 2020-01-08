package offerPractice._33丑数;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数
 *
 * 思路：
 *
 */
public class Solution {
    public static void main(String[] args) {
        int index = 7;
        System.out.println(GetUglyNumber_Solution(index));
    }

    /**
     * 方法1：判断每个数是否为丑数，是则记录加一
     *       时间复杂度高  运行超时
     * @param index
     * @return
     */
    /*public static int GetUglyNumber_Solution(int index) {
        int count = 0;
        for (int i = 1;;i ++){
            if (isUgly(i)){
                count ++;
                if (count == index)
                    return i;
            }
        }
    }
    public static boolean isUgly(int number){
        while (number > 1) {
            return isUgly(number / 2) ||
                    isUgly(number / 3) ||
                    isUgly(number / 5);
        }
        if (number == 1)
            return true;
        else
            return false;
    }*/

    /**
     *
     * @param index
     * @return
     */
    public static int GetUglyNumber_Solution(int index) {
        if (index <= 0)
            return 0;
        int[] result = new int[index];
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        result[0] = 1;
        for (int i = 1;i < index;i ++){
            result[i] = Math.min(result[p2]*2,Math.min(result[p3]*3,result[p5]*5));
            if (result[i] == result[p2]*2)
                p2 ++;
            if (result[i] == result[p3]*3)
                p3 ++;
            if (result[i] == result[p5]*5)
                p5 ++;
        }
        return result[index-1];
    }
}
