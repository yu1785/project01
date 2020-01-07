package offerPractice._28数组中出现次数超过一半的数字;

import java.util.*;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0
 *
 * 思路：
 *    方法1：利用ArrayList集合存放数组中出现的不同数字；
 *          利用Map<K, V>存放每个数字及其出现的次数
 *    方法2：preValue记录上一次访问的值，count表明当前值出现的次数，
 *          如果下一个值和当前值相同那么count++；如果不同count--，
 *          减到0的时候就要更换新的preValue值了，
 *          因为如果存在超过数组长度一半的值，那么最后preValue一定会是该值
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution(array));
    }

    /**
     * 方法1：利用ArrayList集合存放数组中出现的不同数字；
     *       利用Map<K, V>存放每个数字及其出现的次数
     * @param array
     * @return
     */
    public static int MoreThanHalfNum_Solution(int [] array) {
        if (array == null)
            return 0;
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int arr:array){
            if (!list.contains(arr)){
                list.add(arr);
                map.put(arr,1);
            }
            else
                map.put(arr,map.get(arr)+1);
        }
        int maxCount = 0;
        for (int count:map.values()) {
            if (count > maxCount)
                maxCount = count;
        }
        if (maxCount > array.length/2)
            return getKey(map,maxCount);
        else
            return 0;
    }

    /**
     * Map<K, V>通过值来获取键
     * 利用Java 集合框架的Map类提供的 entrySet()方法，该方法返回Map的键值对Entry对象。
     * 该方法的思路是,迭代Entry集合，当值和传入的value匹配时，返回对应的key
     * @param map
     * @param value
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> K getKey(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }
    public static <K, V> Set<K> getKeys(Map<K, V> map, V value) {
        Set<K> keys = new HashSet<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }

    /**
     * 方法2:preValue记录上一次访问的值，count表明当前值出现的次数
     * @param array
     * @return
     */
    /*public static int MoreThanHalfNum_Solution(int [] array) {
        if (array == null)
            return 0;
        int preValue = array[0];
        int count = 1;
        for (int arr:array){
            if (arr == preValue)
                count ++;
            else{
                count --;
                if (count == 0){
                    preValue = arr;
                    count = 1;
                }
            }
        }*/

        /**
         * 不能根据count的大小直接判断
         * 重新遍历，记录preValue出现的次数
         */
        /*
//        if (count > 0)
//            return preValue;
//        else
//            return 0;

        int countNum = 0;
        for (int arr:array){
            if (arr == preValue)
                countNum ++;
        }
        if (countNum > array.length/2)
            return preValue;
        else
            return 0;
    }*/
}
