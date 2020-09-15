package myPractice.腾讯.秋;

import java.util.ArrayList;

/**
 * @author yu
 * @date 2020/9/15 23:45
 */
public class Main {
    // 1
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int len1 = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < len1; i++) {
            list1.add(sc.nextInt());
        }
        sc.nextLine();
        int len2 = sc.nextInt();
        for (int i = 0; i < len2; i++) {
            list2.add(sc.nextInt());
        }
        List<Integer> list = new ArrayList<>();
        int p1 = 0,p2 = 0;
        while (p1<len1 && p2<len2){
            int val1 = list1.get(p1);
            int val2 = list2.get(p2);
            if (val1 == val2){
                p1 ++;
                p2 ++;
                list.add(val2);
            }
            else if (list1.get(p1) > list2.get(p2))
                p1 ++;
            else if (list1.get(p1) < list2.get(p2))
                p2 ++;
        }
        for (int li:list)
            System.out.print(li+" ");
    }*/

    // 3
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            if(str.equals(""))
            if (!map.containsKey(str))
                map.put(str,1);
            else
                map.put(str,map.get(str)+1);
        }
        List<Map.Entry<String,Integer>> list1 = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
        Collections.sort(list1, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        List<Map.Entry<String,Integer>> list2 = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
        Collections.sort(list2, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int count1 = 0;
        int count2 = 0;
        for (Map.Entry<String,Integer> li:list1) {
            count1 ++;
            if (count1 > k)
                break;
            System.out.println(li.getKey()+" "+li.getValue());
        }
        for (Map.Entry<String,Integer> li:list2) {
            count2 ++;
            if (count2 > k)
                break;
            System.out.println(li.getKey()+" "+li.getValue());
        }
    }*/

    // 4
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list  = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            List<Integer> temp  = new ArrayList<>(list);
            temp.remove(i);
            temp.sort((o1, o2) -> o1-o2);
            res[i] = temp.get(n/2-1);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(res[i]);
        }
    }*/

    public static void dfs(ArrayList<Integer> list){
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        int n = list.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n && j != i ; j++) {
                list1.add(list.get(i));
                list2.add(list.get(j));
            }
        }
    }
}
