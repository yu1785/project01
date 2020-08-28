package myPractice.滴滴._2斐波拉契蛇;

import java.util.Scanner;

/**
 * 蛇形输出斐波那契数组N*N维的。开始端从内部开始
 * @author yu
 * @date 2020/8/23 10:03
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1){
            System.out.println(1);
            return;
        }
        long[] arr = new long[n*n];
        arr[0] = arr[1] = 1L;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i-2]+arr[i-1];
        }
        long[][] result =new long[n][n];
        int index = n*n-1;
        for (int i = 0; i <= n / 2; i++) {
            for (int high = i; high < n-i; high++) {
                result[i][high] = arr[index--];
            }
            for (int right = i+1; right < n-i; right++) {
                result[right][n-i-1] = arr[index--];
            }
            for (int low = n-i-2; low >= i; low--) {
                result[n-i-1][low] = arr[index--];
            }
            for (int left = n-i-2; left >= i+1; left--) {
                result[left][i] = arr[index--];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != n-1){
                    System.out.print(result[i][j]+" ");
                }else {
                    System.out.println(result[i][j]);
                }
            }
        }
    }
}
