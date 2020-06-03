package leetcodePractice.HOT100._101对称二叉树;

import edu.princeton.cs.algs4.Stack;
import offerPractice.TreeNodeDemo.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        node2.right = node4;
        System.out.println(isSymmetric(root));
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }
    public static boolean isMirror(TreeNode left,TreeNode right){
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        return left.val == right.val
                && isMirror(left.left,right.right)
                && isMirror(left.right,right.left);
    }

    /**
     * 迭代
     * @param root
     * @return
     */
   /* public static boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();
            if (node1 == null && node2 == null)
                continue;
            if (node1 == null || node2 == null)
                return false;
            if (node1.val != node2.val)
                return false;
            stack.push(node1.left);
            stack.push(node2.right);
            stack.push(node1.right);
            stack.push(node2.left);
        }
        return true;
    }*/
}
