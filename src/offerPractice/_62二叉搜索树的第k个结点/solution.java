package offerPractice._62二叉搜索树的第k个结点;

import offerPractice.TreeNodeDemo.TreeNode;

import java.util.ArrayList;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 *
 * 思路：二叉搜索树的中序遍历是按顺序排列的
 */
public class solution {
    public static void main(String[] args) {
        TreeNode pRoot = new TreeNode(5);
        TreeNode l1 = new TreeNode(3);
        TreeNode r1 = new TreeNode(7);
        TreeNode l21 = new TreeNode(2);
        TreeNode r21 = new TreeNode(4);
        TreeNode l22 = new TreeNode(6);
        TreeNode r22 = new TreeNode(8);
        pRoot.left = l1;
        pRoot.right = r1;
        l1.left = l21;
        l1.right = r21;
        r1.left = l22;
        r1.right = r22;
        System.out.println(KthNode(pRoot,3).val);
    }
    public static ArrayList<TreeNode> list = new ArrayList<>();
    public static TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0)
            return null;
        inOrder(pRoot);
        if (k > list.size())      // 注意判断k值是否大于list的长度
            return null;
        return list.get(k-1);
    }
    public static void inOrder(TreeNode pRoot){
        if (pRoot != null){
            inOrder(pRoot.left);
            list.add(pRoot);
            inOrder(pRoot.right);
        }
    }
}
