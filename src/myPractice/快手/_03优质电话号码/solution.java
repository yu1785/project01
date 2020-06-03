package myPractice.快手._03优质电话号码;

import java.util.ArrayList;

public class solution {
    public static ArrayList<String> getNumbers(ArrayList<String> numbers) {
        ArrayList<String> list = new ArrayList<>();
        for (String str:numbers){
            String newStr = str.substring(3);
            int count1 = 0,count2 = 0;
            int maxCount1 = 0,maxCount2 = 0;
            int flag1 = 0,flag2 = 0;
            for (int i = 1;i < newStr.length();i ++){
                if (newStr.charAt(i)-newStr.charAt(i-1) == 1){
                    flag1 = 1;
                }
                else if (newStr.charAt(i) == newStr.charAt(i-1))
                    flag2 = 1;
                else {
                    flag1 = 0;
                    count1 = 0;
                    flag2 = 0;
                    count2 = 0;
                }
                if (flag1 == 1 && newStr.charAt(i)-newStr.charAt(i-1) == 1){
                    count1 ++;
                    maxCount1 = Math.max(maxCount1,count1);
                }
                else if (flag2 == 1 && newStr.charAt(i) == newStr.charAt(i-1)){
                    count2 ++;
                    maxCount2 = Math.max(maxCount2,count2);
                }
            }
            if (maxCount1 >= 3 || maxCount2 >= 3)
                list.add(str);
        }
        return list;
    }
}
