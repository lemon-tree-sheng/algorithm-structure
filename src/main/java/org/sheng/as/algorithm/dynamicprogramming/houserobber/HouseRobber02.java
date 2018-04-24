package org.sheng.as.algorithm.dynamicprogramming.houserobber;

import org.sheng.as.util.ArrayUtil;

import static java.lang.Math.max;

/**
 * @author shengxingyue on 2018/4/24 08:56
 */
public class HouseRobber02 {

    static Integer[] memo = ArrayUtil.initArray(1000, -1);

    static int rob(int[] arr, int begin) {
        if (begin >= arr.length) {
            return 0;
        }
        if (memo[begin] == -1) {
            for (int i = begin; i < arr.length; i++) {
                memo[begin] = max(arr[i] + rob(arr, i + 2), memo[begin]);
            }
        }
        return memo[begin];
    }
}
