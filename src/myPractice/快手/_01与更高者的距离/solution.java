package myPractice.快手._01与更高者的距离;

public class solution {
    public static void main(String[] args) {
        int[] height = {175,173,174,163,182,177};
        int[] res = new int[height.length];
        res = DistanceToHigher(height);
        for (int re:res)
            System.out.print(re+" ");
    }
    /**
     * 获取队中从前到后每个人与前方身高高于自己的人的最短距离
     * @param height int整型一维数组 队中从前到后每个人与前方身高高于自己的人的最短距离
     * @return int整型一维数组
     */
    public static int[] DistanceToHigher (int[] height) {
        // write code here
        int[] res = new int[height.length];
        res[0] = 0;
        for (int i = 1;i < height.length;i ++){
            for (int j = i-1;j >= 0;j --){
                if (height[j] > height[i]){
                    res[i] = i-j;
                    break;
                }
            }
        }
        return res;
    }
}
