package leetcodePractice;

import java.util.ArrayList;
import java.util.List;

public class _102levelSearch {
    //递归
    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(_100sameTree.TreeNode root){
        if (root == null)
            return levels;
        fun(root,0);
        return levels;
    }

    public void fun(_100sameTree.TreeNode node, int level){
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());
        levels.get(level).add(node.val);
        if (node.left  != null)
            fun(node.left,level+1);
        if (node.right != null)
            fun(node.right,level+1);
    }
}
