package myPractice.二叉树.二叉树的遍历.中序遍历.非递归;


import myPractice.二叉树.二叉树的遍历.TreeNodeDemo.TreeNode;

import java.util.Stack;

public class Solution {
    public static void nonRecursiveInOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pNode = root;
        while (pNode != null || !stack.empty()){
            if (pNode != null){
                stack.push(pNode);
                pNode = pNode.left;
            }else {
                pNode = stack.pop();
                System.out.print(pNode.val+" ");
                pNode = pNode.right;
            }
        }
    }
}
