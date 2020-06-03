package leetcodePractice.HOT100._104二叉树的最大深度;

import offerPractice.TreeNodeDemo.TreeNode;

/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(maxDepth(root));
    }
    public static int maxDepth(TreeNode root) {
        /**
         * 递归 1
         */
        if (root == null)
            return 0;
        else {
            int left = maxDepth(root.left)+1;
            int right = maxDepth(root.right)+1;
            return Math.max(left,right);
        }

        /**
         * 递归 2 利用dfs方法
         */
//        int depth = 0,max = 0;
//        return dfs(root,depth,max);
    }
    public static int dfs(TreeNode root,int depth,int max){
        if (root == null){
            max = Math.max(depth,max);
            return max;
        }
        // 注意dfs方法有返回值 不能直接使用
        int left = dfs(root.left,depth+1,max);
        int right = dfs(root.right,depth+1,max);
        return Math.max(left,right);
    }
}
