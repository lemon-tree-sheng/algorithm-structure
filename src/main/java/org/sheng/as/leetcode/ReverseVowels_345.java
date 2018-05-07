package org.sheng.as.leetcode;


/**
 * @author shengxingyue on 2018/5/7 11:24
 */
public class ReverseVowels_345 {

    public String reverseVowels(String s) {
        if (s.length() == 1) {
            return s;
        }
        int i = 0;
        int j = s.length() - 1;
        char[] ss = s.toCharArray();
        while (i < j) {
            if (isVowelChar(ss[i])) {
                if (isVowelChar(ss[j])) {
                    swap(ss, i, j);
                    i++;
                    j--;
                } else {
                    j--;
                }
            } else {
                i++;
            }
        }
        return String.valueOf(ss);
    }

    private boolean isVowelChar(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    private void swap(char[] ss, int i, int j) {
        char tmp = ss[i];
        ss[i] = ss[j];
        ss[j] = tmp;
    }
}
