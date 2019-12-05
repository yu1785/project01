package leetcodePractice;

public class balancedTree110 {
    //自顶向下
    /*public boolean isBalanced(sameTree100.TreeNode root){
        if (root == null)
            return true;
        return isBalanced(root.right) && isBalanced(root.left) &&
                Math.abs(depth(root.left)-depth(root.right))<1;
    }
    private static int depth(sameTree100.TreeNode root){
        if (root == null)
            return 0;
        return Math.max(depth(root.left),depth(root.right))+1;
    }*/

    //自底向上
    public boolean isBalanced(sameTree100.TreeNode root){
        return depth(root) != -1;
    }
    private static int depth(sameTree100.TreeNode root){
        if (root == null)
            return 0;
        if (depth(root.right)==-1)
            return -1;
        if (depth(root.left)==-1)
            return -1;
        return Math.abs(depth(root.left)-depth(root.right)) < 2 ?
                Math.max(depth(root.right),depth(root.left))+1 : -1;
    }
}
