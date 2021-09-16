package com.yyin.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {9,3,1,4,6,8,7,5,2};
        bubblesort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void bubblesort(int[] a) {
        for (int i = a.length-1; i >0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j]>a[j+1]) swap(a,j,j+1);
            }
        }
    }

    public static void swap(int[] a,int i , int j){
        int temp = a[i];
        a[i] = a[j];
        a[j]= temp;
    }
}
