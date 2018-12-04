package com.explore;

/**
 * MergeSort 归并排序算法学习
 * @date 2018/11/14 16:36
 * @author Xiaohb
 * @version 1.0
 **/
public class MergeSort2 extends MergeSort {

    /**
     *
     * @param arr 待排序数组
     **/
    public static void sort(Comparable[] arr){
        int n = arr.length;
        //调用递归方法进行排序,
        mergeSort(arr,0,n-1);
    }

    /**
     * 分级，二分排序，N log(N)
     * @param arr 待排序数组
     * @param l 左边界索引
     * @param r 右边界索引
     */
    private static void mergeSort(Comparable[] arr, int l,int r){
        //优化1：当数组元素小于等于15的时候，使用插入排序
        //TODO 思考：为什么是15？
        if(r-l <=15){
            InsertionSort.sort(arr,l,r);
            return;
        }

        //计算中间值
        int mid = (l+r)/2;
        //排序左半边数组
        mergeSort(arr,l,mid);
        //排序右半边数组
        mergeSort(arr,mid+1,r);
        //归并数组
        //优化2：当左半边数组最后一个元素大于右半边数据的第一个元素，进行归并操作。
        if(arr[mid].compareTo(arr[mid+1]) > 0){
            merge(arr,l,mid,r);
        }
    }



    public static void main(String[] args) {
        //Comparable[] arr =SortTestHelper.generateRandomArray(500000,1,50);

        //Comparable[] arr =SortTestHelper.generateNearlyOrderArray(5000000,200);
        //SortTestHelper.testSort("com.explore.InsertionSort",arr);
        //boolean isSorted = SortTestHelper.isSorted(arr);
        //System.out.println(isSorted);

        Comparable[] arr1 = SortTestHelper.generateRandomArray(1000000,1,1000000);
        //Comparable[] arr1 =SortTestHelper.generateNearlyOrderArray(1000000,100);
        SortTestHelper.testSort("com.explore.MergeSort2",arr1);
        System.out.println(SortTestHelper.isSorted(arr1));
    }

}
