package offerPractice._18二叉树的镜像;

import offerPractice.TreeNodeDemo.TreeNode;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Solution {
    public static void main(String[] args) {
        Object[] objs1 = {8,6,10,5,7,9,11};
        TreeNode Tree1 = new TreeNode();
        Tree1.createTree(objs1);
        Tree1.preorder(Tree1.getRoot());  //前序遍历
        System.out.println();
        Mirror(Tree1.root);
        Tree1.preorder(Tree1.getRoot());  //前序遍历
    }
    public static void Mirror(TreeNode root) {
        if (root == null)
            return;
//        while (root.left != null || root.right != null){   // 加循环后进入死循环
            TreeNode temp = null;
            temp = root.left;
            root.left = root.right;
            root.right = temp;
            Mirror(root.left);
            Mirror(root.right);
//        }
    }
}
