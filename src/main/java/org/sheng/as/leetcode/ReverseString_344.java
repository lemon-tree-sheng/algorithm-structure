package org.sheng.as.leetcode;

/**
 * @author shengxingyue on 2018/5/7 11:17
 */
public class ReverseString_344 {

    public String reverseString(String s) {
        if (s.length() == 1) {
            return s;
        }
        int i = 0;
        int j = s.length() - 1;
        char[] ss = s.toCharArray();
        while (i < j) {
            swap(ss, i++, j--);
        }
        return String.valueOf(ss);
    }

    private void swap(char[] ss, int i, int j) {
        char tmp = ss[i];
        ss[i] = ss[j];
        ss[j] = tmp;
    }
}
