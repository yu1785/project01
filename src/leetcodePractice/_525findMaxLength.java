package leetcodePractice;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）
 *
 * 思路：哈希表
 */

public class _525findMaxLength {
    public static void main(String[] args) {
        int[] nums = {0,0,1,0,0,0,1,1};
        int maxLength = findMaxLength(nums);
        System.out.println(maxLength);
    }
    public static int findMaxLength(int[] nums) {
        /**
         * 暴力解 超时
         */
       /* int maxAll = 0;
        for (int i = 0;i < nums.length;i ++){
            int count = 0;
            int max = 0;
            for (int j = i;j < nums.length;j ++){
                if (nums[j] == 1)
                    count ++;
                else
                    count --;
                if (count == 0 && (j-i+1)%2 == 0)
                    max = j-i+1;
                System.out.println(count+"  "+max);
            }
            if (max > maxAll)
                maxAll = max;
        }
        return maxAll;*/

        /**
         * 利用哈希表 HashMap(),分别存放count值和下标索引index
         * 两个相同的count值所对应的最大区间 为最大长度
         */
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0,maxLength = 0;
        map.put(0,-1);  //初值 count为0 index为-1
        for (int i = 0;i < nums.length;i ++){

            //普通if-else语句
            /*if (nums[i] == 1)
                count ++;
            else
                count --;*/

            //使用三目运算符 代码简洁 可读性强 执行效率差别不大
            count = count + (nums[i]==1 ? 1:-1);
            if (map.containsKey(count))
                maxLength = Math.max(maxLength,i-map.get(count));
            else
                map.put(count,i);
        }
        return maxLength;
    }
}
