package leetcodePractice;
/**
 * 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。
 * 例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 *
 * 现在，给定一个由许多词根组成的词典和一个句子。
 * 你需要将句子中的所有继承词用词根替换掉。
 * 如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 *
 * 你需要输出替换之后的句子。
 *
 */

import java.util.Arrays;
import java.util.List;

public class _648replaceWords {
    public static void main(String[] args) {
        List<String> dict = Arrays.asList("cat","bat","rat");
        String sentence = "the cattle was rattled by the battery";
        String str = replaceWords(dict,sentence);
        System.out.println(new String(str));
    }
    public static String replaceWords(List<String> dict, String sentence) {
        /**
         * 利用截取字符串的方式比较 substring(0,len)
         */
        /*String[] sen = sentence.split(" ");
        List<String> list = new ArrayList<>();
        for (String se:sen)
            list.add(se);

        for (int i = 0;i < list.size();i ++){
            for (String di:dict){
                int len = di.length();
                if (list.get(i).length() < di.length())
                    continue;
                if (list.get(i).substring(0,len).equals(di)){
                    System.out.println(di);
                    list.set(i,di);
                    break;
                }
            }
        }
        return String.join(" ",list);*/

        /**
         * 利用判断字符串前缀的方式比较 startsWith(di)
         */
        String[] sen = sentence.split(" ");
        for (int i = 0;i < sen.length;i ++){
            for (String di:dict){
                int len = di.length();
                if (sen[i].length() < di.length())
                    continue;
                if (sen[i].startsWith(di)){
                    sen[i] = di;
                    break;
                }
            }
        }
        return String.join(" ",sen);

    }
}
