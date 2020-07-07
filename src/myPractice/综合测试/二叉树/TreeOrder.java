package myPractice.综合测试.二叉树;

import edu.princeton.cs.algs4.Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yu
 * @date 2020/7/7 13:20
 */
public class TreeOrder {
    public static void main(String[] args) {

    }

    /**
     * 二叉树的遍历：
     *      1. 前序 ： 递归
     *                非递归
     *      2. 中序 ： 递归
     *                非递归
     *      3. 后序 ： 递归
     *                非递归
     *      4. 层序 ： 递归
     *                非递归
     */

    /*                递归                  */

    // 前序
    public static void preOrderRecur(TreeNode node){
        if (node == null)
            return;
        System.out.println(node.val);
        preOrderRecur(node.left);
        preOrderRecur(node.right);
    }

    public static void inOrderRecur(TreeNode node){
        if (node == null)
            return;
        inOrderRecur(node.left);
        System.out.println(node.val);
        inOrderRecur(node.right);
    }

    public static void postOrderRecur(TreeNode node){
        if (node == null)
            return;
        inOrderRecur(node.left);
        inOrderRecur(node.right);
        System.out.println(node.val);
    }



    /*                非递归                  */

    public static void preOrder(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pNode = node;
        while (pNode != null || !stack.isEmpty()){
            while (pNode != null){
                System.out.println(pNode.val);
                stack.push(pNode);
                pNode = pNode.left;
            }
            if (!stack.isEmpty()){
                pNode = stack.pop();
                pNode = pNode.right;
            }
        }
    }

    public static void inOrder(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pNode = node;
        while (pNode != null || !stack.isEmpty()){
            while (pNode != null){
                stack.push(pNode);
                pNode = pNode.left;
            }
            if (!stack.isEmpty()){
                pNode = stack.pop();
                System.out.println(pNode.val);
                pNode = pNode.right;
            }
        }
    }

    public static void postOrder(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();

    }

    public static void levelOrder(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            node = queue.poll();
            System.out.println(node.val);
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
    }

    /**
     * 求二叉树的深度
     * @param node
     * @return
     */
    public static int depth(TreeNode node){
        if (node == null)
            return 0;
        else {
            int leftDepth = depth(node.left);
            int rightDepth = depth(node.right);
            return leftDepth > rightDepth ? (leftDepth+1) : (rightDepth+1);
        }
    }

    /**
     * 翻转二叉树
     * @param node
     * @return
     */
    public static TreeNode invert(TreeNode node){
        if (node != null){
            if (node.left != null)
                node.left = invert(node.left);
            if (node.right != null)
                node.right = invert(node.right);
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return node;
    }


}

class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}