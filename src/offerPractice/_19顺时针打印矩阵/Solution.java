package offerPractice._19顺时针打印矩阵;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
 *
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
        for (int i = 0;i < row;i ++) {
            for (int j = 0; j < col; j++) {
                list.add(matrix[i][j]);
            }
        }
        return list;
    }
}
