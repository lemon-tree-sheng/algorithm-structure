package org.sheng.mc.algorithm.sort;

import org.sheng.mc.util.TestUtil;

import static org.apache.commons.lang3.ArrayUtils.swap;
import static org.sheng.mc.util.TestUtil.TEST_ARR_SIZE;
import static org.sheng.mc.util.TestUtil.genRandomArray;

/**
 * @author shengxingyue, created on 2017/12/30
 */
public class InsertSort implements SortAlgorithm {

    /**
     * 插入排序
     */
    public static final String SORT_NAME = "Insert Sort";

    /**
     * 插入排序实现
     *
     * @param arr
     * @param n
     * @return
     */
    @Override
    public Integer[] sort(Integer[] arr, Integer n) {
        if (n == 1) {
            return arr;
        }
        // 第一个元素自成有序，从第二个开始
        for (int i = 1; i < n; i++) {
            // 当前元素与前面有序元素比较，比前面有序元素小则交换位置
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j, j - 1);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        TestUtil.testSort(SORT_NAME, new InsertSort(), genRandomArray(TEST_ARR_SIZE, TEST_ARR_SIZE), TEST_ARR_SIZE);
    }
}
