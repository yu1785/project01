package myPractice.华为.秋._1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author yu
 * @date 2020/9/15 23:41
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        int fl = 1;
        while (sc.hasNext()){
            String str = sc.nextLine();
            list.add(str);
            if (fl == 0)
                break;
            if (str.length()==1)
                fl = 0;
        }
        int len = list.size();
        String target = list.get(len-1);
        char ch = list.get(len-2).charAt(0);
        StringBuffer tarQue = new StringBuffer();
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) < ch)
                tarQue.append(target.charAt(i));
        }
        String tar = tarQue.toString();
        for (int i = 0; i < len - 2; i++) {
            if (search(list.get(i),tar,ch))
                System.out.println(list.get(i));
        }
    }

    public static boolean search(String str,String tar,char ch){
        StringBuffer tarQue = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < ch)
                tarQue.append(str.charAt(i));
        }
        String val = tarQue.toString();
        int result = val.indexOf(tar);
        if (result != -1)
            return true;
        return false;
    }
}
