package offerPractice._56删除链表中重复的结点;

import offerPractice.ListNodeDemo.ListNode;

import java.util.HashSet;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * 思路：1、先记录重复的值，再对结点进行删除
 *      2、遍历的同时删除
 */
public class solution {
    /*public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null)
            return null;
        HashSet<Integer> set = new HashSet<>();
        ListNode pre = pHead;
        ListNode cur = pHead.next;
        while (cur != null){
            if (pre.val == cur.val){
                set.add(cur.val);
            }
            pre = cur;
            cur = cur.next;
        }
        // 注意要先删除头结点
        while (pHead != null && set.contains(pHead.val))
            pHead = pHead.next;
        if (pHead == null)
            return null;
        //再删除中间结点
        pre = pHead;
        cur = pHead.next;
        while (cur != null){
            if (set.contains(cur.val)){
                pre.next = cur.next;
                cur = pre.next;
            }
            else {
                pre = cur;
                cur = cur.next;
            }
        }
        return pHead;
    }*/

    /**
     * 2、遍历的同时删除
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null)
            return null;
        ListNode head = new ListNode(0);
        head.next = pHead;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null){
            if (cur.next != null && cur.val == cur.next.val){
                while (cur.next != null && cur.val == cur.next.val)
                    cur = cur.next;       //去掉前面重复的结点 剩下一个
                cur = cur.next;           //所有的重复结点被去掉完毕
                pre.next = cur;
            }
            else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head.next;
    }
}
