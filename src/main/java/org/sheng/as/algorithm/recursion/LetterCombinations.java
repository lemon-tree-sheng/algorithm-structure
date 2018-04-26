package org.sheng.as.algorithm.recursion;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author shengxingyue on 2018/4/26 10:22
 * 字母组合问题：给一个数字串，类似于计算器上面 2(abc) 有这样数字和字符串的对应关系，求出所有可能的字符串可能
 */
public class LetterCombinations {

    // 数字所对应的字符串
    static String[] lettersMap = new String[]{
            " ", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz", // 9
    };

    static void getSingleLetterCombinations(char[] numArray, int index, String singleResult, List<String> res) {
        if (index == numArray.length) {
            res.add(singleResult);
            return;
        }
        char[] charArray = lettersMap[Integer.valueOf(numArray[index] + "")].toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            getSingleLetterCombinations(numArray, index + 1, singleResult + charArray[i], res);
        }
    }

    static List<String> getLetterCombinations(String digits) {
        List<String> res = Lists.newArrayList();
        getSingleLetterCombinations(digits.toCharArray(), 0, "", res);
        return res;
    }
}
