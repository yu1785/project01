package myPractice.顺丰._2赏金猎人;

import java.util.Scanner;

/**
 * @author yu
 * @date 2020/8/23 9:56
 */
public class Main {
    /**
     * 克里森是一名赏金猎人，他平时需要完成一些任务赚钱。
     * 最近他收到了一批任务，但是受到时间的限制，他只能完成其中一部分。
     * 具体来说就是有n个任务，每个任务用l, r, w来表示任务开始的时间l，结束的时间r和完成任务获得的金钱。
     * 克里森是个贪心的人，他想知道自己在任务不冲突的情况下最多获得多少金钱
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int res = fun(arr,n);
        System.out.println(res);
    }
    public static int fun(int[][] arr,int n){
        int max = 0;
        for (int i = 0; i < n; i++) {
            int temp = fun2(arr,n,i);
            if (max < temp)
                max = temp;
        }
        return max;
    }
    public static int fun2(int[][] arr,int n,int start){
        int index = start;
        int res = arr[start][2];
        while (index < n-1){
            if (arr[start][1] <= arr[index+1][0]){
                res += arr[index+1][2];
                start = index+1;
                index ++;
            }else {
                index ++;
            }
        }
        return res;
    }
}
