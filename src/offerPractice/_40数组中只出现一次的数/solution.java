package offerPractice._40数组中只出现一次的数;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class solution {
    public static void main(String[] args) {
        int[] array = {2 ,4 ,3 ,6 ,3 ,2 ,5 ,5};
        int[] num1 = {1};
        int[] num2 = {1};
        FindNumsAppearOnce(array,num1,num2);
        System.out.println(num1[0]+" "+num2[0]);
    }

    /**
     * HashMap的方法
     * @param array
     * @param num1
     * @param num2
     */
   /* public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < array.length;i ++){
            if (map.containsKey(array[i]))
                map.put(array[i],map.get(array[i])+1);
            else
                map.put(array[i],1);
        }

        *//*List<Integer> keyList = new ArrayList<>();
        for(Integer key: map.keySet()){
            if(map.get(key).equals(1)){
                keyList.add(key);
            }
        }
        Object[] list = keyList.toArray();
        num1[0] = keyList.get(0);
        num2[0] = keyList.get(1);*//*

        int count = 0;
        for(int i=0; i < array.length; i++){
            if(map.get(array[i]) == 1){
                if(count == 0){
                    num1[0] =  array[i];
                    count++;
                }else
                    num2[0] =  array[i];
            }
        }
    }*/

    /**
     * 位运算中异或的性质：两个相同数字异或=0，一个数和0异或还是它本身
     * 只有一个数出现一次时，我们把数组中所有的数，依次异或运算，
     * 最后剩下的就是落单的数，因为成对儿出现的都抵消了。
     * @param array
     * @param num1
     * @param num2
     */
    public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {

    }
}
