package myPractice.二叉树.二叉树的遍历._1前序遍历.递归;

import myPractice.二叉树.二叉树的遍历.TreeNodeDemo.TreeNode;

public class Solution {
    public static void recursivePreOrder(TreeNode root){
        if (root == null)
            return;
        System.out.print(root.val+" ");
        recursivePreOrder(root.left);
        recursivePreOrder(root.right);
    }
}
