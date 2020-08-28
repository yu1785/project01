package myPractice.二叉树的遍历._1前序遍历.非递归;

import myPractice.二叉树的遍历.TreeNodeDemo.TreeNode;

import java.util.Stack;

/**
 * 实现思路:
 *     先序遍历是要先访问根节点，然后再去访问左子树以及右子树，
 *     这明显是递归定义，但这里是用栈来实现
 *     首先需要先从栈顶取出节点，然后访问该节点，
 *     如果该节点不为空，则访问该节点，同时把该节点的右子树先入栈，然后左子树入栈
 */
public class Solution {
    public static void nonRecursivePreOrder(TreeNode root) {
        //
        /*Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode p = null;
        while (p != null || !stack.empty()){
            p = stack.pop();
            if (p != null){
                System.out.println(p.val);
                stack.push(p.right);
                stack.push(p.left);
            }
        }*/

        //
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pNode = root;
        while (pNode != null || !stack.empty()){
            if (pNode != null){
                System.out.print(pNode.val+" ");
                stack.push(pNode);
                pNode = pNode.left;
            }else {
                pNode = stack.pop();
                pNode = pNode.right;
            }
        }
    }
}
