package org.sheng.as.leetcode;

/**
 * @author shengxingyue on 2018/5/7 13:36
 * 滑动窗口问题
 */
public class MinSubArrayLen_209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int minLen = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int sum = nums[0];
        while (j < nums.length) {
            if (sum < s) {
                j++;
                if (j < nums.length) {
                    sum += nums[j];
                }
            } else {
                minLen = min(minLen, j - i + 1);
                sum -= nums[i];
                i++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    private int min(int a, int b) {
        return a > b ? b : a;
    }
}
