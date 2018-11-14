package com.explore;

/**
 * @ClassName SelectionSortComparable
 * @Description
 * @Date 2018/11/13 11:22
 * @Author Xiaohb
 * @Version 1.0
 **/
public class SelectionSortComparable {

    /**
     * @Author Xiaohb
     * @Description //TODO
     * @Date 2018/11/13 11:19
     * @Param  [arr]
     * @return void
     */
    public static void sort(Comparable[] arr){
        int n = arr.length;
        for(int i = 0 ; i < n ; i++ ){
            //寻找[i,n]区间里的最小值的索引
            int minindex = i;
            //循环查找数组i之后的每个元素，找到最小值的下标
            for(int j = i+1; j < n; j++){
                if(arr[j].compareTo(arr[minindex]) < 0){
                    minindex = j;
                }
            }
            //交换i与minindex的数值
            swap(arr, i, minindex);
        }
    }

    public static void swap(Object[] arr, int i, int that) {
        //定义一个变量临时存储待排序元素i的值
        Object t = arr[i];
        //将最小元素that的值赋给数组i
        arr[i] = arr[that];
        //将原元素i的值赋给数组that，完成数据值的交换
        arr[that] = t;
    }

    public static void main(String[] args) {
        Integer[] a = {10,9,8,7,6,5,4,3,2,1};
        SelectionSortComparable.sort(a);
        for (int i = 0 ; i < a.length ; i++){
            System.out.print(a[i]);
            System.out.printf(" ");
        }
        System.out.println(" ");

        Double[] b = {10.1,9.2,8.3,7.4,6.5,5.6,4.7,3.8,2.9,1.0};
        SelectionSortComparable.sort(b);
        for (int i = 0 ; i < b.length ; i++){
            System.out.print(b[i]);
            System.out.printf(" ");
        }
        System.out.println(" ");
        // 测试自定义的类 Student
        Custom[] d = new Custom[4];
        d[0] = new Custom("D",90);
        d[1] = new Custom("C",100);
        d[2] = new Custom("B",95);
        d[3] = new Custom("A",95);
        SelectionSortComparable.sort(d);
        for( int i = 0 ; i < d.length ; i ++ ) {
            System.out.println(d[i]);
        }

        //测试随机数生成
        Integer[] arr = SelectiongTestHelper.generateRandomArray(10000,1,10000);
        SelectiongTestHelper.testSort("com.explore.SelectionSortComparable",arr);

        //测试随机数生成
        Integer[] arr1 = SelectiongTestHelper.generateRandomArray(100000,1,100000);
        SelectiongTestHelper.testSort("com.explore.SelectionSortComparable",arr1);

//        SelectiongTestHelper.printArray(arr);



    }

}
