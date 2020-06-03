package offerPractice._41和为S的连续正数序列;

import java.util.ArrayList;

/**
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 * 思路：从1开始在list中一次添加元素，和大于sum删除首元素，小于继续添加元素
 */
public class solution {
    public static void main(String[] args) {
        int sum = 9;
        System.out.println(FindContinuousSequence(sum));
    }
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> allList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<>();
        int small = 1;
        int currentSum = 0;
        for (int i = 1;i < sum;i ++ ){
            currentSum += i;
            list.add(i);
            while (currentSum > sum){
                currentSum -= list.get(0);
                list.remove(0);
                small = list.get(0);
            }
            if (currentSum < sum){
                continue;
            }
            if (currentSum == sum){
                // 直接 allList.add(list) 不对，使用 allList.add(list1)
//                ArrayList<Integer> list1 = new ArrayList<>();
//                for (Integer li:list)
//                    list1.add(li);
//                allList.add(list1);

                // 直接 allList.add(list) 不对
                allList.add(new ArrayList<>(list));
                /* 注意：
                 * 使用allList.add(new ArrayList<>(list)) 而不用allList.add(list)
                 * listAll.add(list)是把list这个对象的引用地址添加到listAll了，listAll中的元素就会共用list，
                 * 而list是我们用来存放当前路径的地方，因此我们需要复制一份之后加入listAll数组中
                 */
            }
        }
        return allList;
    }
}
