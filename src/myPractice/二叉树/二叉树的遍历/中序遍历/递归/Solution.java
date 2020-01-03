package myPractice.二叉树.二叉树的遍历.中序遍历.递归;


import myPractice.二叉树.二叉树的遍历.TreeNodeDemo.TreeNode;

public class Solution {
    public static void recursiveInOrder(TreeNode root){
        if (root == null)
            return;
        recursiveInOrder(root.left);
        System.out.print(root.val+" ");
        recursiveInOrder(root.right);
    }
}
