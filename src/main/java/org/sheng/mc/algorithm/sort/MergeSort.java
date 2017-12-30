package org.sheng.mc.algorithm.sort;

import static org.sheng.mc.util.TestUtil.TEST_ARR_MAX_INT;
import static org.sheng.mc.util.TestUtil.TEST_ARR_SIZE;
import static org.sheng.mc.util.TestUtil.genRandomArray;
import static org.sheng.mc.util.TestUtil.testSort;

/**
 * @author shengxingyue, created on 2017/12/30
 */
public class MergeSort implements SortAlgorithm {

    public static final String SORT_NAME = "Merge Sort";

    @Override
    public Integer[] sort(Integer[] arr, Integer n) {
        mergeSort(arr, 0, n - 1);
        return arr;
    }

    /**
     * 归并排序算法实现
     *
     * @param arr
     * @param beginIdx
     * @param endIdx
     */
    public void mergeSort(Integer[] arr, Integer beginIdx, Integer endIdx) {
        if (beginIdx >= endIdx) {
            return;
        }

        // endIdx + beginIdx 可能会发生溢出
        Integer middleIdx = (endIdx + beginIdx) / 2;
        mergeSort(arr, beginIdx, middleIdx);
        mergeSort(arr, middleIdx + 1, endIdx);
        merge(arr, beginIdx, endIdx);
    }

    /**
     * 归并实现
     *
     * @param arr
     * @param beginIdx
     * @param endIdx
     */
    private void merge(Integer[] arr, Integer beginIdx, Integer endIdx) {
        // 拷贝一份当前数组
        Integer[] copyArr = copy(arr, beginIdx, endIdx);
        // 指定拷贝数组的移动索引，原数组的移动索引
        // 拷贝数组左半部分有序数组的起始索引
        Integer copyArrLeftIdx = 0;
        // 拷贝数组中间索引，用于限制索引边界
        Integer copyArrMidIdx = (0 + copyArr.length -1) / 2;
        // 拷贝数组有半部分有序数组的起始索引
        Integer copyArrRightIdx = (copyArrMidIdx) + 1;
        // 原始数组需要归并的起始索引
        Integer originalArrIdx = beginIdx;

        // 归并过程
        while (originalArrIdx <= endIdx) {
            // 注意边界条件，拷贝数组的左半部分的索引一旦大于中间索引，那么直接取右边索引对应值，反之相同
            if (copyArrLeftIdx > copyArrMidIdx) {
                arr[originalArrIdx] = copyArr[copyArrRightIdx];
                copyArrRightIdx++;
            } else if (copyArrRightIdx > endIdx) {
                arr[originalArrIdx] = copyArr[copyArrLeftIdx];
                copyArrLeftIdx++;
            } else if (copyArr[copyArrLeftIdx] < copyArr[copyArrRightIdx]) {
                arr[originalArrIdx] = copyArr[copyArrLeftIdx];
                copyArrLeftIdx++;
            } else {
                arr[originalArrIdx] = copyArr[copyArrRightIdx];
                copyArrRightIdx++;
            }
            originalArrIdx++;
        }
    }

    /**
     * 拷贝数组
     *
     * @param arr
     * @param beginIdx
     * @param endIdx
     * @return
     */
    private Integer[] copy(Integer[] arr, Integer beginIdx, Integer endIdx) {
        Integer[] resultArr = new Integer[endIdx - beginIdx + 1];
        for (int i = beginIdx; i <= endIdx; i++) {
            resultArr[i - beginIdx] = arr[i];
        }
        return resultArr;
    }

    public static void main(String[] args) {
        Integer[] testArr = genRandomArray(TEST_ARR_MAX_INT, TEST_ARR_SIZE);
        testSort(SORT_NAME, new MergeSort(), testArr, TEST_ARR_SIZE);
    }
}
