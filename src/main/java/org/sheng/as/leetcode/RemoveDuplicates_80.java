package org.sheng.as.leetcode;

/**
 * @author shengxingyue on 2018/5/6 12:18
 * 数组问题 双指针方案
 * 给定指针 i,[0,i]表示有效数据
 * 给定指针 j,顺序扫描
 */
public class RemoveDuplicates_80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int i = 1;
        for (int j = 2; j < nums.length; j++) {
            if (nums[j] == nums[i]) {
                if (nums[i - 1] != nums[i]) {
                    nums[++i] = nums[j];
                }
            } else {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}
