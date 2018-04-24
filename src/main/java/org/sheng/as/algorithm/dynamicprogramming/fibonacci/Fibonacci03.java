package org.sheng.as.algorithm.dynamicprogramming.fibonacci;

import static org.sheng.as.util.ArrayUtil.initArray;

/**
 * @author shengxingyue on 2018/4/23 21:27
 * 动态规划实现方式
 * 最简单的递归有太多的重复计算，也就是重叠子问题，可以使用记忆化搜索的方式来解决
 * 递归是自顶下解决问题，动态规划则是自底向上解决问题，利用最小子问题递推到最大问题
 */
public class Fibonacci03 {
    static int fib(int n) {
        Integer[] memo = initArray(n, -1);
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i < n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n - 1];
    }
}
