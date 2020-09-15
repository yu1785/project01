package myPractice.bingo;

import java.util.Arrays;

/**
 * @author yu
 * @date 2020/9/15 23:47
 */
public class Main {
    // 1
    /*public static void main(String[] args) {
        List<List<String>> data = new ArrayList<>();
        ArrayList str1 = new ArrayList<>();
        ArrayList str2 = new ArrayList<>();
        str1.add("A");
        str1.add("B");
        str2.add("C");
        str2.add("D");
        data.add(str1);
        data.add(str2);
        System.out.println(mirror(data));
    }
    public static List<List<String>> mirror(List<List<String>> data){
        int row = data.size();
        int col = data.get(0).size();
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            List<String> str = data.get(i);
            List<String> str1 = new ArrayList<>();
            str1.add(str.toString());
            for (int j = col-1; j >= 0 ; j--) {
                str1.add(str.get(j));
            }
            res.add(str1);
        }
        for (int i = row-1; i >= 0; i--) {
            res.add(res.get(i));
        }
        return res;
    }*/

    // 2
    /*public static void main(String[] args) {
        String param = "15 10 5,1,1000#2,3,3000#5,2,15000#10,4,16000";
        System.out.println(calLoad(param));
    }*/
    public static String calLoad(String param){
        String[] strings = param.split(" ");
        int dis = Integer.parseInt(strings[0]);
        int mem = Integer.parseInt(strings[1]);
        String app = strings[2];
        String[] apps = app.split("#");
        int len = apps.length;
        int[][] appInfo = new int[len][3];
        for (int i = 0; i < len; i++) {
            String[] temp = apps[i].split(",");
            appInfo[i][0] = Integer.parseInt(temp[0]);
            appInfo[i][1] = Integer.parseInt(temp[1]);
            appInfo[i][2] = Integer.parseInt(temp[2]);
        }
        /*Arrays.sort(appInfo, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2]-o1[2];
            }
        });*/
        Arrays.sort(appInfo,((o1, o2) -> (o2[2]-o1[2])));
        int countUser = 0;
        int countDis = 0;
        int countMem = 0;
        for (int i = 0; i < appInfo.length; i++) {
            countUser += appInfo[i][2];
            countDis += appInfo[i][0];
            countMem += appInfo[i][1];
            if (countDis<=dis && countMem<=mem)
                continue;
            else {
                countUser -= appInfo[i][2];
                countDis -= appInfo[i][0];
                countMem -= appInfo[i][1];
            }
        }
        int memRatio = countMem*100/mem;
        int disRatio = countDis*100/dis;
        String res = countUser+"";
        res += ","+memRatio+"%";
        res += ","+disRatio+"%";
        return res;
    }
}
