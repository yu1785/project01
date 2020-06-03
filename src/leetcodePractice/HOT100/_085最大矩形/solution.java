package leetcodePractice.HOT100._085最大矩形;

import java.util.Stack;

/**
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 */
public class solution {
    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','1','1'},
                            {'0','1','0','1','0'},
                            {'1','1','0','1','1'},
                            {'1','1','0','1','1'},
                            {'0','1','1','1','1'}};
        System.out.println(maximalRectangle(matrix));
    }

    /**
     * 利用上一题最大矩形算法
     * 按行遍历 返回最大矩阵
     * @param matrix
     * @return
     */
    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int[] height = new int[matrix[0].length];
        int maxArea = 0;
        for (int row = 0;row < matrix.length;row ++){
            for (int col = 0;col < matrix[row].length;col ++){
                if (matrix[row][col] == '1')
                    height[col] += 1;
                else
                    height[col] = 0;
            }
            maxArea = Math.max(maxArea,largestRectangleArea(height));
        }
        return maxArea;

        /*if (matrix.length == 0) {
            return 0;
        }
        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for (int row = 0; row < matrix.length; row++) {
            //遍历每一列，更新高度
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == '1') {
                    heights[col] += 1;
                } else {
                    heights[col] = 0;
                }
            }
            //调用上一题的解法，更新函数
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;*/
    }

    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0;i <heights.length;i ++){
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxArea = Math.max(maxArea,heights[stack.pop()]*(i-stack.peek()-1));
            stack.push(i);
        }
        while (stack.peek() != -1){
            maxArea = Math.max(maxArea,heights[stack.pop()]*(heights.length-stack.peek()-1));
        }
        return maxArea;

        /*int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int p = 0;
        while (p < heights.length) {
            //栈空入栈
            if (stack.isEmpty()) {
                stack.push(p);
                p++;
            } else {
                int top = stack.peek();
                //当前高度大于栈顶，入栈
                if (heights[p] >= heights[top]) {
                    stack.push(p);
                    p++;
                } else {
                    //保存栈顶高度
                    int height = heights[stack.pop()];
                    //左边第一个小于当前柱子的下标
                    int leftLessMin = stack.isEmpty() ? -1 : stack.peek();
                    //右边第一个小于当前柱子的下标
                    int RightLessMin = p;
                    //计算面积
                    int area = (RightLessMin - leftLessMin - 1) * height;
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        while (!stack.isEmpty()) {
            //保存栈顶高度
            int height = heights[stack.pop()];
            //左边第一个小于当前柱子的下标
            int leftLessMin = stack.isEmpty() ? -1 : stack.peek();
            //右边没有小于当前高度的柱子，所以赋值为数组的长度便于计算
            int RightLessMin = heights.length;
            int area = (RightLessMin - leftLessMin - 1) * height;
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;*/
    }
}
