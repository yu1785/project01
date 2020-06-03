package leetcodePractice.HOT100._017电话号码的字母组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class solution {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
    public static Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    public static List<String> result = new ArrayList<>();

    /**
     * 回溯算法
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backTrack("",digits);
        return result;

    }
    public static void backTrack(String combination,String nextDigit){
        if (nextDigit.length() == 0)
            result.add(combination);
        else {
            String digit = nextDigit.substring(0,1);
            String letters = phone.get(digit);
            for (int i = 0;i < letters.length();i ++){
                String letter = phone.get(digit).substring(i,i+1);
                backTrack(combination+letter,nextDigit.substring(1));
            }
        }
    }
}
