package myPractice.华为;

import myPractice.二叉树.二叉树的遍历.TreeNodeDemo.TreeNode;
import offerPractice.ListNodeDemo.ListNode;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

/**
 * @author yu
 * @date 2020/5/6 18:53
 */
//class ListNode {
//    public int val;
//    public ListNode next = null;
//    public ListNode(int val) {
//        this.val = val;
//    }
//}
public class Main {
    public static int maxVal = 0;
    public static void main(String[] args) {
        /**
         * number 1
         */
        /*Scanner in = new Scanner(System.in);
        ListNode node = new ListNode(0);
        ListNode head = node;
//        in.nextLine();
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            node.next = new ListNode(in.nextInt());
//            System.out.println(999);
        }
        ListNode res = head.next;
        System.out.println(1111);
        while (res!=null){
            System.out.print(res.val+" ");
        }*/

        /**
         * number 2
         */
        /*Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        in.nextLine();
        int[] buff = new int[m];
        for (int i = 0;i < m;i ++){
            buff[i] = in.nextInt();
        }
        in.nextLine();
        int[][] buff_val = new int[n][2];
        for (int i = 0;i < n;i ++){
            for (int j = 0;j < 2;j ++){
                buff_val[i][j] = in.nextInt();
            }
            in.nextLine();
        }
        int valSum = 0;
        for (int count = 0;count < m;count ++){
            int max = 0;
            for (int i = 0;i < n;i ++){
                if (buff_val[i][0] < buff[count] && buff_val[i][1] > max)
                    max = buff_val[i][1];
            }
            valSum += max;
        }
        System.out.println(valSum);*/

        /**
         * number 3
         */
        Scanner in = new Scanner(System.in);
        String str = in.next();
        TreeNode root = construct(str);
        dfs(root);
        System.out.println(maxVal);
    }
    public static TreeNode construct(String str){
        String sub = str.substring(0,1);
        int flag = 0;
        if (str.charAt(0)=='-'){
            sub = str.substring(0,2);
            flag = 1;
        }
        TreeNode root = new TreeNode(Integer.valueOf(sub));
        while (str.length() == 1 || str.length() == 2)
            return root;
        str = str.substring(2+flag,str.length()-1);
        String[] strings = new String[2];
        strings[0] = str.substring(0,str.length()/2);
        strings[1] = str.substring(str.length()/2+1);
        root.left = construct(strings[0]);
        root.right = construct(strings[1]);
        return root;
    }
    public static void dfs(TreeNode root){

    }
}
