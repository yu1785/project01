package myPractice.爱奇艺._1n的阶乘问题;

import java.util.Scanner;

/**
 * 其实n!中的零全部是5和2的倍数贡献的，
 * 由于因子为2的个数大于5的，所以，只需计算其中有多少个5的倍数即可
 * @author yu
 * @date 2020/8/23 16:56
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(countZero(n));
    }
    public static int countZero(int n){
        int count = 0;
        /*if (n < 5)
            return 0;
        for (int i = 5; i <= n; i++) {
            int num = i;
            while ((num%5==0)&&(num>=5)){
                num /= 5;
                count ++;
            }
        }*/
        while (n>0){
            count += n/5;
            n /= 5;
        }
        return count;
    }
}
