package algs.mypackage.algs4;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Scanner;

public class QuickSort {
    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }

    //基本快速排序
    /*public static void sort(Comparable[] a,int lo,int hi){
        if(hi <= lo)
            return;
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    public static int partition(Comparable[] a,int lo,int hi){
        int i = lo;
        int j = hi+1;
        Comparable v = a[lo];
        while (true){
            while(less(a[++i],v))
                if(i == hi)
                    break;
            while (less(v,a[--j]))
                if (j == lo)
                    break;
            if (i >= j)
                break;
            exch(a,i,j);
        }
        exch(a,j,lo);
        return j;
    }*/

    //三向切分快速排序
    private static void sort (Comparable[] a,int lo,int hi) {
        if(lo >= hi)
            return;
        int lt = lo;
        int i = lo+1;
        int gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0)
                exch(a,lt++,i++);
            else if (cmp > 0)
                exch(a,i,gt--);
            else
                i ++;
        }
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }

    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a){
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    private static boolean isSorted(Comparable[] a){
        for(int i=1;i<a.length;i++)
            if(less(a[i],a[i-1]))
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] a = {"as","re","et","t","aer"};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
