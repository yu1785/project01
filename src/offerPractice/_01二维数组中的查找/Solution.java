package offerPractice._01二维数组中的查找;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 思路：
 *      选取 左下角或右上角元素  与目标进行对比
 */

public class Solution {
    public static void main(String[] args) {
        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int target = 19;
        System.out.println(Find(target,array));
    }
    public static boolean Find(int target, int [][] array) {
        int len = array.length;
        int len1 = array[0].length;            //判断数组是否为空
        if (array == null || len == 0 || (len == 1&&len1 == 0))
            return false;
        if (target < array[0][0])              //目标值比数组第一个值还小
            return false;
        int row = 0;
        int col = len1 - 1;
        while (row < len && col >= 0){
            if (target == array[row][col])
                return true;
            else if (target < array[row][col])
                col --;
            else if (target > array[row][col])
                row ++;
        }
        return false;
    }
}
