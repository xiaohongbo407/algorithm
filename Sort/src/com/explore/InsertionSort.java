package com.explore;

/**
 * @ClassName InsertionSort
 * @Description 插入排序算法
 * @Date 2018/11/14 15:16
 * @Author Xiaohb
 * @Version 1.0
 **/
public class InsertionSort extends SelectionSortComparable{

    public static void sort(Comparable[] arr){
        int n = arr.length;
        for(int i = 1; i < n; i++){
            Comparable e = arr[i];
            int j = i;
            for ( ; j > 0 && arr[j-1].compareTo(e) > 0 ; j--){
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }
    }

    //对数组arr[l...r]的区间进行排序
    public static void sort(Comparable[] arr,int l,int r){
        //需要区间值l,r；r作为数组下标与数组长度存在一个差值，所有i要小于等于r
        for(int i = l; i <= r; i++){
            Comparable e = arr[i];
            int j = i;
            //此处对j的约束是大于l,避免超过区间起始值进行排序。
            for ( ; j > l && arr[j-1].compareTo(e) > 0 ; j--){
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }
    }


    public static void main(String[] args) {

        Integer[]  arr = SortTestHelper.generateRandomArray(50000,1,100);
        SortTestHelper.testSort("com.explore.SelectionSortComparable",arr);

        Integer[]  arr1 = SortTestHelper.generateRandomArray(50000,1,100);
        SortTestHelper.testSort("com.explore.InsertionSort",arr1);

    }

}
