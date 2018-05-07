package org.sheng.as.leetcode;

/**
 * @author shengxingyue on 2018/5/7 10:57
 */
public class IsPalindrome_125 {
    public boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        char[] ss = s.toLowerCase().toCharArray();
        int i = 0;
        int j = ss.length - 1;
        while (i <= j) {
            if (isValidChar(ss[i])) {
                if (isValidChar(ss[j])) {
                    if (ss[i] != ss[j]) {
                        return false;
                    }
                    i++;
                    j--;
                } else {
                    j--;
                }
            } else {
                i++;
            }
        }
        return true;
    }

    private boolean isValidChar(char c) {
        return (c <= 'z' && c >= 'a') || (c <= '9' && c >= '0');
    }
}
