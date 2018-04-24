package org.sheng.as.algorithm.dynamicprogramming.bag;

import org.sheng.as.util.ArrayUtil;

import static java.lang.Math.max;

/**
 * @author shengxingyue on 2018/4/24 21:34
 * 动态规划
 * 自底向上 找到最初始能确定的状态
 * 递推公式 发起递推
 * <p>
 * example:
 * 三个物品：
 * w: 1     2       3
 * v: 6     10      12
 * 假设容量为 5
 * 给出以下 n,c 二维表，横轴表示容量越来越大，纵轴表示物品越来越多
 * 1   2   3   4   5
 * 1    6   6   6   6   6
 * 2    6   10  16  16  16
 * 3    6   10  12  18  22
 */
public class Bag03 {
    static int maxValue(int[] w, int[] v, int c) {
        int n = w.length;
        Integer[][] memo = ArrayUtil.initTwoDimensionalArray(c, n, -1);

        // 初始化第一行的值
        for (int j = 0; j < c; j++) {
            memo[0][j] = j >= w[0] ? v[0] : 0;
        }
        // 逐行递推上去
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < c; j++) {
                memo[i][j] = memo[i - 1][j]; // 不考虑新增的物品
                if (w[i] <= j) {
                    memo[i][j] = max(memo[i][j], v[i] + memo[i - 1][j - w[i]]); // 放入新增的物品
                }
            }
        }
        return memo[c - 1][n - 1];
    }
}
