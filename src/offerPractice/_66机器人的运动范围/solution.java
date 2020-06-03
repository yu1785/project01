package offerPractice._66机器人的运动范围;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 */
public class solution {
    public static void main(String[] args) {
        int threshold = 18;
        int rows = 40, cols = 40;
//        System.out.println(getSum(38));
        System.out.println(movingCount(threshold,rows,cols));
    }
    public static int movingCount(int threshold, int rows, int cols) {
        if (threshold <= 0 || rows < 1 || cols < 1)
            return 0;
        boolean[] visited = new boolean[rows*cols];
        return moving(threshold,rows,cols,0,0,visited);
    }
    public static int moving(int threshold, int rows, int cols, int row, int col, boolean[] visited){
        if (row < 0 || row >= rows || col < 0 || col >= cols)
            return 0;
        int count = 0;
        if ((getSum(row)+getSum(col)) <= threshold && !visited[row*cols+col]){
            visited[row*cols+col] =true;
            count = 1 + moving(threshold,rows,cols,row-1,col,visited)
                    + moving(threshold,rows,cols,row+1,col,visited)
                    + moving(threshold,rows,cols,row,col-1,visited)
                    + moving(threshold,rows,cols,row,col+1,visited);
//            if (row > 0)
//                count = moving(threshold,rows,cols,row-1,col,visited) + 1;
//            if (row < rows-1)
//                count = moving(threshold,rows,cols,row+1,col,visited) + 1;
//            if (col > 0)
//                count = moving(threshold,rows,cols,row,col-1,visited) + 1;
//            if (col < cols-1)
//                count = moving(threshold,rows,cols,row,col+1,visited) + 1;
        }
        return count;
    }
    public static int getSum(int num){
        int sum = 0;
        while (num > 0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }
}
