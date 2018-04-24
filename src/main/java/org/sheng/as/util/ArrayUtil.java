package org.sheng.as.util;

/**
 * @author shengxingyue on 2018/4/23 21:31
 */
public class ArrayUtil {
    public static Integer[] initArray(final Integer capacity, final Integer initialValue) {
        Integer[] result = new Integer[capacity];
        for (int i = 0; i < result.length; i++) {
            result[i] = initialValue;
        }
        return result;
    }

    public static Integer[][] initTwoDimensionalArray(final int row, final int col, final Integer initialValue) {
        Integer[][] res = new Integer[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[i][j] = initialValue;
            }
        }
        return res;
    }
}
