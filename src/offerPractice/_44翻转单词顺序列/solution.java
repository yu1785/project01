package offerPractice._44翻转单词顺序列;

public class solution {
    public static void main(String[] args) {
        String str = " ";
        System.out.println(ReverseSentence(str));
    }
    public static String ReverseSentence(String str) {
        if (str == null || str.trim().length() == 0)  // 注意边缘条件 str.trim().length() == 0
            return str;
        String[] strings = str.split(" ");
        String[] result = new String[strings.length];
        int index = 0;
        for (int i = strings.length-1;i >= 0;i --){
            result[index++] = strings[i];
        }
        String res = new String();
        for (int i = 0;i < result.length;i ++){
            if (i == result.length-1){
                res += result[i];
                break;
            }
            res += result[i]+" ";
        }
        return res;
    }
}
