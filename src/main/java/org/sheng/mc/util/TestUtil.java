package org.sheng.mc.util;

import org.apache.commons.lang3.RandomUtils;
import org.sheng.mc.algorithm.sort.SortAlgorithm;

/**
 * 测试工具类
 *
 * @author shengxingyue, created on 2017/12/30
 */
public class TestUtil {

    /**
     * 测试数组的大小
     */
    public static final int TEST_ARR_SIZE = 10000;

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

        assert isSorted(arr);
        System.out.printf("%s spent %dms%n", sortName, stop - start);
        printArr(arr);
    }
}
