package leetcodePractice;


public class sameTree100 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public boolean isSame(TreeNode p, TreeNode q){
        if (p == null && q ==null)
            return true;
        if (p != null && q != null && p.val == q.val)
            return isSame(p.left,q.left) && isSame(p.right,q.right);
        else
            return false;
    }
}
