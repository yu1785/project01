package leetcodePractice.HOT100._094二叉树的中序遍历;

import offerPractice.TreeNodeDemo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 */
public class solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.left = node2;
        System.out.println(inorderTraversal(root));
    }

    /*public static List<Integer> list = new ArrayList<>();
    *//**
     * 递归
     * @param root
     * @return
     *//*
    public static List<Integer> inorderTraversal(TreeNode root) {
        //注意判断 root 是否为空
        if (root == null)
            return list;
        if (root.left != null)
            inorderTraversal(root.left);
        list.add(root.val);
        if (root.right != null)
            inorderTraversal(root.right);
        return list;
    }*/

    /**
     * 栈
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}
