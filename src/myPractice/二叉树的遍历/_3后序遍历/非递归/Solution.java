package myPractice.二叉树的遍历._3后序遍历.非递归;

import myPractice.二叉树的遍历.TreeNodeDemo.TreeNode;

import java.util.Stack;

public class Solution {
    public static void nonRecursivePostOrder(TreeNode root){
       /*
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pNode = root;
        TreeNode pre = root;
        while (pNode != null || !stack.empty()){
            while (pNode != null){
                stack.push(pNode);
                pNode = pNode.left;
            }
            pNode = stack.peek().right;
            if (pNode == null || pNode == pre){
                pNode = stack.pop();
                System.out.print(pNode.val+" ");
                pre = pNode;
                pNode = null;
            }

            while(pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            }
            pNode = stack.pop();
            System.out.print(pNode.val+" ");
            //这里需要判断一下，当前p是否为栈顶的左子树，如果是的话那么还需要先访问右子树才能访问根节点
            //如果已经是不是左子树的话，那么说明左右子书都已经访问完毕，可以访问根节点了，所以讲p复制为NULL
            //取根节点
            if (!stack.empty() && pNode == stack.peek().left) {
                pNode = stack.peek().right;
            }
            else
                pNode = null;
        }
        */

        //双栈法
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> result = new Stack<>();
        while (root != null || !stack.empty()){
            while (root != null){
                stack.push(root);
                result.push(root);
                root = root.right;
            }
            if (!stack.empty())
                root = stack.pop().left;
        }
        while (!result.empty()){
            root = result.pop();
            System.out.print(root.val+" ");
        }
    }
}
