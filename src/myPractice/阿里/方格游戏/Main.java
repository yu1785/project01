package myPractice.阿里.方格游戏;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        int[][] array = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                array[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        System.out.println(findMaxSum(array,k));
    }
    public static int maxSum = 0;
    public static int sum = 0;
    public static int findMaxSum(int[][] array,int k){
        int n = array.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return array[0][0];
        boolean[][] visited = new boolean[n][n];
        sum = array[0][0];
        dfs(array,visited,k,0,0);
        return maxSum;
    }
    public static void dfs(int[][] array,boolean[][] visited,int speed,int row,int col){
        visited[row][col] = true;
        int[] X = {-1,1,0,0};
        int[] Y = {0,0,-1,1};
        for (int i = 0;i < 4;i ++){
            for (int k = 1;k <= speed;k ++){
                int nextRow = row + k*X[i];
                int nextCol = col + k*Y[i];
                if (inArea(nextRow,nextCol,array.length)
                        && array[nextRow][nextCol] > array[row][col]
                        && !visited[nextRow][nextCol]){
                    sum += array[nextRow][nextCol];
                    maxSum = Math.max(maxSum,sum);
                    dfs(array,visited,speed,nextRow,nextCol);
                    sum -= array[nextRow][nextCol];
                    visited[nextRow][nextCol] = true;
                }
            }
        }
    }
    public static boolean inArea(int x,int y,int n){
        if (x >= 0 && x < n && y >= 0 && y < n)
            return true;
        return false;
    }
}
