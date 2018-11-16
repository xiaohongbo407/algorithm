package com.explore;

import java.util.Arrays;

/**
 * MergeSort 归并排序算法学习
 * @date 2018/11/14 16:36
 * @author Xiaohb
 * @version 1.0
 **/
public class MergeSort {

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
        //
        if(l >= r){
            return;
        }

        //计算中间值
        int mid = (l+r)/2;
        //排序左半边数组
        mergeSort(arr,l,mid);
        //排序右半边数组
        mergeSort(arr,mid+1,r);
        //归并数组
        if(arr[mid].compareTo(arr[mid+1]) > 0){
            merge(arr,l,mid,r);
        }
    }

    /**
     * 三个索引位置：i,j,k ; 边界位置：l(left),r(right) ; 中间位置：m(middle) ;
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    protected static void merge(Comparable[] arr,int l,int mid,int r){
        //
        int i = l, j = mid+1;

        //创建临时数据组存储原始数据元素
        Comparable[] aux = Arrays.copyOfRange(arr,l,r+1);

        for(int k = l; k <= r; k++){

            if(i > mid ){
                arr[k] = aux[j-l];
                j++;
            }else if(j > r){
                arr[k] = aux[i-l];
                i++;
            }else if(aux[i-l].compareTo(aux[j-l]) < 0){
                arr[k] = aux[i-l];
                i++;
            }else{
                arr[k] = aux[j-l];
                j++;
            }

        }

    }

    public static void main(String[] args) {
        Comparable[] arr =SelectiongTestHelper.generateRandomArray(500,1,50);
        //boolean isSorted = SelectiongTestHelper.isSorted(arr);
        //System.out.println(isSorted);
        SelectiongTestHelper.testSort("com.explore.MergeSort",arr);
        SelectiongTestHelper.printArray(arr);
        boolean isSorted = SelectiongTestHelper.isSorted(arr);
        System.out.println(isSorted);
    }

}
