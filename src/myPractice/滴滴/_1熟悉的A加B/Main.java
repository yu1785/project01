package myPractice.滴滴._1熟悉的A加B;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 讨论符合abc + acc = n 的整数个数，结果中按abc为key排序输出.
 * @author yu
 * @date 2020/8/23 10:03
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] res = fun(n);
        System.out.println(res[0][0]);
        for (int i = 1; i < res.length; i++) {
            System.out.println(res[i][0]+" "+res[i][1]);
        }
    }
    public static int[][] fun(int n){
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i==j){
                    continue;
                }
                for (int k = 0; k < 10; k++) {
                    if (k==j || k==i){
                        continue;
                    }
                    int num1 = i*100+j*10+k;
                    int num2 = i*100+k*10+k;
                    int sum = num1+num2;
                    if (sum == n){
                        count ++;
                        list.add(num1);
                        list.add(num2);
                    }
                }
            }
        }
        int[][] res = new int[count+1][2];
        res[0][0] = count;
        int number = 0;
        for (int i = 1; i < count + 1; i++) {
            for (int j = 0; j < 2; j++) {
                res[i][j] = list.get(number++);
            }
        }
        return res;
    }
}
