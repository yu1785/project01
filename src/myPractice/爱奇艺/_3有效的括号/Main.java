package myPractice.爱奇艺._3有效的括号;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author yu
 * @date 2020/8/23 17:24
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if (isValid(str))
            System.out.println("True");
        else
            System.out.println("False");
    }
    public static boolean isValid(String str){
        if (str.length() < 2)
            return false;
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i < str.length();i ++){
            char ch = str.charAt(i);
            if (map.containsKey(ch)){
                stack.push(ch);
            }else if (map.containsValue(ch)){
                if (!stack.empty() && map.get(stack.peek())== ch)
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
