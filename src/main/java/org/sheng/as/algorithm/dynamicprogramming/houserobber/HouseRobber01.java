package org.sheng.as.algorithm.dynamicprogramming.houserobber;

import static java.lang.Math.max;

/**
 * @author shengxingyue on 2018/4/24 07:59
 */
public class HouseRobber01 {
    static int rob(int[] arr, int begin) {
        if (begin >= arr.length) {
            return 0;
        }
        int result = 0;
        for (int i = begin; i < arr.length; i++) {
            result = max(arr[i] + rob(arr, i + 2), result);
        }
        return result;
    }
}
