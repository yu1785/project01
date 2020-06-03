package leetcodePractice.HOT100._206反转链表;

import offerPractice.ListNodeDemo.ListNode;

import java.util.Stack;

/**
 * 反转一个单链表。
 * 进阶: 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(reverseList(head));
    }
    public static ListNode reverseList(ListNode head) {
        /**
         * 利用栈
         */
        /*Stack<ListNode> stack = new Stack<>();
        while (head != null){
            ListNode temp = head.next;
            head.next = null;
            stack.push(head);
            head = temp;
        }
        ListNode node = new ListNode(0);
        head = node;
        while (!stack.isEmpty()){
            node.next = stack.pop();
            node = node.next;
        }
        return head.next;*/

        /**
         * 迭代
         */
        /*ListNode pre = null;  // 存放最终结果
        while (head != null){
            ListNode temp = head.next;
            head.next = pre;  // 将已有的节点接上去 倒序
            pre = head;       // 接好后再赋值给 pre
            head = temp;
        }
        return pre;*/

        /**
         * 递归
         */
        //递归终止条件是当前为空，或者下一个节点为空
        if (head == null || head.next == null)
            return head;
        //这里的cur就是最后一个节点
        ListNode cur = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
}
