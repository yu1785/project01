package offerPractice.TreeNodeDemo;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public int val;
    public Object data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode root;
    public TreeNode(int x) { val = x; }

    public TreeNode(){}
    public TreeNode(TreeNode lChrild,TreeNode rChild,Object data){
        this.left = lChrild;
        this.right = rChild;
        this.data = data;
    }
    public TreeNode(Object data){
        this(null, null, data);
    }

    public void createTree(Object[] objects){
        List<TreeNode> datas = new ArrayList<>();//存储所有节点
        for(Object obj:objects){
            datas.add(new TreeNode(obj));
        }
        root = datas.get(0);//将一个作为根节点
        for(int i = 0;i < objects.length/2;i++){
            datas.get(i).left = datas.get(2*i+1);
            if(2*i+2 < objects.length){//避免偶数的时候，下标越界
                datas.get(i).right = datas.get(2*i+2);
            }
        }
    }

    //先序遍历
    public void preorder(TreeNode root){
        if(root != null){
            visit(root.getData());
            preorder(root.left);
            preorder(root.right);
        }
    }
    private void visit(Object obj) {
        System.out.print(obj+" ");
    }
    private Object getData() {
        return data;
    }
    public TreeNode getRoot() {
        return root;
    }
}
