package leetcodePractice.HOT100._042接雨水;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class solution {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
    public static int trap(int[] height) {
        /**
         * 按层遍历
         * 时间复杂度大 超时
         */
        /*if (height.length == 0)
            return 0;
        int[] copy = height.clone();
        Arrays.sort(copy);
        int max = copy[copy.length-1];
        int sum = 0;
        for (int i = 1;i <= max;i ++){
            int tempCount = 0;
            int flag = 0;
            for (int j = 0;j < height.length;j ++){
                // 两个if顺序不能换
                if (flag == 1 && height[j] < i){
                    tempCount ++;
                }
                if (height[j] >= i){
                    flag = 1;
                    sum += tempCount;
                    tempCount = 0;
                }
            }
        }
        return sum;*/

        /**
         * 双指针
         */

        /**
         * 栈
         */
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int cur = 0;
        while (cur < height.length){
            while (!stack.empty() && height[cur] > height[stack.peek()]){
                int groove = height[stack.peek()];
                stack.pop();
                if (stack.empty())
                    break;
                int distance = cur-stack.peek()-1; // 两个墙间的距离
                int min = Math.min(height[stack.peek()],height[cur]); // 矮的墙高
                sum += distance*(min-groove);
            }
            stack.push(cur);
            cur ++;
        }
        return sum;
    }
}
