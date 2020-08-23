package myPractice.顺丰._1服务器;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author yu
 * @date 2020/8/23 9:53
 */
public class Main {
    /**
     * 第一题：
     * 小A的购买了一批服务器，他准备将这些服务器租用出去。
     * 每一个服务器有一个固定的带宽，人们根据自己需要的带宽来租用这些服务器。一台服务器只能租给一个人。
     *
     * 小A现在有n个空闲的服务器，第 i 个服务器拥有ai的带宽。
     * 有m个客户来租服务器，第 i 位客户需要带宽至少为bi的服务器，并且愿意花ci元作为预算。
     * （服务器带宽独立不可叠加，若不能成功租出则输出0）
     * 小A可以选择拒绝一些人，现在，小A想知道自己的服务器最多能租多少钱？
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[] serverB = new int[n];
        for (int i = 0; i < n; i++) {
            serverB[i] = sc.nextInt();
        }
        sc.nextLine();
        int[][] client = new int[m][2];
        for (int i = 0; i < m; i++) {
            client[i][0] = sc.nextInt();
            client[i][1] = sc.nextInt();
            sc.nextLine();
        }
        int res = fun(serverB,client);
        System.out.println(res);
    }

    public static int fun(int[] value, int[][] client){
        Arrays.sort(value);
        Arrays.sort(client,(v1,v2)->{
            int v = v1[1]-v2[1];
            if (v == 0)
                return v1[0] - v2[0];
            return v;
        });
        int res = 0;
        for (int i = client.length-1; i >= 0 ; i--) {
            int n = client[i][0];
            for (int j = 0; j < value.length; j++) {
                if (value[j] >= n){
                    res += client[i][1];
                    value[j] = 0;
                    break;
                }
            }
        }
        return res;
    }
}
