package leetcodePractice.HOT100._075颜色分类;

import java.util.ArrayList;
import java.util.List;

public class solution {
    public static void main(String[] args) {
        int[] nums = {1,2,0};
        sortColors(nums);
        for (int nu:nums)
            System.out.print(nu+" ");
    }
    public static void sortColors(int[] nums) {
        /**
         * 分三个链表存储元素 最后合并
         */
        /*List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        for (int nu:nums){
            if (nu == 0)
                list1.add(nu);
            else if (nu == 1)
                list2.add(nu);
            else
                list3.add(nu);
        }
        list1.addAll(list2);
        list1.addAll(list3);
        for (int i = 0;i < list1.size();i ++)
            nums[i] = list1.get(i);*/

        /**
         * 双指针 p0 指向数字 0，p2指向数字2
         */
        int p0 = 0,p2 = nums.length-1,cur = 0;
        // 注意这里 <= 符号
        while (cur <= p2){
            if (nums[cur] == 0){
                int temp = nums[cur];
                nums[cur ++] = nums[p0];
                nums[p0 ++] = temp;
            }
            else if (nums[cur] == 2){
                int temp = nums[cur];
                nums[cur] = nums[p2];  // 这里 cur 指针不加一
                nums[p2 --] = temp;
            }
            else
                cur ++;
        }
    }
}
