package leetcodePractice.HOT100._007整数反转;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class solution {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    /**
     * 注意考虑溢出的问题
     * @param x
     * @return
     */
    public static int reverse(int x) {
        /*if (x > -10 && x < 10)
            return x;
        String str = x+"";
        List<Character> list = new ArrayList<>();
        StringBuilder res = new StringBuilder();
        for (char c:str.toCharArray())
            list.add(c);
        if (list.get(0)=='-'){
            list.remove(0);
            Collections.reverse(list);
            for (Character li:list)
                res.append(li);
            return -Integer.valueOf(res.toString());
        }
        if (list.get(str.length()-1) == '0'){
            list.remove(str.length()-1);
        }
        Collections.reverse(list);
        for (Character li:list)
            res.append(li);
        return Integer.valueOf(res.toString());*/

        int y = 0;
        while (x != 0) {
            if (y > 214748364 || y < -214748364) {
                return 0;
            }
            y = y * 10 + x % 10;
            x = x / 10;
        }
        return y;
    }
}
