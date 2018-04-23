package org.sheng.as.algorithm.sort;

/**
 * @author shengxingyue
 * @comment 堆排序实现，时间复杂度为O(nlg(n))，不稳定，已通过单元测试
 */
public class HeapSort {
    //建堆
    public static void buildHeap(int[] arr, int n){
        if(arr == null || arr.length <= 0 || arr.length != n){
            return ;
        }
        maxHeapDown(arr, n);
    }

    //堆调整
    public static void maxHeapDown(int[] arr, int n){
        int i = (n - 1) / 2;
        for(int j = i; j >= 0; j--){
            int child = j * 2 + 1;
            while(child < n){
                if((child + 1) < n && arr[child] < arr[child + 1]){
                    child++;
                }

                if(arr[j] < arr[child]){
                    swap(arr, j, child);
                    j = child;
                    child = 2 * child + 1;
                }else{
                    break;
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}