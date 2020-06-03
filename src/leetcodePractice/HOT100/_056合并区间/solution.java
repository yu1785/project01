package leetcodePractice.HOT100._056合并区间;

import java.util.Arrays;
import java.util.Comparator;

public class solution {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        intervals = merge(intervals);
        for (int i = 0;i < intervals.length;i ++){
            for (int j = 0;j < 2;j ++)
                System.out.print(intervals[i][j]+" ");
            System.out.println();
        }
    }
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        return new int[0][0];
    }
}
