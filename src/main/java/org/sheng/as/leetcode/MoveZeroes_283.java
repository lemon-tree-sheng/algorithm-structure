package org.sheng.as.leetcode;

/**
 * @author shengxingyue on 2018/5/6 09:54
 * 数组题 指针来解
 * 简单题 不考虑复杂算法思想
 */
public class MoveZeroes_283 {

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1) {
            return;
        }
        int left = 0; //[0,left)区间保存非0元素
        int right = 0;
        while (right < len) {
            if (nums[right] != 0) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        for (int i = left; i < len; i++) {
            nums[i] = 0;
        }
    }
}
