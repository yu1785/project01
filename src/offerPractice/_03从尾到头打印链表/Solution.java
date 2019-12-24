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
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null){          //注意这里使用if而不是while
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
}


