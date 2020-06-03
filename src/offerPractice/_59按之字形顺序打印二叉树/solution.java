package offerPractice._59按之字形顺序打印二叉树;

import offerPractice.TreeNodeDemo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class solution {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        LinkedList<TreeNode> nodeList = new LinkedList<>();       // 注意这里使用LinkedList
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null)
            return result;
        boolean reverse = true;
        nodeList.add(pRoot);
        while (! nodeList.isEmpty()){       // nodeList != null 不对 ？？
            int size = nodeList.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0;i < size;i ++){
                TreeNode node = nodeList.poll();
                if (node == null)
                    continue;
                if (reverse)
                    list.add(node.val);
                else
                    list.add(0,node.val);
                nodeList.offer(node.left);
                nodeList.offer(node.right);
            }
            if (list.size()!=0)
                result.add(list);
            reverse = !reverse;
        }
        return result;
    }
}
