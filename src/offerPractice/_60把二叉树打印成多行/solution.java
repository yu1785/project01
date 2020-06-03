package offerPractice._60把二叉树打印成多行;

import offerPractice.TreeNodeDemo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class solution {
    public static void main(String[] args) {
        TreeNode pRoot = new TreeNode(8);
        TreeNode l1 = new TreeNode(6);
        TreeNode r1 = new TreeNode(10);
        TreeNode l21 = new TreeNode(5);
        TreeNode r21 = new TreeNode(7);
        TreeNode l22 = new TreeNode(9);
        TreeNode r22 = new TreeNode(11);
        pRoot.left = l1;
        pRoot.right = r1;
        l1.left = l21;
        l1.right = r21;
        r1.left = l22;
        r1.right = r22;
        System.out.println(Print(pRoot));
    }
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null)
            return result;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (! queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0;i < size;i ++){
                TreeNode node = queue.poll();
                if (node == null)
                    continue;
                list.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if (list.size() != 0)
                result.add(list);
        }
        return result;
    }
}
