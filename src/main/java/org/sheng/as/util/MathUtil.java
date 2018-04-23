package org.sheng.as.util;

import static java.lang.Math.max;

/**
 * @author shengxingyue on 2018/4/23 22:54
 */
public class MathUtil {
    public static int max3(int a, int b, int c) {
        int result = max(a, b);
        result = max(result, c);
        return result;
    }
}
