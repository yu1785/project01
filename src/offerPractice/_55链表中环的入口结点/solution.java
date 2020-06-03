package offerPractice._55链表中环的入口结点;

import offerPractice.ListNodeDemo.ListNode;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class solution {
    /**
     * 这里可以自己画图列一下方程。
     * 快慢指针法，快指针一次走两步，慢指针一次走一步，当快慢指针第一次相遇时
     * 2（x+y）=n圈周长+x+y，
     * 这里x+y是慢指针走的长度，n圈周长+x+y是快指针走的长度
     * x = n圈周长-y；
     * 即当快指针回到head和慢指针以同样速度每次走一步，最终会在链表中环的入口结点处相遇。
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return null;
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        while (fast != slow){
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = pHead;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
