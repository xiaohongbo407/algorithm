package com.explore;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author xiaohb
 * @program
 * @description
 * @date 2018-11-13 11:23 PM
 **/
public class SortTestHelper {

    /**
     * 生成一个大小为n个元素的数组，数组中每个元素在rangeL和rangeR之间随机生成。
     * @param n 随机生成元素数组个数
     * @param rangeL 生成元素最小值
     * @param rangeR 生成元素最大值
     * @return 随机数组
     */
    public static Integer[] generateRandomArray(int n,int rangeL,int rangeR){
        Integer[] arr = new Integer[n];
        for (int i = 0 ; i < n ; i++ ){
            arr[i] = new Integer((int)(Math.random() * (rangeR - rangeL +1) + rangeL));
        }
        return  arr;
    }

    /**
     * 生成一个近乎有序的数组，首先生成一个长度为n的完全有序的数组，之后随机交换swapTimes对数组元素
     * swapTimes定义了数组的无序程度，当swapTimes等于零时，数据是完全有序的
     * swapTimes越大，数组越趋向于无序
     * @param n
     * @param swapTimes
     * @return
     */
    public static Integer[] generateNearlyOrderArray(int n,int swapTimes){
        Integer[] arr = new Integer[n];
        for (int i=0;i<n;i++){
            arr[i]=new Integer(i);
        }
        for (int i = 0; i < swapTimes ; i++){
            int a = (int)(Math.random()*n);
            int b = (int)(Math.random()*n);
            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }
        return arr;
    }

    public static void printArray(Object arr[]){
        for (int i = 0; i < arr.length; i++){
            System.out.print( arr[i] );
            System.out.print( ' ' );
        }
        System.out.println();

    }

    /**
     * 判断arr数组是否有序
     * @param arr
     * @return
     */
    public static boolean isSorted(Comparable[] arr){
        for (int i = 0 ; i < arr.length - 1 ; i++){
            if(arr[i].compareTo(arr[i+1]) > 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 测试sortClassName所对应的排序算法排序arr数组所得到结果的正确性和算法运行时间
     * @param sortClassName
     * @param arr
     */
    public static void testSort(String sortClassName,Comparable[] arr){
        // 通过Java的反射机制，通过排序的类名，运行排序函数
        try {
            // 通过sortClassName获得排序函数的Class对象
            Class sortClass = Class.forName(sortClassName);
            // 通过排序函数的Class对象获得排序方法
            Method sortMethod = sortClass.getMethod("sort",new Class[]{Comparable[].class});
            // 排序参数只有一个，是可比较数组arr
            Object[] params= new Object[]{arr};

            long startTime = System.currentTimeMillis();
            // 调用排序函数
            sortMethod.invoke(null,params);

            long endTime = System.currentTimeMillis();

            assert isSorted(arr);

            System.out.println(sortClass.getSimpleName() +" : " + (endTime - startTime) + " ms");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }




    public static void main(String[] args) {

    }

}
