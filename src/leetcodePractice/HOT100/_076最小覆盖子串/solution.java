package leetcodePractice.HOT100._076最小覆盖子串;

import java.util.HashMap;
import java.util.Map;

public class solution {
    public static void main(String[] args) {
        System.out.println(minWindow("aaabbbbbcdd","abcdd"));
    }

    /**
     * 双指针  HashMap
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        Map<Character,Integer> map_t = new HashMap<>();
        // 记录t中的字符及其个数
        for (int i = 0;i < t.length();i ++){
            char ch = t.charAt(i);
            int count = map_t.getOrDefault(ch,0);
            map_t.put(ch,count+1);
//            if (map_t.containsKey(ch))
//                map_t.put(ch,map_t.get(ch)+1);
//            else
//                map_t.put(ch,1);
        }
        int count_t = map_t.size();
        int pLeft = 0,pRight = 0;
        int count_s = 0;

        // ans list of the form (window length, left, right)
        int[] ans = {-1, 0, 0};
//        int minWin = s.length()+1;
//        int minL = 0,minR = 0;

        Map<Character,Integer> map_s = new HashMap<>();
        while (pRight < s.length()){
            // 记录s中的字符及其个数
            char ch = s.charAt(pRight);
            int count = map_s.getOrDefault(ch,0);
            map_s.put(ch,count+1);
//            if (map_s.containsKey(ch))
//                map_s.put(ch,map_s.get(ch)+1);
//            else
//                map_s.put(ch,1);

            //
            if (map_t.containsKey(ch) && map_t.get(ch).intValue() == map_s.get(ch).intValue())
                count_s ++;

             while (count_s == count_t && pLeft <= pRight){  // pLeft <= pRight 注意取=
                 ch = s.charAt(pLeft);
                 int len = pRight-pLeft+1;
                 if (ans[0] == -1 || ans[0] > len){
                     ans[0] = len;
                     ans[1] = pLeft;
                     ans[2] = pRight;
                 }
//                 if (len < minWin){
//                     minWin = len;
//                     minL = pLeft;
//                     minR = pRight;
//                 }
                 map_s.put(ch,map_s.get(ch)-1);
                 // map_s.get(ch) < map_t.get(ch) 注意这里的 <
                 if (map_t.containsKey(ch) && map_s.get(ch).intValue() < map_t.get(ch).intValue())
                     count_s --;
                 pLeft ++;
             }
            pRight ++;
        }
//        return minWin == s.length()+1 ? "" : s.substring(minL,minR+1);
        return ans[0] == -1 ? "" : s.substring(ans[1],ans[2]+1);
    }
}
