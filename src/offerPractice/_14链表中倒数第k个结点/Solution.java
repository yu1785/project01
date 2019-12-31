package offerPractice._14链表中倒数第k个结点;

import offerPractice.ListNodeDemo.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * 思路：
 *    1.遍历两遍链表 第一次找出结点个数 第二次找出倒数k个结点
 *    2.遍历一遍链表 利用两个指针 两指针间相隔k个结点
 *
 *    结果第一种方法运行时间更小，占用内存更多
 *
 * 注意几个边缘条件：
 *      链表为空、k值为0、k大于链表结点个数   返回值都为null
 */
public class Solution {
    public ListNode FindKthToTail(ListNode head, int k) {

        //1.遍历两遍链表 第一次找出结点个数 第二次找出倒数k个结点
        /*if (head == null || k == 0)
            return null;
        int numberCount = 0;
        if (head != null)
            numberCount ++;
        ListNode curentNode = head.next;
        while (curentNode != null){
            numberCount ++;
            curentNode = curentNode.next;
        }
        if (k > numberCount)
            return null;
        ListNode resultNode = head;
        for (int i = 0;i < numberCount-k;i ++)     //注意这里i的取值范围
            resultNode = resultNode.next;
        return resultNode;*/

        //2.遍历一遍链表 利用两个指针 两指针间相隔k个结点
        if (head == null || k == 0)
            return null;
        ListNode front = head;
        ListNode back = head;
        int i = 1;
        for (;front.next != null;++ i){
            front = front.next;
            if (i >= k)
                back = back.next;
        }
        if (i < k)
            return null;
        return back;
    }
}
