package leetcodePractice.HOT100._155最小栈;

import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *      push(x) -- 将元素 x 推入栈中。
 *      pop() -- 删除栈顶的元素。
 *      top() -- 获取栈顶元素。
 *      getMin() -- 检索栈中的最小元素。
 */
class MinStack {
    /**
     * 利用两个栈
     */
    /*private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (!minStack.isEmpty()){
            if (x <= minStack.peek())
                minStack.push(x);
        }
        else
            minStack.push(x);
    }

    public void pop() {
        // 报错  原因未知
//        if (minStack.peek() == stack.peek())
//            minStack.pop();
//        stack.pop();

         int topStack = stack.pop();
         int topMinStack = minStack.peek();
         if (topStack == topMinStack)
             minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }*/

    /**
     * 利用一个栈
     */
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> stack;
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        // 注意这里应该是 <=
        if (x <= min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == min)
            min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
