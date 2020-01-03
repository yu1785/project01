package myPractice.练习题;

import java.util.Scanner;
/*
    求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。
    例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。
    输出结果的形式如：2+22+222=246
 */
public class addValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int n = sc.nextInt();
        System.out.print("the result : "+a);
        int sumAll = a;
        for (int i = 1;i < n;i ++){
            int sum = a;
            for (int j = 1;j <= i;j ++){
                sum += (int) (a*Math.pow(10,j));
            }
            System.out.print("+"+sum);
            sumAll += sum;
        }
        System.out.print("="+sumAll);
    }
}
