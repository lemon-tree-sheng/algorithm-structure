package org.sheng.as.algorithm.dynamicprogramming.houserobber;

import org.sheng.as.util.ArrayUtil;

import static java.lang.Math.max;

/**
 * @author shengxingyue on 2018/4/24 09:04
 */
public class HouseRobber03 {

    static Integer[] memo = ArrayUtil.initArray(1000, -1);
    static int rob(int[] arr, int begin) {
        if (begin >= arr.length) {
            return 0;
        }
        int n = arr.length;
        memo[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                memo[i] = max(memo[i], arr[j] + (j + 2 < n ? memo[j+2] : 0));
            }
        }
        return memo[0];
    }
}
