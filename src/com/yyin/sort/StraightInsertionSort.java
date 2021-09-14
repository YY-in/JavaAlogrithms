package com.yyin.sort;

import java.util.Arrays;
import java.util.Random;

public class StraightInsertionSort {
    public static void main(String[] args) {
        check();

    }

    static int[] generateRandomArray() { //随机产生数组
        Random r = new Random();
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100);
        }
        return arr;
    }

    static void check() {
        int[] arr1 = generateRandomArray();
        int[] arr2 = new int[arr1.length];//这里一定要对数组进行复制
        System.arraycopy(arr1, 0, arr2, 0, arr1.length);//复制数组
        Arrays.sort(arr1);
        straightInsertionSort(arr2);
        boolean same = true;
        for(int i=0;i<arr1.length;i++) {
            //比较两种算法结果是否一致
            if (arr1[i] != arr2[i]) {
                break;
            }
        }
        System.out.print(same);
        System.out.println(Arrays.toString(arr1));
    }



    static void straightInsertionSort(int[] arr){
        // 从第一个元素开始 ，该元素认为已经被排序
        for (int i = 1; i <arr.length ; i++) {
            //取出 已排区 后的一个 新元素，并不断向前扫描，与 已排区 内的元素比较
            for (int j = i; j>0 && arr[j]<arr[j-1]; j --) {
                //当发现 新元素 小于 已排区 的元素，两元素交换
                //因为 从第一次排序开始 已排区 是有序的，即只要找到 新元素 大于 已排区元素 的地方 插入即可
                //if(arr[j]<arr[j-1])
                swap(arr,j,j-1);
            }
        }
    }

    static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
