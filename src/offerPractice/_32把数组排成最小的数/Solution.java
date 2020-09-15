package offerPractice._32把数组排成最小的数;

import java.util.Arrays;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323
 *
 * 思路：
 *    遍历数组，拼接两数组，比较大小，交换数组位置，使拼接后字符串较小的数组在前面
 */
public class Solution {
    public static void main(String[] args) {
        int[] numbers = {3,32,321};
        System.out.println(PrintMinNumber(numbers));
        System.out.println(minNumber(numbers));
    }

    /**
     * 普通排序
     * @param numbers
     * @return
     */
    public static String PrintMinNumber(int [] numbers) {
        if (numbers == null)
            return "";
        for (int i = 0;i < numbers.length-1;i ++){
            for (int j = i+1;j < numbers.length;j ++){
                String str1 = numbers[i]+""+numbers[j];
                String str2 = numbers[j]+""+numbers[i];
                if (str1.compareTo(str2) > 0){
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        String str = new String();
        for (int num:numbers)
            str += num+"";
        return str;
    }

    //内置函数  快排
    public static String minNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str,(x,y)->(x+y).compareTo(y+x));
        String res = "";
        for(String s:str){
            res += s;
        }
        return res;
    }
}
