package leetcodePractice.HOT100._020有效的括号;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class solution {
    public static void main(String[] args) {
        System.out.println(isValid("{}"));
    }
    /**
     * 成对的括号 栈
     * @param
     * @return
     */
    public static Map<Character,Character> map = new HashMap<Character,Character>(){{
        put('}','{');
        put(']','[');
        put(')','(');
    }};
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i < s.length();i ++){
            char c = s.charAt(i);
            if (stack.contains(map.get(c))){
                char top = stack.pop();
                if (top != map.get(c))
                    return false;
            }
            else {
                stack.push(c);
            }
        }
        return stack.empty();
    }
}
