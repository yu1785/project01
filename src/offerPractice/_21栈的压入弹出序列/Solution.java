package offerPractice._21栈的压入弹出序列;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 *
 * 思路：
 *    创建一个栈 根据给出的 push pop 元素执行压入弹出操作 最后栈为空则正确 反之错误
 */
public class Solution {
    public static void main(String[] args) {
        int[] push = {1,2,3,4,5};
//        int[] pop = {4,5,3,2,1};
        int[] pop = {4,3,5,1,2};
        System.out.println(IsPopOrder(push,pop));
    }
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0 || popA.length == 0 || pushA.length != popA.length)
            return false;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int pu:pushA){
            stack.push(pu);
            // 用while不用if
            while (!stack.empty() && stack.peek() == popA[i]){
                stack.pop();
                i ++;
            }
        }
        return stack.empty();
    }
}
