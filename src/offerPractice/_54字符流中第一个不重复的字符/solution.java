package offerPractice._54字符流中第一个不重复的字符;

import java.lang.Character;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class solution {
    /**
     * 队列
     */
    /*int[] charCount = new int[128];    // ACSII码字符共128个
    Queue<Character> queue = new LinkedList<Character>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (charCount[ch]++ == 0){
            queue.add(ch);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char ch = 0;
        while (queue.peek() != null){
            ch = queue.peek().charValue();
            if (charCount[ch] == 1)
                return ch;
            else
                queue.remove();
        }
        return '#';
    }*/

    /**
     * LinkedHashMap有序 HashMap无序
     */
    LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
    public void Insert(char ch)
    {
        if(map.containsKey(ch)) {
            map.put(ch,-1);
        } else {
            map.put(ch, 1);
        }
    }
    public char FirstAppearingOnce()
    {
        Iterator<Character> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            char cur = iterator.next();
            if(map.get(cur) == 1) {
                return cur;
            }
        }
        return '#';
    }
}
