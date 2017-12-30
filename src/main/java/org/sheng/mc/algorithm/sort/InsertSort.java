package org.sheng.mc.algorithm.sort;

import org.sheng.mc.util.TestUtil;

import static org.sheng.mc.util.TestUtil.TEST_ARR_MAX_INT;
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
        // 第一个元素自成有序，从第二个开始
        for (int i = 1; i < n; i++) {
            // 当前元素与前面有序元素比较，比前面有序元素小则交换位置
            // 优化：第一版交换次数过多，每一次交换有多次的互相赋值，优化后，一次比较最多产生一次赋值
            int temp = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1] > temp; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        TestUtil.testSort(SORT_NAME, new InsertSort(), genRandomArray(TEST_ARR_MAX_INT, TEST_ARR_SIZE), TEST_ARR_SIZE);
    }
}
