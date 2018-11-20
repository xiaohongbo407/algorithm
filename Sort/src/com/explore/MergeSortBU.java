package com.explore;

/**
 * @author Xiaohb
 * @version 1.0
 * @date 2018/11/16 16:37
 **/
public class MergeSortBU extends MergeSort {

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        // 归并的步长遍历sz 进行归并的元素个数，每次循环sz都将翻倍，2、4、8...
        //for(int sz = 1; sz <= n; sz += sz){
            // 当前步长数组和下个步长数组进行归并。
        //    for(int i = 0; i < n-sz; i += sz+sz){
                // 对arr[i...i+sz-1] 和 arr[i+sz...i+2*sz-1]进行归并
        //        merge(arr,i,i+sz-1,Math.min(i+sz+sz-1,n-1));
        //    }
        //}

        // 优化1：步长小于16的使用插入排序
        for(int i = 0; i < n ; i+=16){
            InsertionSort.sort(arr,i,Math.min(i+15,n-1));
        }
        for(int sz = 16; sz <= n; sz += sz){
            // 当前步长数组和下个步长数组进行归并。
            for(int i = 0; i < n-sz; i += sz+sz){
                // 对arr[i...i+sz-1] 和 arr[i+sz...i+2*sz-1]进行归并
                // 优化2：当待排序左数组的最后一个值大于右数组的第一个值时进行归并排序。
                if(arr[i+sz-1].compareTo(arr[i+sz])>0){
                    merge(arr,i,i+sz-1,Math.min(i+sz+sz-1,n-1));
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandomArray(1000000,1,50000);
        //Integer[] arr = SortTestHelper.generateNearlyOrderArray(1000000,500);
        SortTestHelper.testSort("com.explore.MergeSortBU",arr);
        System.out.println(SortTestHelper.isSorted(arr));
        //SortTestHelper.printArray(arr);
    }

}
