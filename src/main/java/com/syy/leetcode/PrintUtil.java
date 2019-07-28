package com.syy.leetcode;

public class PrintUtil {
    public static <T> void printArray(T[] array) {
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
