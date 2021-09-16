package com.yyin.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] a = {9,3,1,4,6,8,7,5,2};
        shellsort(a);
        System.out.println(Arrays.toString(a));
    }
    public static void shellsort(int[] a) {
        int length = a.length;
        int h = 1;
        while (h < length / 3) h = 3 * h + 1;
        for (; h >= 1; h /= 3) {
            for (int i = 0; i < a.length - h; i += h) {
                for (int j = i + h; j > 0; j -= h) {
                    if (a[j] < a[j - h]) swap(a,j,j-h);
                }
            }
        }
    }
    public static void swap(int[] a,int i,int j){
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
}
