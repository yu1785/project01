package myPractice.二叉树.二叉树的遍历;

import myPractice.二叉树.二叉树的遍历.TreeNodeDemo.TreeNode;

import static myPractice.二叉树.二叉树的遍历._2中序遍历.递归.Solution.recursiveInOrder;
import static myPractice.二叉树.二叉树的遍历._2中序遍历.非递归.Solution.nonRecursiveInOrder;
import static myPractice.二叉树.二叉树的遍历._1前序遍历.递归.Solution.recursivePreOrder;
import static myPractice.二叉树.二叉树的遍历._1前序遍历.非递归.Solution.nonRecursivePreOrder;
import static myPractice.二叉树.二叉树的遍历._3后序遍历.递归.Solution.recursivePostOrder;
import static myPractice.二叉树.二叉树的遍历._3后序遍历.非递归.Solution.nonRecursivePostOrder;
import static myPractice.二叉树.二叉树的遍历._4层次遍历.递归.Solution.recursiveLevelOrder;
import static myPractice.二叉树.二叉树的遍历._4层次遍历.非递归.Solution.nonRecursiveLevelOrder;

public class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        TreeNode left2 = new TreeNode(4);
        TreeNode right2 = new TreeNode(5);
        TreeNode left3 = new TreeNode(6);
        root.left = left1;
        root.right = right1;
        left1.left = left2;
        left1.right = right2;
        right2.left = left3;

        System.out.println("****递归*****");
        System.out.print("前序遍历：");
        recursivePreOrder(root);
        System.out.print('\n'+"中序遍历：");
        recursiveInOrder(root);
        System.out.print('\n'+"后序遍历：");
        recursivePostOrder(root);
        System.out.print('\n'+"层次遍历：");
        recursiveLevelOrder(root);
        System.out.println();
        System.out.print("****非递归*****");
        System.out.print('\n'+"前序遍历：");
        nonRecursivePreOrder(root);
        System.out.print('\n'+"中序遍历：");
        nonRecursiveInOrder(root);
        System.out.print('\n'+"后序遍历：");
        nonRecursivePostOrder(root);
        System.out.print('\n'+"层次遍历：");
        nonRecursiveLevelOrder(root);
    }
}
