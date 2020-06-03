package leetcodePractice.HOT100._006Z字形变换;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 */
public class solution {
    public static void main(String[] args) {
        System.out.println(convert("AB",1));
    }
    public static String convert(String s, int numRows) {
        if (numRows < 2)
            return s;
        List<StringBuilder> str = new ArrayList<>();
        for (int i = 0;i < numRows;i ++)
            str.add(new StringBuilder());
        int index = 0,flag = -1;
        for (char c:s.toCharArray()){
            str.get(index).append(c);
            if (index == 0 || index == numRows-1)
                flag = -flag;
            index += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder ss:str)
            res.append(ss);
        return res.toString();
    }
}
