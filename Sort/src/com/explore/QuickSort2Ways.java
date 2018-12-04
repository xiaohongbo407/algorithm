package com.explore;

/**
 * @author xiaohb
 * @version V1.0
 * @date 2018-11-20 11:16 PM
 **/
public class QuickSort2Ways {
    // 我们的算法类不允许产生任何实例
    private QuickSort2Ways(){}

    public static void sort(Comparable[] arr){
        int n = arr.length;

        quickSort(arr,0,n-1);

    }

    private static void quickSort(Comparable[] arr, int low, int high) {
        int l = low+1;
        int h = high;
        Comparable v = arr[low];

        while(l < h){
            while(l < h && arr[h].compareTo(v) >= 0){
                h--;
            }
            if(l < h){
                Comparable temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                l++;
            }
            while(l < h && arr[l].compareTo(v) <= 0){
                l++;
            }
        }


    }


    // 测试 QuickSort
    public static void main(String[] args) {

        // Quick Sort也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 50);
        SortTestHelper.testSort("com.explore.QuickSort2Ways", arr);

        return;
    }
}
