package leetcodePractice.HOT100._002两数相加;

import offerPractice.ListNodeDemo.ListNode;

/**
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 */
public class solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        System.out.println(addTwoNumbers(l1,l2));
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode node = res;       //注意创建一个中间存放值得结点，如果直接用链表res，最后结果为空
        int flag = 0;
        while (l1 != null || l2 != null){
            int x = (l1 == null) ? 0:l1.val;
            int y = (l2 == null) ? 0:l2.val;
            int value = x + y + flag;
            flag = value / 10;
            node.next = new ListNode(value%10);
            node = node.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (flag > 0)
            node.next = new ListNode(flag);
        return res.next;
    }
}
