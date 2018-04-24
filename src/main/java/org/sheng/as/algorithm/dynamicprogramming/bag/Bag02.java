package org.sheng.as.algorithm.dynamicprogramming.bag;

import org.sheng.as.util.ArrayUtil;

import static java.lang.Math.max;

/**
 * @author shengxingyue on 2018/4/24 21:15
 * 第一种递归方式有大量的 <n,c> 对重复计算
 * 记忆化搜索算法
 */
public class Bag02 {
    static Integer[][] memo = ArrayUtil.initTwoDimensionalArray(10, 10, -1);

    static int maxValue(int[] w, int[] v, int index, int c) {
        if (index < 0 || c <= 0) {
            return 0;
        }
        if (memo[index][c] == -1) {
            int res = maxValue(w, v, index - 1, c);
            if (w[index] <= c) {
                res = max(v[index] + maxValue(w, v, index - 1, c - w[index]), res);
            }
            memo[index][c] = res;
        }
        return memo[index][c];
    }
}
