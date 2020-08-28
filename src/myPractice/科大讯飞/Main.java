package myPractice.科大讯飞;

import java.util.Scanner;

/**
 * @author yu
 * @date 2020/7/31 17:57
 */
public class Main {
    /**
     * 1
     * 给1，5，10，50，100面额的一定数量的钱，给你一个数，用他们组合成这个数同时用的钱数量最少。
     * 用了一个while循环直接循环减直到0，判断钱数是否都大于0，是的话输出，不是输出-1
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[5];
        for (int i = 0; i < 5; i++) {
            num[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(Sort(num[0],num[1],num[2],num[3],num[4],target));
    }
    public static int Sort(int a,int b,int c,int d,int e,int target){
        int count = 0;
        while (target >= 100 && e > 0){
            target -= 100;
            count ++;
            e --;
        }
        while (target >= 50 && d > 0){
            target -= 50;
            count ++;
            d --;
        }
        while (target >= 10 && c > 0){
            target -= 10;
            count ++;
            c --;
        }
        while (target >= 5 && b > 0){
            target -= 5;
            count ++;
            b --;
        }
        while (target >= 1 && a > 0){
            target -= 1;
            count ++;
            a --;
        }
        if (target == 0)
            return count;
        else
            return -1;
    }

    // 2 给你一个序列，输出他的排序过程
    // 25 84 21 47 15 27 68 35 20
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        quickSort(arr,0,arr.length-1);
    }*/
    public static void quickSort(int[] arr,int left,int right){
        if (arr.length < 2)
            return;
        if (left < right){
            int mid = partition(arr,left,right);
            quickSort(arr,left,mid-1);
            quickSort(arr,mid+1,right);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }
    public static int partition(int[] arr,int left,int right){
        int begin = left;
        int end = right;
        int key = right;
        while (begin < end){
            while (begin < end && arr[begin] <= arr[key])
                begin ++;
            while (begin < end && arr[end] >= arr[key])
                end --;
            swap(arr,begin,end);
        }
        swap(arr,begin,key);
        return begin;
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 3 判断2个矩形是否有交叉
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr1 = new int[2][2];
        int[][] arr2 = new int[2][2];
        int n = 0;
        String str = sc.nextLine();
        String [] arr = str.split(" ");
        if (arr.length != 8)
            System.out.println(0);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                arr1[i][j] = Integer.parseInt(arr[n]);
                n ++;
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                arr2[i][j] = Integer.parseInt(arr[n]);
                n ++;
            }
        }
        int minx2 = Math.min(arr1[1][0],arr2[1][0]);
        int miny2 = Math.min(arr1[1][1],arr2[1][1]);
        int maxx1 = Math.max(arr1[0][0],arr2[0][0]);
        int maxy1 = Math.max(arr1[0][1],arr2[0][1]);
        if (minx2 >= maxx1 && miny2 >= maxy1)
            System.out.println(1);
        else
            System.out.println(0);
    }*/

    // 4 输入任意一个字符串，提取里面的整数，要考虑各种异常输入情况
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        str = str.trim();
        String res = "";
        if (str != null && !"".equals(str)){
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i)>=48 && str.charAt(i)<=57){
                    res += str.charAt(i);
                }
            }
        }
        System.out.println(res);
    }*/

}
