package leetcodePractice.HOT100._226翻转二叉树;

import offerPractice.TreeNodeDemo.TreeNode;

/**
 * @author yu
 * @date 2020/5/7 20:25
 */
public class solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(7);
        TreeNode l2 = new TreeNode(1);
        TreeNode l3 = new TreeNode(6);
        TreeNode r2 = new TreeNode(3);
        TreeNode r3 = new TreeNode(9);
        root.left = l1;
        root.right = r1;
        l1.left = l2;
        l1.right = r2;
        r1.left = l3;
        r1.right = r3;
        TreeNode node = invertTree(root);
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
