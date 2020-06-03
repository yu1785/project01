package leetcodePractice.HOT100._234回文链表;

import myPractice.二叉树.二叉树的遍历.TreeNodeDemo.TreeNode;
import offerPractice.ListNodeDemo.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yu
 * @date 2020/5/7 21:02
 */
public class solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        System.out.println(isPalindrome(head));
    }

    /**
     * 利用数组存放链表值 再遍历数组
     * 时间复杂度 空间复杂度 O(n)
     * @param head
     * @return
     */
    /*public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        int p1 = 0,p2 = list.size()-1;
        while (p2 > p1){
            // 注意这里使用equal比较是否相等
            if (!list.get(p1).equals(list.get(p2)))
                return false;
            p1 ++;
            p2 --;
        }
        return true;
    }*/

    /**
     *翻转链表
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode pslow = head;
        ListNode pfast = head;
        ListNode pre = null;
        while (pfast != null && pfast.next != null){
            // 翻转链表关键步骤
            ListNode cur = pslow;
            pslow = pslow.next;
            pfast = pfast.next.next;
            cur.next = pre;
            pre = cur;

            //注意这两个代码的位置 放在下面是错的
//            pslow = pslow.next;
//            pfast = pfast.next.next;
        }
        // 注意这里的判断 很重要 区分链表长度的奇偶个数
        if (pfast != null)
            pslow = pslow.next;
        while (pre != null && pslow != null){
            if (pre.val != pslow.val)
                return false;
            pre = pre.next;
            pslow = pslow.next;
        }
        return true;
    }
}
