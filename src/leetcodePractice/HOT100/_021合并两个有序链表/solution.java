package leetcodePractice.HOT100._021合并两个有序链表;

import offerPractice.ListNodeDemo.ListNode;

public class solution {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        head1.next = l1;
        l1.next = l2;

        ListNode head2 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        head2.next = l3;
        l3.next = l4;

        ListNode head = new ListNode(0);
        head.next = mergeTwoLists(head1,head2);
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /**
         * 递归
         */
        /*if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }*/

        /**
         * 迭代
         */
        ListNode head = new ListNode(0);
        // 注意设置中间节点用于后续操作 不能直接使用head
        ListNode cur = head;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return head.next;
    }
}
