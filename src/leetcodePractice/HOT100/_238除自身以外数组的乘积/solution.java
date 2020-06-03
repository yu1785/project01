package leetcodePractice.HOT100._238除自身以外数组的乘积;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yu
 * @date 2020/5/8 21:34
 */
public class solution {
    public static void main(String[] args) {
        int[] num = {1,2,3};
        int[] res = new int[num.length];
        res = productExceptSelf(num);
        for (int nu:res)
            System.out.print(nu+" ");
//        System.out.println(Math.pow(2,-1));
    }

    /**
     * 总乘积除当前位的值
     * @param nums
     * @return
     */
    /*public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int mul = 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] == 0)
                list.add(i);
            else
                mul *= nums[i];
        }
        if (list.size() > 1)
            return new int[nums.length];
        else if (list.size() == 1 && nums.length == 2)
            return new int[]{nums[1],nums[0]};
        else if (list.size() == 1)
            res[list.get(0)] = mul;
        else if (list.size() == 0)
            for (int i = 0; i < nums.length; i++)
                res[i] = (int) (mul*Math.pow(nums[i],-1));
        return res;
    }*/

    /**
     *左右相乘法
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int left = 1,right = 1;
        for (int i = 0; i < nums.length ; i++) {
            res[i] = left;
            left *= nums[i];
        }
        for (int i = nums.length-1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
