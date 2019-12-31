package offerPractice.ListNodeDemo;

public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
    public void getList(ListNode node){
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
