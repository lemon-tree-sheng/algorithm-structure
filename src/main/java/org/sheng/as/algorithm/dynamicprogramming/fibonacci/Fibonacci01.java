package org.sheng.as.algorithm.dynamicprogramming.fibonacci;

/**
 * @author shengxingyue on 2018/4/23 20:58
 */
public class Fibonacci01 {
    static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
