package leetcodePractice.HOT100._049字母异位词分组;

import java.util.*;

public class solution {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList<>();
        // 利用HashMap 巧妙存放<String,List>，以链表的形式存放值
        Map<String,List> map = new HashMap<>();
        for (String str:strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if (!map.containsKey(key))
                map.put(key,new ArrayList());
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}
