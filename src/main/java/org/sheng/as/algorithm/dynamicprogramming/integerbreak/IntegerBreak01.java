package org.sheng.as.algorithm.dynamicprogramming.integerbreak;

import static org.sheng.as.util.MathUtil.max3;

/**
 * @author shengxingyue on 2018/4/23 22:35
 * 题目：将一个正整数分割成至少两个数的和，求分割出来数字的最大乘积
 */
public class IntegerBreak01 {

    static int breakInteger(int n) {
        if (n == 1) {
            return 1;
        }
        int max = -1;
        for (int i = 1; i < n; i++) {
            max = max3(i * breakInteger(n - i), i * (n - i), max);
        }
        return max;
    }

}
