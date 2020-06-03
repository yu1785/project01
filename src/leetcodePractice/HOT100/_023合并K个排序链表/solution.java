package leetcodePractice.HOT100._023合并K个排序链表;

import offerPractice.ListNodeDemo.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class solution {
    /**
     * 分冶算法 两两合并
     * 运行时间更短
     * @param
     * @return
     */
    /*public ListNode mergeKLists(ListNode[] lists) {
        ListNode node = new ListNode(0);
        if (lists.length == 0)
            return null;
        return merge(lists,0,lists.length-1);
    }
    public ListNode merge(ListNode[] lists,int left,int right){
        if (left == right)
            return lists[left];
        int mid = left+(right-left)/2;
        ListNode l1 = merge(lists,left,mid);
        ListNode l2 = merge(lists,mid+1,right);
        return mergeTwo(l1,l2);
    }
    public ListNode mergeTwo(ListNode l1,ListNode l2){
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val){
            l1.next = mergeTwo(l1.next,l2);
            return l1;
        }
        else {
            l2.next = mergeTwo(l1,l2.next);
            return l2;
        }
    }*/

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

        ListNode[] list = new ListNode[2];
        list[0] = head1;
        list[1] = head2;
        ListNode head = new ListNode(0);
        head.next = mergeKLists(list);
    }
    /**
     * 优先级队列(最小堆原理)
     * 像普通队列一样，拥有队头和队尾，但队列中的元素是按照自然排序或者指定的比较器排序的
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length,new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) return -1;
                else if (o1.val == o2.val) return 0;
                else return 1;
            }
        });
        ListNode node = new ListNode(0);
        ListNode cur = node;
        for (ListNode li:lists)
            if (li != null)
                queue.add(li);
        while (!queue.isEmpty()){
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null)
                // 把最小的节点拿出来后 再放回剩下的节点
                queue.add(cur.next);
        }
        return node.next;
    }
}
