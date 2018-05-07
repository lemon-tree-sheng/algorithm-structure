package org.sheng.as.leetcode;

/**
 * @author shengxingyue on 2018/5/7 10:40
 * 对撞指针
 */
public class TwoSum_167 {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        int[] res = new int[2];
        while (i < j) {
            int tmp = numbers[j] + numbers[i];
            if (tmp == target) {
                res[0] = i + 1;
                res[1] = j + 1;
                break;
            } else if (tmp < target) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}
