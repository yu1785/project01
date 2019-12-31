package offerPractice._16合并两个排序的链表;

import offerPractice.ListNodeDemo.ListNode;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，合成后的链表满足单调不减规则。
 *
 * 思路：
 *    1.排序
 *    2.递归
 *    3.递归优化  运行时间更短  占用内存更小
 */
public class Solution {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(7);
        list1.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        list1.getList(list1);

        ListNode list2 = new ListNode(2);
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(6);
        ListNode l3 = new ListNode(8);
        list2.setNext(l1);
        l1.setNext(l2);
        l2.setNext(l3);
        list2.getList(list2);

        ListNode list = Merge(list1,list2);
        list.getList(list);
    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
        //1.排序
        /*ListNode newlist = new ListNode(0);
        ListNode list = newlist;                  // 利用newlist存放头结点
        while (list1 != null && list2 != null){   // 注意 && 条件
            if (list1.val < list2.val){
                list.next = list1;
                list1 = list1.next;
            }
            else {
                list.next = list2;
                list2 = list2.next;
            }
            list = list.next;                     // list转向下一个结点
        }
        if (list1 == null)
            list.next = list2;
        else if (list2 == null)
            list.next = list1;

        return newlist.next;*/

        //2.递归
        /*if (list1 == null)
            return list2;
        else if (list2 == null)
            return list1;
        ListNode list = null;
        if (list1.val < list2.val){
            list = list1;
            list.next = Merge(list1.next,list2);
        }
        else {
            list = list2;
            list.next = Merge(list1,list2.next);
        }
        return list;*/

        //3.递归优化
        if (list1 == null)
            return list2;
        else if (list2 == null)
            return list1;
        ListNode list = null;
        if (list1.val > list2.val){
            ListNode listTemp = null;
            listTemp = list1;
            list1 = list2;
            list2 = listTemp;
        }
        list = list1;
        list.next = Merge(list1.next,list2);
        return list;
    }
}
