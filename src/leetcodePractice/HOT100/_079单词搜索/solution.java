package leetcodePractice.HOT100._079单词搜索;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 */
public class solution {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'},{'A','D','E','E'}};
//        char[][] board = {{'A','B'}};
        System.out.println(exist(board,"SEE"));
    }

    /**
     * 回溯
     * @param board
     * @param word
     * @return
     */
    /*public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0;i < m;i ++)
            for (int j = 0;j < n;j ++)
                if (dfs(board,word,i,j,0,visited))
                    return true;
        return false;
    }
    public static boolean dfs(char[][] board, String word,int row,int col,int index,boolean[][] visited){
        if (index == word.length())
            return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length)
            return false;
        if (board[row][col] == word.charAt(index) && !visited[row][col]){
            visited[row][col] = true;
            index ++;
            if (dfs(board,word,row+1,col,index,visited)
                    || dfs(board,word,row-1,col,index,visited)
                    || dfs(board,word,row,col+1,index,visited)
                    || dfs(board,word,row,col-1,index,visited))
                return true;
            visited[row][col] = false;
        }
        return false;
    }*/

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(board,word,0,0,0,visited);
    }
    public static boolean dfs(char[][] board, String word,int row,int col,int index,boolean[][] visited){
        if (index == word.length())
            return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length)
            return false;
        if (!visited[row][col]){
            visited[row][col] = true;
            if (board[row][col] == word.charAt(index))
                index ++;
            else
                visited[row][col] = false;
            if (dfs(board,word,row+1,col,index,visited)
                    || dfs(board,word,row-1,col,index,visited)
                    || dfs(board,word,row,col+1,index,visited)
                    || dfs(board,word,row,col-1,index,visited))
                return true;
            visited[row][col] = false;
        }
        return false;
    }
}
