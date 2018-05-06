package org.sheng.as.leetcode;

/**
 * @author shengxingyue on 2018/5/6 12:08
 * 数组题，双指针方案
 * 给定指针 i,[0,i]表示不重复数组
 * 给定指针 j,顺序扫描
 */
public class RemoveDuplicates_26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}
