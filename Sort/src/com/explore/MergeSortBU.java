package com.explore;

/**
 * @author Xiaohb
 * @version 1.0
 * @date 2018/11/16 16:37
 **/
public class MergeSortBU extends MergeSort {

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        // sz 进行归并的元素个数，每次循环sz都将翻倍
        for(int sz = 1; sz < n; sz += sz+sz){
            //
            for(int i = 0; i < n; i += sz+sz){
                //
                merge(arr,i,i+sz-1,Math.min(i+sz+sz-1,n-1));
            }
        }
    }


}
