package org.sheng.as.algorithm.sort;

import static org.sheng.as.util.TestUtil.MAX_INT;
import static org.sheng.as.util.TestUtil.genRandomArray;
import static org.sheng.as.util.TestUtil.printArr;
import static org.sheng.as.util.TestUtil.testSort;

/**
 * @author shengxingyue, created on 2018/2/1
 */
public class QuickSort implements SortAlgorithm {
    /**
     * 算法名称
     */
    public static final String SORT_NAME = "Quick Sort";

    /**
     * 测试数组大小
     */
    public static final int TEST_ARR_SIZE = 10000;

    @Override
    public Integer[] sort(Integer[] arr, Integer n) {
        quickSort(arr, 0, n - 1);
        return arr;
    }

    public void quickSort(Integer[] arr, int start, int end) {
        if (arr.length <= 1 || end <= start) {
            return;
        }
        int temp = arr[start];
        int right = end;
        int left = start;
        while (right > left) {
            for (; right > left; right--) {
                if (arr[right] < temp) {
                    arr[left] = arr[right];
                    break;
                }
            }
            if (right == left) {
                arr[right] = temp;
                break;
            }
            for (; right > left; left++) {
                if (arr[left] > temp) {
                    arr[right] = arr[left];
                    break;
                }
            }
            if (right == left) {
                arr[right] = temp;
                break;
            }
        }
        quickSort(arr, start, left - 1);
        quickSort(arr, left + 1, end);
    }

    /**
     * 测试入口
     *
     * @param args
     */
    public static void main(String[] args) {
        Integer[] arr = genRandomArray(MAX_INT, TEST_ARR_SIZE);
        printArr(arr);
        testSort(SORT_NAME, new QuickSort(), arr, TEST_ARR_SIZE);
        printArr(arr);
    }
}
