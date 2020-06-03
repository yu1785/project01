package leetcodePractice.HOT100._148排序链表;

import offerPractice.ListNodeDemo.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 */
public class solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        ListNode result = sortList(head);
//        System.out.println(sortList(head));
    }

    /**
     * 归并排序的思路：自顶向下
     *    1.切分：利用快慢双指针对链表进行切分
     *    2.合并
     * @param head
     * @return
     */
   /* public static ListNode sortList(ListNode head) {
        // 这里必须进行判断
        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        ListNode left = head;
        return merge(sortList(left),sortList(right));
    }*/

    /**
     * 归并排序的思路：自底向上
     * 先把所有节点值添加进队列 再两两合并
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        Deque<ListNode> queue = new LinkedList<>();
        while (head != null) {
            ListNode cur = head.next;
            head.next = null;
            queue.offer(head);
            head = cur;
        }
        //排序并循环添加
        head = queue.poll();
        while(!queue.isEmpty()){
            queue.offer(head);
            head = merge(queue.poll(),queue.poll());
        }
        return head;
    }

    public static ListNode merge(ListNode left,ListNode right){
        ListNode node = new ListNode(0);
        // 注意这里必须定义一个中间变量进行后续操作
        // 不然最后返回的 node.next 为空
        ListNode head = node;
        while (left != null && right != null){
            if (left.val < right.val){
                node.next = left;
                left = left.next;
            }
            else{
                node.next = right;
                right = right.next;
            }
            // node = node.next;不要搞忘了
            node = node.next;
        }
        node.next = left != null ? left : right;
        return head.next;
    }
}
