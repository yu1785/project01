package leetcodePractice.HOT100._019删除链表的倒数第N个节点;

import offerPractice.ListNodeDemo.ListNode;

public class solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode node = removeNthFromEnd(head,2);
        System.out.println(node.val);
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        /**
         * 两次遍历链表 第一遍先找出链表长度 第二遍进行节点删除
         */
        /*ListNode node = new ListNode(0);
        node.next = head;
        // 注意这里一定要定义一个中间链表进行操作 不能直接使用node
        ListNode cur = node;
        int len = 0;
        while (cur.next != null){
            len ++;
            cur = cur.next;
        }
        cur = node;
        int index = len-n;
        while (index > 0){
            index --;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return node.next;*/

        /**
         * 一次遍历链表 两个指针
         */
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode p1 = node;
        ListNode p2 = node;
        for (int i = 0;i < n;i ++)
            p1 = p1.next;
        while (p1.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return node.next;
    }
}
