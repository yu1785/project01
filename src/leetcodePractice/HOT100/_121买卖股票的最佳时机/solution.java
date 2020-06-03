package leetcodePractice.HOT100._121买卖股票的最佳时机;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 */
public class solution {
    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        /**
         * 暴力解
         * 时间复杂度太大
         */
        /*int len = prices.length;
        int[] dp = new int[len-1];
        int max = 0;
        for (int i = 0;i <len-1;i ++){
            for (int j = i+1;j < len;j ++)
                max = Math.max(max,prices[j]-prices[i]);
        }
        return max;*/

        /**
         * 双指针
         * 从前到后依次遍历
         * 前指针指向最小值 后指针指向最大值
         */
        /*int max = 0;
        int len = prices.length;
        // 注意边缘条件
        if (len < 2)
            return 0;
        int pLeft = 0,pRight = 1;
        while (pLeft < len && pRight < len){
            if (prices[pRight] > prices[pLeft])
                max = Math.max(max,prices[pRight]-prices[pLeft]);
            else
                pLeft = pRight;
            pRight ++;
        }
        return max;*/

        /**
         * 从前到后 依次遍历
         * 记录最小价格 最大利益
         */
        int len = prices.length;
        // 注意边缘条件
        if (len < 2)
            return 0;
        int minPrice = prices[0];
        int max = 0;
        for (int i = 1;i < len;i ++){
            if (prices[i] < minPrice)
                minPrice = prices[i];
            else
                max = Math.max(max,prices[i] - minPrice);
        }
        return max;
    }
}
