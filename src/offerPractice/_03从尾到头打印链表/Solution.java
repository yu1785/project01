package offerPractice._03从尾到头打印链表;
/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList
 *
 * 思路：
 *   从尾到头 先进后出 压栈
 *   递归
 */

import offerPractice.ListNodeDemo.ListNode;
import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode num1 = new ListNode(81);
        ListNode num2 = new ListNode(61);
        ListNode num3 = new ListNode(95);
        head.setNext(num1);
        num1.setNext(num2);
        num2.setNext(num3);
        printListFromTailToHead(head);
        System.out.println(list);
    }
    // 1.递归
    /*public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null){          //注意这里使用if而不是while
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }*/

    // 2.非递归 利用栈
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }

    // 3.调用函数
    // ArrayList 中有个方法是 add(index,value)，可以指定 index 位置插入 value 值
//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        ListNode tmp = listNode;
//        while(tmp!=null){
//            list.add(0,tmp.val);
//            tmp = tmp.next;
//        }
//        return list;
//    }

}


