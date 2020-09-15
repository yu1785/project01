package myPractice.华为.秋._3;

import java.util.Scanner;

/**
 * @author yu
 * @date 2020/9/10 14:20
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        double[][] pd = new double[n][m];
        double[][] pr = new double[n][m];
        double[][] ps = new double[n][m];
        double[][] dp = new double[n][m];
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                pd[i][j] = sc.nextDouble();
                pr[i][j] = sc.nextDouble();
                ps[i][j] = sc.nextDouble();
            }
        }
        System.out.println(helper(0, 0, m, n, pd, pr, ps, dp));
    }

    private static double helper(int i, int j, int m, int n, double[][] pd, double[][] pr, double[][] ps, double[][] dp) {
        if(i == n - 1 && j == m-1 || i > n-1 || j > m-1){
            return 0;
        }
        if(dp[i][j] != 0 )
            return dp[i][j];
        if(dp[i][j] == 1 )
            return dp[i][j] = 0;
        return dp[i][j] = (1 + pr[i][j]*helper(i, j+1, m, n, pd, pr, ps,dp)+
                pd[i][j]*helper(i+1,j ,m ,n, pd, pr, ps,dp))/(1-ps[i][j]);
    }

}
