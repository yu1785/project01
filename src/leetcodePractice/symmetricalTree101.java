package leetcodePractice;

public class symmetricalTree101 {

    //递归方法
    /*public boolean isSymmetric(sameTree100.TreeNode root){
        return isSymmetric(root,root);
    }
    public boolean isSymmetric(sameTree100.TreeNode t1, sameTree100.TreeNode t2){
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;
        return t1.val == t2.val && isSymmetric(t1.left,t2.right) &&
                isSymmetric(t1.right,t2.left);
    }*/

    //迭代方法
    /*public boolean isSymmetric(sameTree100.TreeNode root){

    }*/
}