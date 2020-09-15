package offerPractice._31整数中1出现的次数;

/**
 * 求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）
 *
 * 根据当前位 cur 值的不同，分为以下三种情况：
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(13));
    }
    public static int NumberOf1Between1AndN_Solution(int n) {
        int high = n/10,low = 0,cur = n%10;
        int count = 0,digit = 1;
        while (high!=0  || cur != 0){
            if (cur == 0)
                count += high*digit;
            else if (cur == 1)
                count += high*digit+low+1;
            else
                count += (high+1)*digit;
            low += cur*digit;
            cur = high%10;
            high /= 10;
            digit *= 10;
        }
        return count;
    }
}
