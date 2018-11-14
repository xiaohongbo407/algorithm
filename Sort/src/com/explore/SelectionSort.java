package com.explore;

/**
 * @ClassName com.explore.SelectionSort
 * @Description 选择排序算法 时间复杂度O(n^2）
 * @Date 2018/11/13 9:56
 * @Author Xiaohb
 * @Version 1.0
 *
 **/
public class SelectionSort {
    
    /**
     * @Author Xiaohb
     * @Description //TODO
     * @Date 2018/11/13 11:19
     * @Param  [arr]
     * @return void
     **/
    public static void sort(int[] arr){
        int n = arr.length;
        for(int i = 0 ; i < n ; i++ ){
            //寻找[i,n]区间里的最小值的索引
            int minindex = i;
            //循环查找数组i之后的每个元素，找到最小值的下标
            for(int j = i+1; j < n; j++){
                if(arr[j] < arr[minindex]){
                    minindex = j;
                }
            }
            //交换i与minindex的数值
            swap(arr, i, minindex);
        }
    }

    private static void swap(int[] arr, int i, int minindex) {
        //定义一个变量临时存储待排序元素i的值
        int t = arr[i];
        //将最小元素minindex的值赋给数组i
        arr[i] = arr[minindex];
        //将原元素i的值赋给数组minindex，完成数据值的交换
        arr[minindex] = t;
    }

    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        SelectionSort.sort(arr);
        for (int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i]);
            System.out.printf(" ");
        }

    }

}
