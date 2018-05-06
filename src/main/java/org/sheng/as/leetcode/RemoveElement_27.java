package org.sheng.as.leetcode;

/**
 * @author shengxingyue on 2018/5/6 11:26
 * 数组题，指针方案
 * 给定两个指针 i,j
 * [0,i)表示非目标值集合
 * j为遍历指针
 */
public class RemoveElement_27 {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
