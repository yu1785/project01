package leetcodePractice.HOT100._124二叉树中的最大路径和;

import offerPractice.TreeNodeDemo.TreeNode;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。
 * 该路径至少包含一个节点，且不一定经过根节点。
 */
public class solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
//        TreeNode node1 = new TreeNode(2);
//        TreeNode node2 = new TreeNode(3);
//        root.left = node1;
//        root.right = node2;
        System.out.println(maxPathSum(root));
    }
    public static int max = Integer.MIN_VALUE;  // 节点的值可能为负 所以不能赋值为0
    public static int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    public static int dfs(TreeNode root) {
        if (root == null)
            return 0;
        // 节点值小于0 舍弃 不加入最大路径中
        int left = Math.max(dfs(root.left),0);
        int right = Math.max(dfs(root.right),0);
        // 更新最大路径 考虑包含当前根节点的最大路径
        max = Math.max(max,root.val+left+right);
        // 返回包含当前根节点和左子树或者右子树的路径
        return root.val+Math.max(left,right);
    }
}
