package myPractice.腾讯._1最小木棍代价;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author yu
 * @date 2020/8/23 21:46
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            sc.nextLine();
            int n = sc.nextInt();
            sc.nextLine();
            // 优先队列构造最小堆
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int j = 0; j < n; j++) {
                queue.add(sc.nextInt());
            }
            int sumAll = 0;
            for (int j = 0; j < n - 1; j++) {
                int num1 = queue.poll();
                int num2 = queue.poll();
                int sum = num1+num2;
                sumAll += sum;
                queue.add(sum);
            }
            System.out.println(sumAll);
        }
    }
}
