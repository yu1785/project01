package leetcodePractice.HOT100._098验证二叉搜索树;

import offerPractice.TreeNodeDemo.TreeNode;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 *      节点的左子树只包含小于当前节点的数。
 *      节点的右子树只包含大于当前节点的数。
 *      所有左子树和右子树自身必须也是二叉搜索树。
 */
public class solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(15);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(20);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(isValidBST(root));
    }
    public static boolean isValidBST(TreeNode root) {
        return isValid(root,null,null);
    }
    public static boolean isValid(TreeNode root,Integer low,Integer high){
        if (root != null){
            int val = root.val;
            if (low != null && val <= low)
                return false;
            if (high != null && val >= high)
                return false;
            // 遍历左子树时 设定上限值
            if (!isValid(root.left,low,val))
                return false;
            // 遍历右子树时 设定下限值
            if (!isValid(root.right,val,high))
                return false;

//            if (root.left != null){
//                if (root.left.val >= root.val)
//                    return false;
//                isValidBST(root.left);
//            }
//            if (root.right != null){
//                if (root.right.val <= root.val)
//                    return false;
//                isValidBST(root.right);
//            }
        }
        return true;
    }
}
