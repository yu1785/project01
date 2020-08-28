package myPractice.二叉树的遍历._4层次遍历.递归;

import myPractice.二叉树的遍历.TreeNodeDemo.TreeNode;

public class Solution {
    public static void recursiveLevelOrder(TreeNode root){
        if (root == null)
            return;
        int depth = maxDepth(root);
        for (int i = 1;i <= depth;i ++)
            visitNodeAtDepth(root,i);
    }

    public static int maxDepth(TreeNode root){
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public static void visitNodeAtDepth(TreeNode root,int depth){
        if (root == null || depth < 1)
            return;
        if (depth == 1){
            System.out.print(root.val+" ");
            return;
        }
        visitNodeAtDepth(root.left,depth-1);
        visitNodeAtDepth(root.right,depth-1);
    }
}
