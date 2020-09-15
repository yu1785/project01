package myPractice.vivo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yu
 * @date 2020/9/15 23:40
 */
public class Main {
    // 2
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if (str.length() == 0)
            System.out.println(false);
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            String temp = str.substring(0,i)+str.substring(i+1,str.length());
            if (isHuiwen(temp)){
                System.out.println(temp);
                return;
            }
        }
        System.out.println(false);
    }*/
    public static boolean isHuiwen(String str){
        String temp = str;
        StringBuffer str1 = new StringBuffer(temp);
        StringBuffer str2 = str1.reverse();
        if (str2.toString().equals(str))
            return true;
        return false;
    }

    // 3
    public static void main(String[] args) {
        System.out.println(compileSeq("1,2,-1,1"));
    }
    public static String compileSeq (String input) {
        // write code here
        List<Integer> list = new ArrayList<>();
        StringBuffer res = new StringBuffer();
        String[] strs = input.split(",");
        list.add(0);
        for (int i = 0; i < strs.length; i++) {
//            res.append(i+"");
//            list.add(i);
            if (strs[i] == "-1"){
                if (list.contains(Integer.parseInt(strs[i]))){
                    continue;
                }
                else
                    list.add(Integer.parseInt(strs[i]));
            }
            else {
                if (list.contains(Integer.parseInt(strs[i]))){
                    int index = list.indexOf(Integer.parseInt(strs[i]));
                    list.add(index+1,Integer.parseInt(strs[i]));
                }else
                    list.add(0,Integer.parseInt(strs[i]));
            }
        }
        for (int li:list) {
            res.append(String.valueOf(li)+",");
        }
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }
}
