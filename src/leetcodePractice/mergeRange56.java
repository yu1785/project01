package leetcodePractice;

import java.util.ArrayList;
import java.util.Scanner;

public class mergeRange56 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        //设置两个Scanner 第一个以行为单位读取数据
        //这样就相当于是用回车（enter）当作结束符
        Scanner sc0 = new Scanner(System.in);
        String line = sc0.nextLine();
        Scanner sc = new Scanner(line);
        while (sc.hasNextInt()){
            ArrayList<Integer> listRow = new ArrayList<Integer>();
            for (int i = 0;i < 2;i ++)
                listRow.add(sc.nextInt());
            list.add(listRow);
        }
        System.out.println(list);
//        merge(list);
    }
//    public static ArrayList<ArrayList<Integer>> merge(ArrayList<ArrayList<Integer>> list) {
//        for (<ArrayList<Integer> li:list){
//
//        }
//        for (int i = 0;i < list.size();i ++){
//            for (int j = 0;j < list.size();j ++){
//
//            }
//        }
//        return list;
//    }
}
