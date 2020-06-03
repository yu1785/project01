package leetcodePractice.三月每日一题._06和为S的连续正数序列;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 */
public class solution {
    public static void main(String[] args) {
        int target = 9;
//        System.out.println(findContinuousSequence(target));
        int[][] res = findContinuousSequence(target);
        for (int i = 0;i < res.length;i ++){
            for (int j = 0;j <res[i].length;j ++)
                System.out.print(res[i][j]+" ");
            System.out.println();
        }
    }
    public static int[][] findContinuousSequence(int target) {
        /**
         * 滑动窗口 返回 ArrayList<ArrayList<Integer>>转int[][]
         * 执行时间最长 消耗内存最大
         */
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 1;i <= target/2+1;i ++){
            list.add(i);
            sum += i;
            while (sum > target){
                sum -= list.get(0);
                list.remove(0);
            }
            if (sum < target)
                continue;
            if (sum == target){
                res.add(new ArrayList<>(list));
                continue;
            }
        }
        List<int[]> list1 = new ArrayList<>();
        for (int i = 0;i < res.size();i ++){
            int[] temp = new int[res.get(i).size()];
            for (int j = 0;j < res.get(i).size();j ++)
                temp[j] = res.get(i).get(j);
            list1.add(temp);
        }
        return list1.toArray(new int[list1.size()][]);

        /**
         * 滑动窗口 返回 int[][]
         * 双指针
         * 执行时间 消耗内存 居中
         */
        /*ArrayList<int[]> res = new ArrayList<>();
        int pHead = 1 , pBehind = 1;
        int sum = 0;
        while (pHead <= target/2){
            if (sum < target){
                sum += pBehind;
                pBehind ++;
            }
            else if (sum > target){
                sum -= pHead;
                pHead ++;
            }
            else {
                int[] arr = new int[pBehind-pHead];
                for (int i = pHead;i < pBehind;i ++)
                    arr[i-pHead] = i;
                res.add(arr);
                sum -= pHead;
                pHead ++;
            }
        }
        return res.toArray(new int[res.size()][]);*/

        /**
         * 参考大牛方法
         * 执行时间最短 消耗内存最小
         */
       /* List<int[]> result = new ArrayList<>();
        int i = 1;
        while(target>0)
        {
            target -= i++;
            if(target>0 && target%i == 0)
            {
                int[] array = new int[i];
                for(int k = target/i, j = 0; k < target/i+i; k++,j++)
                {
                    array[j] = k;
                }
                result.add(array);
            }
        }
        Collections.reverse(result);
        return result.toArray(new int[0][]);*/
    }
}
