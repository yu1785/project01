package leetcodePractice.HOT100._102二叉树的层序遍历;

import edu.princeton.cs.algs4.In;
import offerPractice.TreeNodeDemo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。
 * （即逐层地，从左到右访问所有节点）。
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
        node1.right = node3;
        node2.right = node4;
        System.out.println(levelOrder(root));
    }

    /**
     * 递归
     */
    public static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root,0);
        return result;
    }
    public static void dfs(TreeNode root,int level){
        if (root == null)
            return;
        if (result.size() == level)
            result.add(new ArrayList<>());
        result.get(level).add(root.val);
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }

    /**
     * 迭代
     */
    /*public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        // 注意边缘条件的判断
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
            result.add(new ArrayList<>());
            int len = queue.size();
            for (int i = 0;i < len;i ++){
                TreeNode node = queue.remove();
                result.get(level).add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            level ++;
        }
        return result;
    }*/
}
