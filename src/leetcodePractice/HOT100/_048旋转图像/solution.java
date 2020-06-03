package leetcodePractice.HOT100._048旋转图像;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 */
public class solution {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        for (int i = 0;i < matrix.length;i ++){
            for (int j = 0;j < matrix[i].length;j ++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }

    /**
     * 返回值为void 只能在原数组上操作
     * 直接旋转 定坐标较难
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0;i < (len)/2;i ++){
            for (int j = 0;j < (len+1)/2;j ++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len-j-1][i];
                matrix[len-j-1][i] = matrix[len-i-1][len-j-1];
                matrix[len-i-1][len-j-1] = matrix[j][len-i-1];
                matrix[j][len-i-1] = temp;
            }
        }
    }

    /**
     * 先转置矩阵 在翻转行
     * 更容易理解
     * @param matrix
     */
    /*public static void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0;i < len;i ++){
            for (int j = i;j < len;j ++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i]= temp;
            }
        }
        for (int i = 0;i < len;i ++)
            for (int j = 0;j < len/2;j ++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len-j-1];
                matrix[i][len-j-1] = temp;
            }
    }*/
}
