package offerPractice._39平衡二叉树;

import offerPractice.TreeNodeDemo.TreeNode;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 如果某二叉树中任意节点的左、右子树的深度相差不超过1，那么它就是一棵平衡二叉树
 *
 * 思路:根据二叉树深度的求解，深度差大于1时 输出false
 */
public class solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (TreeDepth(root) == -1)
            return false;
        else
            return true;
    }
    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = TreeDepth(root.left);
        if (left == -1)
            return -1;
        int right = TreeDepth(root.right);
        if (right == -1)
            return -1;
        if (Math.abs(left-right) > 1)
            return -1;
        else
            return Math.max(left,right)+1;
    }
}
