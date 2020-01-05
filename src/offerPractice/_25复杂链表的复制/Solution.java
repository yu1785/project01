package offerPractice._25复杂链表的复制;

import offerPractice.ListNodeDemo.RandomListNode;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * 思路：
 *  1、遍历链表，复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
 *  2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
 *  3、拆分链表，将链表拆分为原链表和复制后的链表
 */
public class Solution {
    public static void main(String[] args) {
        RandomListNode pHead = new RandomListNode(0);
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        pHead.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node1.random = node3;
        node2.random = node4;

        RandomListNode pCloneHead = Clone(pHead);
        System.out.println(pCloneHead);
    }
    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
        //1、遍历链表，复制每个结点
        RandomListNode currentNode = pHead;
        while (currentNode != null){
//            RandomListNode cloneNode = currentNode; // 这样不对 运行报错 只需要复制当前结点
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;
            currentNode = nextNode;
        }
        //2、重新遍历链表，复制老结点的随机指针给新结点
        currentNode = pHead;
        while (currentNode != null){
            currentNode.next.random = currentNode.random == null ? null:currentNode.random.next;
            currentNode = currentNode.next.next;
        }
        //3、拆分链表，将链表拆分为原链表和复制后的链表
        currentNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (currentNode != null){
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next == null ? null:cloneNode.next.next;
            currentNode = currentNode.next;
        }
        return pCloneHead;
    }
}
