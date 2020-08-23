package myPractice.美团._2旅游次数;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author yu
 * @date 2020/8/17 16:01
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.next());
            list.add(sc.next());
            sc.nextLine();
        }
        Stack<String> stack = new Stack<>();
        int count = 0;
        for (String li:list){
            if (stack.contains(li))
                stack.pop();
            else
                stack.push(li);
            if (stack.size() == 0)
                count ++;
        }
        System.out.println(count);
    }
}
