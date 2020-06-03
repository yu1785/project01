package leetcodePractice.HOT100._084柱状图中最大的矩形;

import java.util.Stack;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class solution {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

    /**
     * 栈
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0;i < heights.length;i ++){
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                // i-stack.peek()-1 ：  因为前面有了pop操作 peek值为-1 所以后面再减一
                maxArea = Math.max(maxArea,heights[stack.pop()]*(i-stack.peek()-1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            // 将栈中剩余元素挨个弹出 直到栈顶为-1
            maxArea = Math.max(maxArea,heights[stack.pop()]*(heights.length-stack.peek()-1));
        return maxArea;
    }
}
