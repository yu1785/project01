package offerPractice._23二叉搜索树的后序遍历序列;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同
 *
 * 注意：二叉搜索（查找）树是一种特殊的二叉树，相对较小的值保存在左节点，较大的值保存在右节点
 *
 * 思路：递归 找出左右子树分界线 再依次判断左右子树
 */
public class Solution {
    public static void main(String[] args) {
//        int[] sequence = {5,7,6,9,11,10,8};
        int[] sequence = {7,4,6,5};
//        int[] sequence = {4,6,12,8,16,14,10};
//        int[] sequence = {5,4,3,2,1};
        System.out.println(VerifySquenceOfBST(sequence));
    }
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        return VerifyBST(sequence,0,sequence.length-1);
    }
    public static boolean VerifyBST(int [] sequence,int start,int end){
        if (start == end)
            return true;
        int root = sequence[end];
        int flagLeft = 0,flagRight = 0, // 是否有左右子树的标志
                index = 0;      //存放左右子树的分界位
        for (int i = start;i < end;i ++){
            if (root > sequence[i]){        // 左子树
                flagLeft = 1;
                continue;
            }
            if (root < sequence[i]){        // 右子树
                flagRight = 1;
                index = i;
                break;
            }
        }
        if (flagLeft == 0)           // 特例 {5，4，3，2，1}
            index = start;
        if (flagRight == 0)          // 特例 {1，2，3，4，5}
            index = end-1;
        if (flagRight == 1){
            for (int i = index+1;i < end;i ++)
                if (root > sequence[i])
                    return false;
        }
        boolean left = true, right = true;
        if (index > start)
            left = VerifyBST(sequence,start,index-1); // left
        if (index < end)
            right = VerifyBST(sequence,index,end-1); // right
        return left&&right;
    }
}
