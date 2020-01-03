package myPractice.练习题;

import java.util.Scanner;

/*
    一球从h米高度自由落下，每次落地后反跳回原高度的一半；
    再落下，求它在第n次落地时，共经过多少米？第n次反弹多高？
 */
public class bounceBall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("落地高度和落地次数分别为: ");
        float h = sc.nextFloat();
        int n = sc.nextInt();
        float total = h;
        for (int i = 1;i <= n;i ++){
            h /= 2;
            total += 2*h;
        }
        total -= 2*h;
        System.out.println("共经过："+total+" m");
        System.out.println("反弹："+h+" m");
    }
}
