package offerPractice._46孩子们的游戏;

import offerPractice.ListNodeDemo.ListNode;

/**
 * n个小朋友们围成一个大圈。随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列,并且不再回到圈中,
 * 从下一个小朋友开始,继续0...m-1报数....这样下去....
 * 直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 *
 * 思路：
 *   1、环形链表
 *   2、数学公式
 */
public class solution {
    public static void main(String[] args) {
        int n = 6,m = 3;
        System.out.println(LastRemaining_Solution(n,m));
    }

    /**
     * 1、环形链表
     * @param n
     * @param m
     * @return
     */
    /*public static int LastRemaining_Solution(int n, int m) {
        if (n == 0 || m == 0)
            return -1;
        ListNode head = new ListNode(0);
        ListNode node = head;
        //构造环形链表
        for (int i = 1;i < n;i ++){
            node.next = new ListNode(i);
            node = node.next;
        }
        node.next = head;
        int k = 0;
        while (node.next != node){
            if (++k == m){
                node.next = node.next.next;
                k = 0;
            }
            else
                node = node.next;
        }
        return node.val;
    }*/

    /**
     * 2、数学公式
     * @param n
     * @param m
     * @return
     */
    public static int LastRemaining_Solution(int n, int m) {
        if(n == 0 || m == 0)
            return -1;

        int last = 0;
        for (int i = 2; i <= n; i ++)
            last = (last + m) % i;
        return last;
    }
}

