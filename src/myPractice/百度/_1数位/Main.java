package myPractice.百度._1数位;

import java.util.Scanner;

/**
 * @author yu
 * @date 2020/9/3 20:59
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        int count5 = 0;
        int count0 = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] == 5)
                count5 ++;
            else
                count0 ++;
        }
        if (count0+count5!=n || count0==0){
            System.out.println(-1);
            return;
        }

        if(count5<9){
            System.out.println(0);
            return;
        }
        StringBuffer number = new StringBuffer("");
        int c = count5/9;
        for (int i = 0; i < c; i++) {
            number.append("555555555");
        }
        for (int i = 0; i < count0; i++) {
            number.append("0");
        }
        System.out.println(number.toString());

        /*int select5 = count5;
        if (count5%3 != 0) {
            select5 = count5-count5%3;
        }
        for (int i = 0; i < select5; i++) {
            number.append('5');
        }
        for (int i = 0; i < count0; i++) {
            number.append('0');
        }
        System.out.println(number.toString());*/


        /*int min = 0;
        for (int i = 1; i <= count0; i++) {
            for (int j = number.length(); j > 0; j--) {
                number.insert(j,'0');
                if (Double.parseDouble(number.toString()) %90 == 0)
                    min = Math.max(min,Integer.parseInt(number.toString()));
                number.delete(j,j+1);
            }
        }
        if (min != 0)
            System.out.println(min);
        else
            System.out.println(-1);*/
    }
}
