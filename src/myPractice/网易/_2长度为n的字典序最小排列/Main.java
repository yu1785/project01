package myPractice.网易._2长度为n的字典序最小排列;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 输入： 5 3     // n = 5, m = 3
 *       2 1 5   // 数组T[]
 * 输出：2 1 3 4 5
 * @author yu
 * @date 2020/8/8 17:47
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] T = new int[m];
        for (int i = 0; i < m; i++) {
            T[i] = sc.nextInt();
        }
        int[] res = fun(n,m,T);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }
    public static int[] fun(int n,int m,int[] T){
        if (n == m)
            return T;
        int[] res = new int[n];
        ArrayList<Integer> lists = new ArrayList<>();
        int[] list = new int[n];

        for (int i = 0; i < n; i++) {
            list[i] = i+1;
        }
        for (int i = 0; i < m; i++) {
            if (T[i] <= n){
                list[T[i]-1] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            if (list[i] != 0){
                lists.add(list[i]);
            }
        }
        int count = 0;    // T[]
        int countAll = 0; // lists
        int len = lists.size();
        int index = 0;
        while (count < m && countAll < len){
            if (lists.get(countAll) < T[count]){
                res[index++] = lists.get(countAll++);
            }else {
                res[index++] = T[count++];
            }
        }
        while (count < m){
            res[index++] = T[count++];
        }
        while (countAll < len){
            res[index++] = lists.get(countAll++);
        }
        return res;
    }
}
