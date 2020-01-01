package offerPractice._20包含min函数的栈;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数
 * （时间复杂度应为O（1））
 *
 * 思路：
 *    利用两个栈 一个存放数据
 *    一个辅助栈用于存放最小元素
 *    当后压入栈元素比之前的元素大时 此时在辅助栈中压入栈中原有的最小元素
 */
public class Solution {
    public static Stack<Integer> stackData = new Stack<>();
    public static Stack<Integer> stackMin = new Stack<>();
    public static void main(String[] args) {

    }
    public static void push(int node) {
        stackData.push(node);
        if (stackMin.empty())
            stackMin.push(node);
        else{
            if (node < stackMin.peek())
                stackMin.push(node);
            else
                stackMin.push(stackMin.peek());
        }
    }

    public static void pop() {
        stackData.pop();
//        if (stackData.peek() == stackMin.peek())
        /* 这里的判断不需要
         因为在stackMin的存放中 当stackData中push入的元素较大时
         会在stackMin中push入stackMin栈顶元素*/
            stackMin.pop();
    }

    public static int top() {
        return stackData.peek();
    }

    public static int min() {
        return stackMin.peek();
    }
}
