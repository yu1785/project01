package leetcodePractice.HOT100._105从前序与中序遍历序列构造二叉树;

import offerPractice.TreeNodeDemo.TreeNode;

import java.util.Arrays;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 */
public class solution {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = buildTree(preorder,inorder);
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        //  这里的 && 和 || 效果一样
        if (preorder.length == 0 && inorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0;i < inorder.length;i ++){
            if (preorder[0] == inorder[i]){
                int[] preLeft = Arrays.copyOfRange(preorder,1,i+1);
                int[] inLeft = Arrays.copyOfRange(inorder,0,i);
                int[] preRight = Arrays.copyOfRange(preorder,i+1,preorder.length);
                int[] inRight = Arrays.copyOfRange(inorder,i+1,inorder.length);
                root.left = buildTree(preLeft,inLeft);
                root.right = buildTree(preRight,inRight);
                break;
            }
        }
        return root;
    }
    public static TreeNode dfs(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        return root;
    }
}
