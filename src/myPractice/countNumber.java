package myPractice;

import java.util.Scanner;
/*
    输入一行字符，分别统计出其英文字母、空格、数字和其它字符的个数
 */
public class countNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int letter = 0;
        int space = 0;
        int number = 0;
        int other = 0;
        char[] ch = str.toCharArray();
        for (int i = 0;i < ch.length;i ++){
            if (ch[i] >= '1' && ch[i] <= '9')
                number ++;
            else if ((ch[i] >= 'A' && ch[i] <= 'Z')||(ch[i] >= 'a' && ch[i] <= 'z'))
                letter ++;
            else if(ch[i] == ' ')
                space ++;
            else
                other ++;
        }
        System.out.println("数字："+number);
        System.out.println("字母："+letter);
        System.out.println("空格："+space);
        System.out.println("其他："+other);
    }
}
