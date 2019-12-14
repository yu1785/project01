package leetcodePractice;
/**
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。
 * 你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数
 *
 *思路：
 *  利用 HashSet 值的唯一性 找出糖果的种类个数
 */

import java.util.HashSet;

public class _575distrubuteCandies {
    public static void main(String[] args) {
        int[] candies = {1,1,2,3};
        System.out.println(distributeCandies(candies));
//        System.out.println(set.size());
//        for (Integer s:set)
//            System.out.println(s);
    }
    public static int distributeCandies(int[] candies) {
        int len = candies.length;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0;i < len;i ++){
            set.add(candies[i]);
        }
        if (set.size() <= len/2)
            return set.size();
        else
            return len/2;

        /**
         * 下面代码虽然 更加简洁
         * 但是 执行效率 不如上面的代码
         *
         * 主要因为增强for循环：
         * 循环ArrayList时，普通for循环比foreach循环花费的时间要少一点；
         * 循环LinkList时，普通for循环比foreach循环花费的时间要多很多。
         *
         * 数组结构的数据使用普通for循环
         * 链表结构的数据使用增强for循环
         */
        /*for (int candy:candies)
            set.add(candy);
        return Math.min(len/2,set.size());*/

    }
}
