package myPractice.爱奇艺._2判断路径是否相交;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author yu
 * @date 2020/8/23 17:23
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if (isPath(str))
            System.out.println("True");
        else
            System.out.println("False");
    }
    public static boolean isPath(String path){
        Set<String> set = new HashSet<>();
        int x = 0;
        int y = 0;
        set.add(x+","+y);
        for (int i = 0; i < path.length(); i++) {
            char ch = path.charAt(i);
            if (ch == 'N')
                y ++;
            else if (ch == 'S')
                y --;
            else if (ch == 'E')
                x ++;
            else if (ch == 'W')
                x --;
            if (!set.add(x+","+y))
                return true;
        }
        return false;
    }
}
