package myPractice.美团._1不一样的逆序数;

import java.util.Scanner;

/**
 * 一个数的4倍恰好是它的逆序数 则为一个逆序对
 * 输入：n
 * 输出：不超过n的逆序对个数
 *       输出逆序对（若多组 按第一个数升序输出）
 * @author yu
 * @date 2020/8/17 15:55
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = Method(n);
        if (arr[0][0] == 0)
            System.out.println(0);
        else {
            System.out.println(arr[0][0]);
            for (int i = 1; i <= arr[0][0]; i++) {
                System.out.println(arr[i][0]+" "+arr[i][1]);
            }
        }
    }
    public static int[][] Method(int n){
        int[][] arr = new int[100][2];
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (isReverse(i,n)){
                result ++;
                arr[result][0] = i;
                arr[result][1] = i*4;
            }
        }
        arr[0][0] = result;
        return arr;
    }
    public static boolean isReverse(int num,int range){
        if (num<2178 || (num>2500&&num<10000) || (num>25000&&num<100000)
                || (num>250000&&num<1000000) || (num>2500000&&num<10000000) )
            return false;
        else {
            int change = num*4;
            if (change > range)
                return false;
            String str1 = String.valueOf(num);
            String str2 = String.valueOf(change);
            if (str1.length() != str2.length())
                return false;
            else {
                for (int i = 0; i < str1.length(); i++) {
                    if (str1.charAt(i) != str2.charAt(str2.length()-1-i))
                        return false;
                }
                return true;
            }
        }
    }
}
