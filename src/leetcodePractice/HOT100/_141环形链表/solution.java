package leetcodePractice.HOT100._141环形链表;

import offerPractice.ListNodeDemo.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 */
public class solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        System.out.println(hasCycle(head));
    }
    /**
     * HashSet
     * @param head
     * @return
     */
    /*public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            // 若set中包含节点 表示存在环
            if (set.contains(head))
                return true;
            // 若set中不包含节点 添加
            else
                set.add(head);
            head = head.next;
        }
        // 有空节点出现 没有环
        return false;
    }*/

    /**
     * 双指针
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode pSlow = head;
        ListNode pFast = head.next;
        // 有环的话一定会相遇
        while (pSlow != pFast){
            // 注意这里要判断 pFast.next 是否为null
            // 若为空 则后面的 pFast.next.next 会出现空指针异常
            if (pFast == null || pFast.next == null)
                return false;
            pSlow = pSlow.next;
            pFast = pFast.next.next;
        }
        return true;
    }
}
