package leetcodePractice.HOT100._160相交链表;

import edu.princeton.cs.algs4.Stack;
import offerPractice.ListNodeDemo.ListNode;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /**
         * 双指针
         * 连接两个链表 消除长度差
         */
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
