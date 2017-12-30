package org.sheng.mc.algorithm.sort;

import org.sheng.mc.util.TestUtil;

import static org.apache.commons.lang3.ArrayUtils.swap;
import static org.sheng.mc.util.TestUtil.TEST_ARR_MAX_INT;
import static org.sheng.mc.util.TestUtil.genRandomArray;

/**
 * 选择排序
 *
 * @author shengxingyue, created on 2017/12/30
 */
public class SelectionSort implements SortAlgorithm {

    /**
     * 算法名称
     */
    public static final String SORT_NAME = "Selection Sort";
    /**
     * 测试数组大小
     */
    public static final int TEST_ARR_SIZE = 10000;

    /**
     * 选择排序算法实现
     *
     * @param arr
     * @param n
     * @return
     */
    @Override
    public Integer[] sort(Integer[] arr, Integer n) {
        for (int i = 0; i < n - 1; i++) {
            // 临时存放当前索引，并且默认最小
            int tempMinIndex = i;
            // 比较当前索引后面数组的值，有较小的则更新最小索引
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[tempMinIndex]) {
                    tempMinIndex = j;
                }
            }
            // 如果最小索引有更新，则更新当前位置为最小索引对应值
            if (tempMinIndex != i) {
                swap(arr, i, tempMinIndex);
            }
        }
        return arr;
    }

    /**
     * 测试入口
     *
     * @param args
     */
    public static void main(String[] args) {
        TestUtil.testSort(SORT_NAME, new SelectionSort(), genRandomArray(TEST_ARR_MAX_INT, TEST_ARR_SIZE), TEST_ARR_SIZE);
    }
}
