package org.sheng.as.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shengxingyue on 2018/4/26 18:28
 * 查找表
 * 可以优化一下，查找表不需要一下子就初始化完成，而是遍历到哪一个元素，没有结果再放入
 */
public class TowSum_001 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            Integer j = map.get(target - nums[i]);
            if (j != null && j != i) {
                res[0] = i;
                res[1] = j;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] res = new TowSum_001().twoSum(nums, target);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
