package myPractice.奇安信;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author yu
 * @date 2020/8/1 17:09
 */
public class Main {

    // 1 背包问题，给定总钱数，各个物品的钱数和价值，算出怎么选能达到最大价值，并输出，物品数量无限
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int n = sc.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        int[] weight = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = nums[i][0];
        }
        for (int i = 0; i < n; i++) {
            value[i] = nums[i][1];
        }
        int result = fun(weight,value,n,T);
        System.out.println(result);
    }*/
    public static int fun(int[] weight,int[] value,int n,int w){
        int[][] dp = new int[n][w+1];
        for (int i = 0; i <= w; i++) {
            dp[0][i] = i/weight[0]*value[0];
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        int max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= w; j++) {
                for (int k = 0; k*weight[i] <= j; k++) {
                    int temp = k*value[i]+dp[i-1][j-k*weight[i]];
                    if (max < temp)
                        max = temp;
                }
                dp[i][j] = max;
                max = 0;
            }
        }
        return dp[n-1][w];
    }

    // 2 全排列，给一个数组，[1，3，2，1]找到全排列之后能被7整除的数的个数
     public static List<Integer> res = new ArrayList<>();
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         List<Integer> digit = new ArrayList<>();
         String str = sc.nextLine();
         char[] chars = str.toCharArray();
         for (int i = 0; i < chars.length; i++) {
             if (i%2 != 0){
                 digit.add(Integer.valueOf(chars[i]+""));
             }
         }
         System.out.println(digit);
         int[] dig = new int[digit.size()];
         for (int i = 0; i < dig.length; i++) {
             dig[i] = digit.get(i);
         }
        System.out.println(reletive_7(dig));
     }

    public static int reletive_7 (int[] digit) {
        // write code here
        int len = digit.length;
        if (digit.length == 0)
            return 0;
        if (digit.length == 1)
            return digit[0]%7 == 0 ? 1:0;
        List<Integer> list = IntStream.of(digit).boxed().collect(Collectors.toList());
        dfs(list,"",len);
        int count = 0;
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i)%7 == 0)
                count ++;
        }
        return count;
    }

    public static void dfs(List<Integer> list, String prefix,int len){
        if (prefix.length()!=0 && prefix.length()==len){
            res.add(Integer.valueOf(prefix));
        }
        for (int i = 0; i < list.size(); i++) {
            List<Integer> temp = new ArrayList<>(list);
            int item = temp.remove(i);
            dfs(temp,prefix+item,len);
        }
    }

}
