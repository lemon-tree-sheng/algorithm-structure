package org.sheng.as.leetcode;

/**
 * @author shengxingyue on 2018/5/6 23:11
 */
public class FindKthLargest_215 {
    public int findKthLargest(int[] nums, int k) {
        int[] res = new int[1];
        findKthLargest(k, nums, 0, nums.length - 1, res);
        return res[0];
    }

    private int findKthLargest(int k, int[] nums, int start, int end, int[] res) {
        int tmp = partion(nums, start, end);
        if (tmp == nums.length - k) {
            res[0] = nums[tmp];
            return tmp;
        } else if (tmp < nums.length - k) {
            return findKthLargest(k, nums, tmp + 1, end, res);
        } else {
            return findKthLargest(k, nums, start, tmp - 1, res);
        }
    }

    private int partion(int[] nums, int start, int end) {
        if (start >= end) {
            return end;
        }
        int left = start;
        int right = end;
        int tmp = nums[start];
        while (left < right) {
            while (left < right && tmp <= nums[right]) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right];
            }
            while (left < right && tmp > nums[left]) {
                left++;
            }
            if (left < right) {
                nums[right] = nums[left];
            }
        }
        nums[left] = tmp;
        return left;
    }
}