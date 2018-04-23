package org.sheng.as.util;

/**
 * @author shengxingyue on 2018/4/23 21:31
 */
public class ListUtil {
    public static Integer[] initList(final Integer capacity, final Integer initialValue) {
        Integer[] result = new Integer[capacity];
        for (int i = 0; i < result.length; i++) {
            result[i] = initialValue;
        }
        return result;
    }
}
