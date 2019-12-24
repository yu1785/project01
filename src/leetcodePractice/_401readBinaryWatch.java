package leetcodePractice;
/**
 * 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间
 */

import java.util.ArrayList;
import java.util.List;

public class _401readBinaryWatch {
    public static void main(String[] args) {
        int n = 1;
        List<String> list = new ArrayList<>();
        list = readBinaryWatch(n);
        System.out.println(list);
    }
    public static List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
        pre(num,0,list);
        return list;
    }

    public static void pre(int num,int index,List<String> list){

    }
}
