package com.syy.leetcode;

import java.util.ArrayList;
import java.util.List;


public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> array = new ArrayList<Integer>();
        int line = matrix.length;
        if (line == 0) {
            return array;
        }
        int row = matrix[0].length;
        if (row == 0) {
            return array;
        }
        int minLine = 0;
        int minRow = 0;
        int total = line * row;
        int i = 0;
        int j = 0;
        // 0 up 1 right 2 bottom 3 left
        int side = 0;
        while (array.size() < total) {
            System.out.println(i + " " + j);
            array.add(matrix[i][j]);
            switch (side) {
                case 0:
                    if (j == row - 1) {
                        i++;
                        side = 1;
                        minLine++;
                    }else {
                        j++;
                    }
                    break;
                case 1:
                    if (i == line - 1) {
                        j--;
                        side = 2;
                        row--;
                    }else {
                        i++;
                    }
                    break;
                case 2:
                    if (j == minRow) {
                        i--;
                        side = 3;
                        line--;
                    }else {
                        j--;
                    }
                    break;
                case 3:
                    if (i == minLine) {
                        j++;
                        side = 0;
                        minRow++;
                    }else {
                        i--;
                    }
                    break;
            }

        }
        return array;
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n <= 0) {
            return matrix;
        }
        int line = n;
        int row = n;
        int minLine = 0;
        int minRow = 0;
        int total = line * row;
        int i = 0;
        int j = 0;
        // 0 up 1 right 2 bottom 3 left
        int side = 0;
        int numCount = 1;
        while (numCount <= total) {
            System.out.println(i + " " + j);
            matrix[i][j] = numCount;
            switch (side) {
                case 0:
                    if (j == row - 1) {
                        i++;
                        side = 1;
                        minLine++;
                    }else {
                        j++;
                    }
                    break;
                case 1:
                    if (i == line - 1) {
                        j--;
                        side = 2;
                        row--;
                    }else {
                        i++;
                    }
                    break;
                case 2:
                    if (j == minRow) {
                        i--;
                        side = 3;
                        line--;
                    }else {
                        j--;
                    }
                    break;
                case 3:
                    if (i == minLine) {
                        j++;
                        side = 0;
                        minRow++;
                    }else {
                        i--;
                    }
                    break;
            }
            numCount++;
        }
        return matrix;
    }

    public static void main(String[] args) {
        SpiralMatrix obj = new SpiralMatrix();
//        [[1,2,3,4,5],[6,7,8,9,10],[11,12,13,14,15],[16,17,18,19,20],[21,22,23,24,25]]
//        List<Integer> ret = obj.spiralOrder(new int[][]{
//                {1,2,3,4,5},
//                {6,7,8,9,10},
//                {11,12,13,14,15},
//                {16,17,18,19,20},
//                {21,22,23,24,25}});
//        for (Integer i : ret) {
//            System.out.println(i);
//        }
        int[][] ret = obj.generateMatrix(5);
    }
}
