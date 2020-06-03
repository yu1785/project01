package leetcodePractice.HOT100._011乘最多水的容器;

public class solution {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    /**
     * 双指针
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int area = 0,maxArea = 0;
        while (left < right){
            //耗时较短 内存消耗较多
            area = (height[left]<height[right] ? height[left]:height[right])*(right-left);
            maxArea = area>maxArea ? area:maxArea;

            //耗时较长
//            area = Math.min(height[left],height[right])*(right-left);
//            maxArea = Math.max(area,maxArea);

            //耗时居中 内存消耗居中
//            maxArea = Math.max(maxArea,Math.min(height[left],height[right])*(right-left));

            if (height[left]<height[right])
                left ++;
            else
                right --;
        }
        return maxArea;
    }
}
