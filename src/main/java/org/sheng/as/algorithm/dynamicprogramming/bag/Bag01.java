package org.sheng.as.algorithm.dynamicprogramming.bag;

import static java.lang.Math.max;

/**
 * @author shengxingyue on 2018/4/24 20:47
 * 0-1背包问题
 * 有一个容量为 capacity 的背包，现在有 [0...n - 1] 个物品，重量为 w[i]，价值为 v[i]，问能得到的最大价值
 * 关注点放在最后一个物品，他有放和不放两种选择
 * 状态转移方程：
 * F(n, C) = max(F(n - 1, C), v[n] + F(n - 1, C - w[n])
 */

public class Bag01 {
    static int maxValue(int[] w, int[] v, int index, int c) {
        if (index < 0 || c <= 0) {
            return 0;
        }
        int res = maxValue(w, v, index - 1, c);
        if (w[index] <= c) {
            res = max(res, v[index] + maxValue(w, v, index - 1, c - w[index]));
        }
        return res;
    }
}
