package org.sheng.as.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shengxingyue on 2018/5/8 18:18
 */
public class LetterCombinations_17 {

    // 数字所对应的字符串
    static String[] lettersMap = new String[]{
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz", // 9
    };

    public List<String> letterCombinations(String digits) {
        return letterCombinations(digits.toCharArray(), 0);
    }

    private List<String> letterCombinations(char[] digits, int index) {
        List<String> res = new ArrayList<>();
        char[] chars = lettersMap[Integer.valueOf(digits[index] + "") - 2].toCharArray();
        int length = digits.length;
        if (index == length - 1) {
            for (int i = 0; i < chars.length; i++) {
                res.add(chars[i] + "");
            }
            return res;
        }

        List<String> subList = letterCombinations(digits, index + 1);
        for (int i = 0; i < chars.length; i++) {
            for (int i1 = 0; i1 < subList.size(); i1++) {
                res.add(chars[i] + subList.get(i1));
            }
        }
        return res;
    }
}
