package myPractice.百度._3爬台阶;

import java.util.Scanner;

/**
 * @author yu
 * @date 2020/9/3 21:00
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(calculate(n,m));
    }

    public static int calculate(int n,int max){
        int jump = 0;
        if (n == 0)
            return 1;
        if (n >= max){
            for (int i = 1; i <= max; i++) {
                jump += calculate(n-i,max);
            }
        }else {
            jump = calculate(n,n);
        }
        return jump;
    }
}
