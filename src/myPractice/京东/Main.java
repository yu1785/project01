package myPractice.京东;

import java.util.Scanner;

/**
 * @author yu
 * @date 2020/8/6 18:15
 */
public class Main {
    // 选择题
    /*public static void main(String[] args) {
        long l1 = 1L;
        long l2 = 2147483647L;
        long l3 = 9876543210L;
        long l4 = 123456789123456789L;
        int i1 = (int)l1;
        int i2 = (int)l2;
        int i3 = (int)l3;
        int i4 = (int)l4;
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i4);
    }*/
    // 1
   /* public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += fun(i);
        }
        System.out.println(String.format("%.4f",sum));
    }*/
    public static double fun(int n){
        double  fn = 0;
        for (int i = 1; i <= n; i++) {
            fn = fn + 1.0/(5*(2*i-1)) - 1.0/(5*2*i);
        }
        return fn;
    }

    // 2
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int count = fun1(num1,num2);
        System.out.println(count);
    }
    public static int fun(int num1,int num2){
        int count = 0;
        for (int i = num1; i <= num2; i++) {
            String str = i+"";
            String strRes = null;
            for (int j = 0; j < str.length() ; j++) {
                strRes = str.substring(0,j)+str.substring(j+1,str.length());
                if (suShu(Integer.parseInt(strRes)) && huiWen(Integer.parseInt(strRes))){
                    count ++;
                    break;
                }
            }
        }
        return count;
    }
    public static int fun1(int num1,int num2){
        int count = 0;
        for (int i = num1; i <= num2; i++) {
            String str = i+"";
            int number = 0;
            for (int j = 1; j <= str.length() ; j++) {
                number = i/((int)Math.pow(10,j))+i%((int)Math.pow(10,j-1));
                if (suShu(number) && huiWen(number)){
                    count ++;
                    break;
                }
            }
        }
        return count;
    }
    public static boolean suShu(int s){
        for (int i = 2; i < s/2; i++) {
            if (s%i == 0)
                return false;
        }
        return true;
    }
    public static boolean huiWen(int s){
        String str = String.valueOf(s);
        StringBuffer str1 = new StringBuffer(str);
        StringBuffer str2 = str1.reverse();
        // 注意由于StringBuilder没有重写equals函数  所以使用String.valueOf(str1)
        if (String.valueOf(str1).equals(String.valueOf(str2)))
            return true;
        return false;
    }

}
