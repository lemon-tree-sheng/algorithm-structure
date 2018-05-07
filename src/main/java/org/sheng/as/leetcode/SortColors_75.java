package org.sheng.as.leetcode;

/**
 * @author shengxingyue on 2018/5/6 21:46
 * 第一种解法使用计数排序，先扫描一次计数，然后根据数字来进行排序
 * 第二种解法，使用三路快排，给定两个指针，zero,two
 * [0,zero]表示0 (zero,two)表示1 [two,length - 1]表示2
 * 再来一个指针 i,从前往后遍历一次
 */
public class SortColors_75 {
    public void sortColors(int[] nums) {
        int zero = -1;
        int two = nums.length;
        for (int i = 0; i < two; ) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 0) {
                zero++;
                nums[i] = nums[zero];
                nums[zero] = 0;
                i++;
            } else {
                two--;
                nums[i] = nums[two];
                nums[two] = 2;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        new SortColors_75().sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
