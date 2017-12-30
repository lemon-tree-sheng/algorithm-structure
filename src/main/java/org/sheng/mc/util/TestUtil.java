package org.sheng.mc.util;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomUtils;
import org.sheng.mc.algorithm.sort.InsertSort;
import org.sheng.mc.algorithm.sort.MergeSort;
import org.sheng.mc.algorithm.sort.SelectionSort;
import org.sheng.mc.algorithm.sort.SortAlgorithm;

import static org.junit.Assert.assertTrue;

/**
 * 测试工具类
 *
 * @author shengxingyue, created on 2017/12/30
 */
public class TestUtil {

    /**
     * 测试数组的大小
     */
    public static final int TEST_ARR_SIZE = 50000;
    /**
     * 生成的数组取值范围为 0 ~ TEST_ARR_MAX_INT
     */
    public static final int TEST_ARR_MAX_INT = 50000;

    /**
     * 生成随机整数数组
     *
     * @param maxInt 最大整数
     * @param n      数组大小
     * @return
     */
    public static Integer[] genRandomArray(Integer maxInt, Integer n) {
        Integer[] intList = new Integer[n];
        for (Integer i = 0; i < n; i++) {
            intList[i] = RandomUtils.nextInt(0, maxInt);
        }
        return intList;
    }

    /**
     * 生成一个近乎有序的数组
     *
     * @param n
     * @return
     */
    public static Integer[] genNearlyOrderdArray(Integer n) {
        Integer[] arr = new Integer[n];
        for (Integer i = 0; i < n; i++) {
            arr[i] = i;
        }

        // 随机找出数组中两个尽量不同的位置
        int randomIdx1 = RandomUtils.nextInt(0, n - 1);
        int randomIdx2 = RandomUtils.nextInt(0, n - 1);
        ArrayUtils.swap(arr, randomIdx1, randomIdx2);
        return arr;
    }

    /**
     * 打印数组
     *
     * @param arr
     */
    public static void printArr(Integer[] arr) {
        for (Integer anArr : arr) {
            System.out.print(anArr + " ");
        }
    }

    /**
     * 判断数组是否有序
     *
     * @param arr
     * @return
     */
    public static Boolean isSorted(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 测试排序算法
     *
     * @param sortName      排序算法名称
     * @param sortAlgorithm 算法实现类
     * @param arr           测试数组
     * @param n             测试数组的长度
     */
    public static void testSort(String sortName, SortAlgorithm sortAlgorithm, Integer[] arr, Integer n) {
        long start = System.currentTimeMillis();
        sortAlgorithm.sort(arr, n);
        long stop = System.currentTimeMillis();

        assertTrue(isSorted(arr));
        System.out.printf("%s : %dms%n", sortName, stop - start);
    }

    /**
     * 简单比较插入排序和选择排序的时间性能
     * 第一版插入排序由于有过多的交换，导致交换产生的性能损失比较大，比较起来，插入排序比选择排序要慢，因为选择排序没有多余的交换动作
     * 第二版插入排序将交换变成简单的赋值，又由于插入可以提前结束，所以插入排序一般比选择排序要快，数组越有序，性能优势越大，性能可能达到 O(n) 级别
     *
     * @param args
     */
    public static void main(String[] args) {
        // 当生成一个近乎有序的数组测试两个排序算法的时候，插入排序的时间性能优势极大
        Integer[] testArr = genNearlyOrderdArray(TEST_ARR_SIZE);
        testSort(InsertSort.SORT_NAME, new InsertSort(), testArr, TEST_ARR_SIZE);
        testSort(SelectionSort.SORT_NAME, new SelectionSort(), testArr, TEST_ARR_SIZE);
        testSort(MergeSort.SORT_NAME, new MergeSort(), testArr, TEST_ARR_SIZE);
    }
}
