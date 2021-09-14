package com.yyin.sort;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
        static int[] generateRandomArray() { //随机产生数组
            Random r = new Random();
            int[] arr = new int[100];
            for(int i = 0;i<arr.length;i++) {
                arr[i] = r.nextInt(100);
            }
            return arr;
        }

        static void check() {
            int[]  arr1 = generateRandomArray();
            int[]  arr2= new int[arr1.length];//这里一定要对数组进行复制
            System.arraycopy(arr1, 0, arr2, 0, arr1.length);//复制数组
            Arrays.sort(arr1);//用确定正确的方法计算一遍
            SelectionSortM(arr2);//用自己的方法计算一遍
            boolean same = true;
            for(int i=0;i<arr1.length;i++) {
                //比较两种算法结果是否一致
                if (arr1[i] != arr2[i]) {
                    same = false;
                    break;
                }
            }
            System.out.print(same);
        }
        static void SelectionSortM (int[] arr) {//自己写的排序算法

            for(int i = 0;i<arr.length-1;i++) {
                int min = i;
                for(int j = i+1;j<arr.length;j++) {
                    min = arr[min]<arr[j]?min:j;
                }
                swap(arr, i , min);//调用两个值互换的方法
            }
        }

        static void swap (int[] arr,int i,int j) {//两个值互换，封装为方法
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        public static void main(String[] args) {
            check();//输出结果为 true
        }
    }


