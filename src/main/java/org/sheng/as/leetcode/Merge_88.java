package org.sheng.as.leetcode;

/**
 * @author shengxingyue on 2018/5/6 22:30
 * 归并算法
 * 给定两个两个指针，i,j 分别扫描两个数组，比较指针指向的值，确定位置放入第三个数组中
 */
public class Merge_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int[] arr = new int[m + n];
        int index = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                arr[index] = nums1[i];
                i++;
            } else {
                arr[index] = nums2[j];
                j++;
            }
            index++;
        }
        if (i == m) {
            for (; j < n; j++) {
                arr[index++] = nums2[j];
            }
        } else {
            for (; i < m; i++) {
                arr[index++] = nums1[i];
            }
        }
        for (int k = 0; k < arr.length; k++) {
            nums1[k] = arr[k];
        }
    }
}
