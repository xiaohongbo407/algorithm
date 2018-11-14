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

    /*public static void sort(Comparable[] arr){
        int n = arr.length;
        // 从第二个元素开始对比之前得元素得大小
        for(int i = 1 ; i < n ; i++ ){
           // 寻找元素i之前得每个元素与前一个元素比较，符合排序条件得则调换值得位置
           for(int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0; j-- ) {
               swap(arr,j,j-1);
           }
        }
    }*/

    public static void main(String[] args) {

        Integer[]  arr =SelectiongTestHelper.generateRandomArray(50000,1,100);
        SelectiongTestHelper.testSort("com.explore.SelectionSortComparable",arr);

        Integer[]  arr1 =SelectiongTestHelper.generateRandomArray(50000,1,100);
        SelectiongTestHelper.testSort("com.explore.InsertionSort",arr1);

    }

}
