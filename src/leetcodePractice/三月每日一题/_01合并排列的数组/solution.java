package leetcodePractice.三月每日一题._01合并排列的数组;

import java.util.Arrays;

/**
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。
 * 编写一个方法，将 B 合并入 A 并排序。初始化 A 和 B 的元素数量分别为 m 和 n
 *
 */
public class solution {
    public static void main(String[] args) {
        int[] A = {1,2,3,0,0,0};
        int[] B = {2,4,6};
        int m = 3;
        int n = 3;
        merge(A,m,B,n);
        for (int a:A)
            System.out.print(a);
    }
    public static void merge(int[] A, int m, int[] B, int n) {
        /**
         * 1、先合并 再sort
         */
        /*for (int i = m;i < m+n;i ++){
            A[i] = B[i-m];
        }
        Arrays.sort(A);*/

        /**
         * 2、双指针，A B按大小顺序存入新数组
         * 特别注意边界条件：1、2、3
         */
        /*if (n == 0)                 //1、B数组为空
            return;
        int pa = 0,pb = 0;
        int[] res = new int[m+n];
        for (int i = 0;i < m+n;i ++){
            if (pb >= n){              //2、pb指针超过B数组长度
                res[i] = A[pa];
                pa ++;
            }
            else if (A[pa] < B[pb] && pa < m){    //3、保证pa < m
                res[i] = A[pa];
                pa ++;
            }
            else {
                res[i] = B[pb];
                pb ++;
            }
        }
        for (int i = 0;i < m+n;i ++)
            A[i] = res[i];*/

        /**
         * 3.双指针 简化代码
         *   从后往前存放，由大到小
         */
        while (m > 0 && n > 0){
            A[m+n-1] = A[m-1] > B[n-1] ? A[m-- -1]:B[n-- -1];
        }
        // 如果 m 不为 0，则 A 没遍历完，都已经在 A 中不用再管
        // 如果 n 不为 0，则 B 没遍历完，直接全移到 A 中相同的位置
        while (n > 0){
            A[n-1] = B[n-1];
            n --;
        }

    }
}
