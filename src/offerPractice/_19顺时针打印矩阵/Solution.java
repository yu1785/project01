package offerPractice._19顺时针打印矩阵;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
 *
 * 思路：设定上下左右边界 依次打印
 */
public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayList<Integer> list = new ArrayList<>();
        list = printMatrix(matrix);
        System.out.println(list);
    }
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int up = 0,down = row-1,left = 0,right = col-1;
        while (true){
            for (int j = left; j <= right; j++) {
                list.add(matrix[up][j]);
            }
            up ++;
            if (up > down)
                break;
            for (int i = up;i <= down;i ++)
                list.add(matrix[i][right]);
            right --;
            if (left > right)
                break;
            for (int i = right;i >= left;i --)
                list.add(matrix[down][i]);
            down --;
            if (up > down)
                break;
            for (int i = down;i >= up;i --)
                list.add(matrix[i][left]);
            left ++;
            if (left > right)
                break;
        }
        return list;
    }
}
