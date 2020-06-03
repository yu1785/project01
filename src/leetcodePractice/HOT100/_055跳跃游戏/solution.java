package leetcodePractice.HOT100._055跳跃游戏;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。 （注意审题 能跳跃的最大长度）
 * 判断你是否能够到达最后一个位置
 */
public class solution {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }

    /**
     * 回溯遍历 超时
     * @param nums
     * @return
     */
    /*public static boolean canJump(int[] nums) {
        return Jump(nums,0);
    }
    public static boolean Jump(int[] nums,int index) {
        if (index == nums.length-1)
            return true;
        if (nums[index] == 0)
            return false;
        int bigestIndex = Math.min(index+nums[index],nums.length-1);
        for (int i = bigestIndex;i > index;i --)
            if (Jump(nums,i))
                return true;
        return false;
    }*/

    /**
     * 贪心算法
     * 从后向前搜索
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int index = nums.length-1;
        for (int i = nums.length-1;i >= 0;i --){
            if (i + nums[i] >= index)
                index = i;
        }
        return index == 0;
    }
}
