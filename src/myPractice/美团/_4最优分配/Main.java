package myPractice.美团._4最优分配;

import java.util.Scanner;

/**
 * @author yu
 * @date 2020/8/17 16:04
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[][] dp = new int[a+1][b+1];
        for (int i = a; i >= 0; i--) {
            for (int j = b; j >= 0; j--) {
                dp[i][j] = 0;
            }
        }
        for (int k = 0; k < n; k++) {
            int valA = sc.nextInt();
            int valB = sc.nextInt();
            for (int i = a; i >= 0; i--) {
                for (int j = b; j >= 0; j--) {
                    if (i!=0)
                        dp[i][j] = Math.max(dp[i][j],dp[i-1][j]+valA);
                    if (j!=0)
                        dp[i][j] = Math.max(dp[i][j],dp[i][j-1]+valB);
                }
            }
        }
        System.out.println(dp[a][b]);
    }
}
