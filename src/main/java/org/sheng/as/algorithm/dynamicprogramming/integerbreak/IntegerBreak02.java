package org.sheng.as.algorithm.dynamicprogramming.integerbreak;

import static org.sheng.as.util.ListUtil.initList;
import static org.sheng.as.util.MathUtil.max3;

/**
 * @author shengxingyue on 2018/4/23 22:50
 * 记忆化搜索
 */
public class IntegerBreak02 {
    static Integer[] memo = initList(1000, -1);

    static int breakInteger(int n) {
        memo[0] = 1;
        if (memo[n - 1] == -1) {
            int max = -1;
            for (int i = 1; i < n; i++) {
                max = max3(i * breakInteger(n - i), i * (n - i), max);
            }
            memo[n - 1] = max;
        }
        return memo[n - 1];
    }
}
