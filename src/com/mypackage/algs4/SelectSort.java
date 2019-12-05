package com.mypackage.algs4;

import java.util.Scanner;

public class SelectSort {
    private static void sort(String[] a) {
        //选择排序
        /*for(int i=0;i<a.length;i++){
//            int min = i;
//            for(int j=i+1;j<a.length;j++){
//                if(less(a[j],a[min]))
//                    min = j;
//                exch(a,min,i);
//            }
            for(int i=0;i<a.length;i++)
                for(int j=i+1;j<a.length;j++){
                    if(less(a[j],a[i]))
                        exch(a,i,j);
                }
        }*/

        //插入排序
        /*for(int i=1;i<a.length;i++)
            for(int j=i;j>0 && less(a[j],a[j-1]);j--)
                exch(a,j,j-1);*/

        //希尔排序
        int n = a.length;
        int h = 1;
        while(h<n/3)
            h = 3*h+1;
        while(h>=1){
            for(int i=h;i<n;i++)
                for(int j=i;j>=h&&less(a[j],a[j-h]);j-=h)
                    exch(a,j,j-h);
            h /= 3;
        }
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
//        String[] a = StdIn.readAllStrings();
        String[] a = {"as","re","et","t","aer"};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
