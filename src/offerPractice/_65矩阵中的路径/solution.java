package offerPractice._65矩阵中的路径;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 */
public class solution {
    public static void main(String[] args) {
        char[] matric = {'A','B','C','E','S','F','C','S','A','D','E','E'};
        int rows = 3, cols = 4;
        char[] str = {'A','B','C','C','E','D'};
        boolean hasPath = hasPath(matric,rows,cols,str);
        System.out.println(hasPath);
    }
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 1 || cols < 1 || str == null)
            return false;
        boolean[] visited = new boolean[rows*cols];
        for (int row = 0;row < rows;row ++){
            for (int col = 0;col < cols;cols ++){
                if (hasSubPath(matrix,rows,cols,str,row,col,0,visited))
                    return true;
            }
        }
        return false;
    }

    /**
     * 超时
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @param row
     * @param col
     * @param length
     * @param visited
     * @return
     */
    /*public static boolean hasSubPath(char[] matrix, int rows, int cols, char[] str,
                              int row, int col, int length, boolean[] visited){
        if (length == str.length)
            return true;
        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols
            && matrix[row*cols+col] == str[length] && !visited[row*cols+col]){
            length ++;
            visited[row*cols+col] = true;
            hasPath = hasSubPath(matrix,rows,cols,str,row-1,col,length,visited)
                    || hasSubPath(matrix,rows,cols,str,row+1,col,length,visited)
                    || hasSubPath(matrix,rows,cols,str,row,col-1,length,visited)
                    || hasSubPath(matrix,rows,cols,str,row,col+1,length,visited);
            if (! hasPath){
                length --;
                visited[row*cols+col] = false;
            }
        }
        return hasPath;
    }*/

    public static boolean hasSubPath(char[] matrix, int rows, int cols, char[] str,
                                     int row, int col, int length, boolean[] visited){
        if (matrix[row*cols+col] != str[length] || visited[row*cols+col])
            return false;
        if (length == str.length-1)
            return true;
        visited[row*cols+col] = true;
        if (row > 0 && hasSubPath(matrix,rows,cols,str,row-1,col,length+1,visited))
            return true;
        if (row < rows-1 && hasSubPath(matrix,rows,cols,str,row+1,col,length+1,visited))
            return true;
        if (col > 0 && hasSubPath(matrix,rows,cols,str,row,col-1,length+1,visited))
            return true;
        if (col < cols-1 && hasSubPath(matrix,rows,cols,str,row,col+1,length+1,visited))
            return true;
        visited[row*cols+col] = false;
        return false;
    }

    /**
     * 通过代码
     */
    /*boolean[] visited = null;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        visited = new boolean[matrix.length];
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                if(subHasPath(matrix,rows,cols,str,i,j,0))
                    return true;
        return false;
    }

    public boolean subHasPath(char[] matrix, int rows, int cols, char[] str, int row, int col, int len){
        if(matrix[row*cols+col] != str[len]|| visited[row*cols+col] == true) return false;
        if(len == str.length-1) return true;
        visited[row*cols+col] = true;
        if(row > 0 && subHasPath(matrix,rows,cols,str,row-1,col,len+1)) return true;
        if(row < rows-1 && subHasPath(matrix,rows,cols,str,row+1,col,len+1)) return true;
        if(col > 0 && subHasPath(matrix,rows,cols,str,row,col-1,len+1)) return true;
        if(col < cols-1 && subHasPath(matrix,rows,cols,str,row,col+1,len+1)) return true;
        visited[row*cols+col] = false;
        return false;
    }*/
}
