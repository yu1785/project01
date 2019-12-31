package offerPractice._15反转链表;

import offerPractice.ListNodeDemo.ListNode;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        head.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        head.getList(head);
        ListNode reverse = ReverseList(head);
        reverse.getList(reverse);
    }
    public static ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null)
            return  head;
        ListNode preNode = null;
        ListNode nextNode = null;
        ListNode reverseNode = null;
        ListNode currentNode = head;
        while (currentNode != null){     //注意while的条件
            nextNode = currentNode.next;
            if (nextNode == null)
                reverseNode = currentNode;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
        }
        return reverseNode;

        /*if (head == null || head.next == null)
            return  head;
        ListNode preNode = null;
        ListNode nextNode = null;
        while (head != null){
            nextNode = head.next;
            head.next = preNode;
            preNode = head;
            head = nextNode;
        }
        return preNode;*/
    }
}
