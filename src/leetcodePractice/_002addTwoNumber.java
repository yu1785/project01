package leetcodePractice;

import java.util.Scanner;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。
 * 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字
 */

public class _002addTwoNumber {
    public static void main(String[] args) {
        ListNode l1 = null,l2 = null;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            l1.next.val = sc.nextInt();

        }
    }

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//
//    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
