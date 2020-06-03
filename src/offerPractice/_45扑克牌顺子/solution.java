package offerPractice._45扑克牌顺子;

import java.util.TreeSet;

/**
 * 利用 TreeSet集中元素排序并且没有重复元素出现的特点
 */
public class solution {
    public boolean isContinuous(int [] numbers) {
        if (numbers.length != 5)
            return false;
        int countZero = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0;i < numbers.length;i ++){
            if (numbers[i] == 0)
                countZero ++;
            else
                set.add(numbers[i]);
        }
        if (set.size() + countZero != 5)   //避免重复数字的出现
            return false;
        if ((set.last()-set.first()) < 5)
            return true;
        return false;
    }
}
