package offerPractice._26二叉搜索树与双向链表;

import offerPractice.TreeNodeDemo.TreeNode;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向
 *
 * 思路：
 *    1.中序遍历，在list中按遍历顺序保存
 *    2.遍历list，修改指针
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode pRootOfTree = new TreeNode(10);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(14);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(8);
        pRootOfTree.left = node1;
        pRootOfTree.right = node2;
        node1.left = node3;
        node1.right = node4;
        pRootOfTree.preorder(pRootOfTree);
        TreeNode cnovertTree = Convert(pRootOfTree);
//        cnovertTree.preorder(cnovertTree);
    }
    /**
     * 方法1：先中序遍历，在list中按遍历顺序保存；再遍历list，修改指针
     */
    /*public static TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        ArrayList<TreeNode> list = new ArrayList<>();
        Convert(pRootOfTree,list);
        return Convert(list);
    }
    //中序遍历，在list中按遍历顺序保存
    public static void Convert(TreeNode pRootOfTree, ArrayList<TreeNode> list){
        while (pRootOfTree == null)
            return;
        Convert(pRootOfTree.left,list);
        list.add(pRootOfTree);
        Convert(pRootOfTree.right,list);
    }
    //遍历list，修改指针
    public static TreeNode Convert(ArrayList<TreeNode> list){
        for (int i = 0;i < list.size()-1;i ++){
            list.get(i).right = list.get(i+1);         //
            list.get(i+1).left = list.get(i);
        }
        return list.get(0);
    }*/

    /**
     * 方法2：从右向左遍历；递归
     */
    public static TreeNode pre = null;
    public static TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        Convert(pRootOfTree.right);
        if (pre == null)
            pre = pRootOfTree;
        else {
            pre.left = pRootOfTree;
            pRootOfTree.right = pre;
            pre = pRootOfTree;
        }
        Convert(pRootOfTree.left);
        return pre;
    }
}
