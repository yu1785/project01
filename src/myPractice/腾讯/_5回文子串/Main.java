package myPractice.腾讯._5回文子串;

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
            int m = sc.nextInt();
            sc.nextLine();
            String str = sc.next();
            int flag = 0;
            for (int j = 0; j <= n - m; j++) {
                String s = str.substring(j,j+m);
                if (huiWen(s)){
                    flag = 1;
                    break;
                }
            }
            if (flag == 1)
                System.out.println("YES");
            else
                System.out.println("NO");

        }
    }
    public static boolean huiWen(String str){
        StringBuffer str1 = new StringBuffer(str);
        StringBuffer temp = new StringBuffer(str);
        StringBuffer str2 = temp.reverse();
        // 由于StringBuilder没有重写equals函数  所以使用String.valueOf(str1)
        if (String.valueOf(str1).equals(String.valueOf(str2)))
            return true;
        return false;
    }
}
