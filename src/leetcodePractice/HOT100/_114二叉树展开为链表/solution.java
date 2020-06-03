package leetcodePractice.HOT100._114二叉树展开为链表;

import offerPractice.TreeNodeDemo.TreeNode;

/**
 *给定一个二叉树，原地将它展开为链表。
 */
public class solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        flatten(root);
    }
    public static void flatten(TreeNode root) {
        while (root != null){
            if (root.left == null){
                root = root.right;
            }
            else {
                TreeNode preRight = root.right;
                TreeNode preLeft = root.left;
                // 找左子树最右边的节点
                while (preLeft.right != null)
                    preLeft = preLeft.right;
                preLeft.right = preRight;
                // root.right = preLeft 错误 因为经过前面的while循环 preLeft指向左子树的最后一个右叶子节点
                // 改为 root.right = root.left
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
}
