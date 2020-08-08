package myPractice.网易._1拆后数组最多素数个数;

import java.util.Scanner;

/**
 * @author yu
 * @date 2020/8/8 17:46
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += arr[i] / 2;
        }
        System.out.println(result);
    }
}
