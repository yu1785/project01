package myPractice.快手._02数组寻址;

import java.util.*;

public class solution {
    public static void main(String[] args) {
        int[] arr = {1,22,22,33,22,12,45,44,5};
//        System.out.println(search(arr));
    }
    public static ArrayList<Integer> search(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < arr.length;i ++)
            map.put(i,arr[i]);
        Arrays.sort(arr);
        for (int i = arr.length-1;i > 0;i --){
            if (arr[i] != arr[i-1] && getKey(map,arr[i]) < getKey(map,arr[i-1]))
                list.add(i-1);
        }
        return list;
    }
    public static Integer getKey(HashMap<Integer,Integer> map,int val){
        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()){
            int key = it.next();
            if (map.get(key) == val)
                return key;
        }
        return 0;
    }
}
