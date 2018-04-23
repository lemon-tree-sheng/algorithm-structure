package org.sheng.as.algorithm.dynamicprogramming.integerbreak;

import org.sheng.as.util.ListUtil;

import static org.sheng.as.util.MathUtil.max3;

/**
 * @author shengxingyue on 2018/4/23 22:58
 * 自底向上，记忆化 == 动态规划
 */
public class IntegerBreak03 {

    static int breakInteger(int n) {
        Integer[] memo = ListUtil.initList(1000, -1);
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 求解 memo[i]
            for (int j = 1; j <= i - 1; j++) {
                memo[i] = max3(j * memo[i - j], j * (i - j), memo[i]);
            }
        }
        return memo[n];
    }
}
