package offerPractice._04重建二叉树;
/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * 思路：递归构造二叉树
 */

import offerPractice.TreeNodeDemo.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode treeNode = reConstructBinaryTree(pre,in);
        System.out.println(list);
    }
    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre.length == 0 || in.length == 0)
            return null;
        TreeNode root = new TreeNode(pre[0]);
        list.add(pre[0]);
        for (int i = 0;i < in.length;i ++){
            if (in[i] == pre[0]){
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),
                        Arrays.copyOfRange(in,0,i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),
                        Arrays.copyOfRange(in,i+1,in.length));
            }
        }
        return root;
    }
}
