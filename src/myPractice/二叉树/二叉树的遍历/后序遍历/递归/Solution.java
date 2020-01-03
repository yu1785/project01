package myPractice.二叉树.二叉树的遍历.后序遍历.递归;

import myPractice.二叉树.二叉树的遍历.TreeNodeDemo.TreeNode;

public class Solution {
    public static void recursivePostOrder(TreeNode root){
        if (root == null)
            return;
        recursivePostOrder(root.left);
        recursivePostOrder(root.right);
        System.out.print(root.val+" ");
    }
}
