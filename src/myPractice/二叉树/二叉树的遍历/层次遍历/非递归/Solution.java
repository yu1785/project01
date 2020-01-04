package myPractice.二叉树.二叉树的遍历.层次遍历.非递归;

import myPractice.二叉树.二叉树的遍历.TreeNodeDemo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void nonRecursiveLevelOrder(TreeNode root){
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            root = queue.poll();
            if (root.left != null)
                queue.offer(root.left);
            if (root.right != null)
                queue.offer(root.right);
            System.out.print(root.val+" ");
        }
    }
}
