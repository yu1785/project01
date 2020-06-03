package offerPractice._50数组中重复的数字;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *
 * 思路：1、HashMap  2、HashSet
 */
public class solution {
    public static void main(String[] args) {
        int[] numbers = {2,3,1,0,2,5,3};
        int length = numbers.length;
        int[] duplication = new int[1];
        System.out.println(duplicate(numbers,length,duplication));
        System.out.println(duplication[0]);
    }

    /**
     * 1、HashMap
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    /*public static boolean duplicate(int numbers[],int length,int [] duplication) {
        if (length == 0){
            duplication[0] = -1;
            return false;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (Integer num:numbers){
            if (!map.containsKey(num))
                map.put(num,1);
            else
                map.put(num,map.get(num)+1);
        }
        for (Integer num:numbers){
            if (map.get(num) >= 2){
                duplication[0] = num;
                return true;
            }
        }
        return false;
    }*/

    /**
     * 2、HashSet
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        if (length == 0){
            duplication[0] = -1;
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for (Integer num:numbers){
            if (set.contains(num)){
                duplication[0] = num;
                return true;
            }
            else
                set.add(num);
        }
        return false;
    }
}
