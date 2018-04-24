package org.sheng.as.algorithm.dynamicprogramming.fibonacci;

import org.sheng.as.util.ArrayUtil;

/**
 * @author shengxingyue on 2018/4/23 21:18
 * 记忆化搜索
 */
public class Fibonacci02 {

    static Integer[] memo = ArrayUtil.initArray(1000, -1);

    static int fib(int n) {
        memo[0] = 1;
        memo[1] = 1;
        if (memo[n - 1] == -1) {
            memo[n - 1] = fib(n - 1) + fib(n - 2);
        }
        return memo[n - 1];
    }
}
