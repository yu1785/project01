package leetcodePractice.HOT100._142环形链表II;

import offerPractice.ListNodeDemo.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 */
public class solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        head.next = node1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node1;
        System.out.println(detectCycle(head));
    }

    /**
     * HashSet
     * @param head
     * @return
     */
    /*public static ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if (!set.contains(head))
                set.add(head);
            else
                return head;
            head = head.next;
        }
        return null;
    }*/

    /**
     * 双指针
     * 两轮相遇
     * 第一次找到环中相遇节点 相遇时 两个指针所走路程为环的整数倍
     * 第二次找到环入口
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        ListNode pSlow = head;
        ListNode pFast = head;
        while (true){
            if (pFast == null || pFast.next == null)
                return null;
            pSlow = pSlow.next;
            pFast = pFast.next.next;
            if (pSlow == pFast)
                break;
        }
        pSlow = head;
        while (pSlow != pFast){
            pSlow = pSlow.next;
            pFast = pFast.next;
        }
        return pFast;
    }
}
