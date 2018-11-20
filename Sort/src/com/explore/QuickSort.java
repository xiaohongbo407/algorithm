package com.explore;

/**
 * 快速排序，Partition
 * @author xiaohb
 * @version V1.0
 * @date 2018-11-19 10:49 PM
 **/
public class QuickSort {

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        quickSort(arr,0,n-1);

    }

    private static void quickSort(Comparable[] arr, int l, int r) {
        if(l >= r){
            return;
        }
        int p = partition(arr,l,r);
        quickSort(arr,l,p-1);
        quickSort(arr,p+1,r);

    }

    private static int partition(Comparable[] arr, int l, int r) {
        int j=l;
        Comparable v = arr[l];

        for(int i = l+1 ; i <=r ; i++){
            if(arr[i].compareTo(v) < 0){
                j++;
                swap(arr,j,i);

            }
        }
        swap(arr,l,j);

        return  j;
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        // TODO 思考为什么随机数的范围越小，快速排序的速度越慢？
        Integer[] arr = SortTestHelper.generateRandomArray(100000,1,3);
        //Integer[] arr = SortTestHelper.generateNearlyOrderArray(1000000,500);
        SortTestHelper.testSort("com.explore.QuickSort",arr);
        System.out.println(SortTestHelper.isSorted(arr));
        //SortTestHelper.printArray(arr);
    }


}
