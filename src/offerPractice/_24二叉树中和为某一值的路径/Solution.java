package offerPractice._24二叉树中和为某一值的路径;

import offerPractice.TreeNodeDemo.TreeNode;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 *
 * 思路：递归 前序遍历
 */

public class Solution {
    public static ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    public static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode left1 = new TreeNode(5);
        TreeNode right1 = new TreeNode(12);
        TreeNode left2 = new TreeNode(4);
        TreeNode right2 = new TreeNode(7);
        root.left = left1;
        root.right = right1;
        left1.left = left2;
        left1.right = right2;
        root.preorder(root);
        System.out.println();
        int target = 22;
        System.out.println(FindPath(root,target));
       /* TreeNode root = new TreeNode(8);
        TreeNode left1 = new TreeNode(9);
        TreeNode right1 = new TreeNode(8);
        TreeNode left2 = new TreeNode(1);
        TreeNode right2 = new TreeNode(3);
        root.left = left1;
        root.right = right1;
        right1.left = left2;
        right1.right = right2;
        root.preorder(root);
        System.out.println();
        int target = 17;
        System.out.println(FindPath(root,target));*/
    }
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return listAll;
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null){
            listAll.add(new ArrayList<Integer>(list));
            /**
             * 调整顺序 使list数组长度大的数组靠前
             */
            int length = listAll.size();
            if (listAll.size() > 1) {
                for (int i = 0;i < length-1;i ++){
                    if (listAll.get(i).size() < listAll.get(length-1).size()){
                        for (int j = length-1;j > i;j --){
                            listAll.set(j,listAll.get(j-1));
                        }
                        listAll.set(i,new ArrayList<Integer>(list));
                        break;
                    }
                }
            }
        }

        /**
         * 使用listAll.add(new ArrayList<>(list)) 而不用listAll.add(list)
         * listAll.add(list)是把list这个对象的引用地址添加到listAll了，listAll中的元素就会共用list，
         * 而list是我们用来存放当前路径的地方，因此我们需要复制一份之后加入listAll数组中
         */
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size()-1);
        return listAll;
    }
}
