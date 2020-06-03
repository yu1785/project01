package leetcodePractice.三月每日一题._02分糖果;

/**
 * 排排坐，分糖果
 * 我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
 * 给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
 * 然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。
 * 重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。
 * 返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。
 */
public class solution {
    public static void main(String[] args) {
        int candies = 7,num_people = 4;
        int[] res =distributeCandies(candies,num_people);
        for (int re:res)
            System.out.print(re+" ");
    }
    public static int[] distributeCandies(int candies, int num_people) {
        /**
         * 1、暴力求解
         */
        /*int[] res = new int[num_people];
        for (int i = 1;candies > 0;i ++){
            if (candies < i){
                res[(i-1)%num_people] += candies;
                return res;
            }
            res[(i-1)%num_people] += i;
            candies -= i;
        }
        return res;*/

        /**
         * 2、等差数列求和
         *  constant - 1.5 < p < constant - 0.5
         *  p = floor(constant - 0.5)
         */
        int n = num_people;
        int p = (int)(Math.sqrt(2*candies+0.25)-0.5);
        int remain = candies - p*(p+1)/2;
        int row = p/n;
        int col = p%n;

        int[] res = new int[n];
        for (int i = 0;i < n;i ++){
            //等差数列求和
            res[i] = (i+1)*row + row*(row-1)*n/2;
            if (i < col)
                res[i] += i+1+row*n;
        }
        res[col] += remain;
        return res;
    }
}
