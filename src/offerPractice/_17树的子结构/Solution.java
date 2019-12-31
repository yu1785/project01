package offerPractice._17树的子结构;

import offerPractice.TreeNodeDemo.TreeNode;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（空树不是任意一个树的子结构）
 *
 * 注意:子结构和子树的不同
 */
public class Solution {
    public static void main(String[] args) {
        Object[] objs1 = {8,8,7,9,2,null,null,null,null,4,7};
//        Object[] objs1 = {8,null,8,null,9,null,2,null,5};
        TreeNode Tree1 = new TreeNode();
        Tree1.createTree(objs1);
        Tree1.preorder(Tree1.getRoot());  //前序遍历
        System.out.println();
        Object[] objs2 = {8,9,2};
//        Object[] objs2 = {8,null,9,3,2};
        TreeNode Tree2 = new TreeNode();
        Tree2.createTree(objs2);
        Tree2.preorder(Tree2.getRoot());  //前序遍历
        System.out.println();
        System.out.println(HasSubtree(Tree1,Tree2));

    }
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        return ifHasSubtree(root1,root2) || HasSubtree(root1.left,root2)
                || HasSubtree(root1.right,root2);
    }

    public static boolean ifHasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null){
            System.out.println("end...");
            return true;
        }

        if (root1 == null)       //  这个判断不能少！！
            return false;
//        System.out.println(root1.val+" "+root2.val);
        if (root1.val != root2.val)
//        if (!root1.data.equals(root2.data))
            return false;
        System.out.println(root1.data+" "+root2.data);
        return ifHasSubtree(root1.left,root2.left)
                && ifHasSubtree(root1.right,root2.right);
    }
}
