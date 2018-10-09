package yinwuteng.com.myutils.utils;

import android.util.Log;

import java.util.Arrays;

/**
 * Created by yinwuteng on 2018/1/26.
 * 算法工具类
 */

public class AlgorithmUtil {
    /**
     * 冒泡排序
     * 每次将最大的数往右边排
     *
     * @param arr 待排序数组
     * @return 返回排序后的数组
     */
    public static int[] bubbleSort(int[] arr) {
        int out, in, temp;

        for (out = arr.length - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (arr[in] > arr[in + 1]) {
                    temp = arr[in + 1];
                    arr[in + 1] = arr[in];
                    arr[in] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 选择排序
     * 每次将最小的往左边排
     *
     * @param arr 待排序数组
     * @return 返回排序后的数组
     */
    public static int[] selectSort(int[] arr) {
        int out, in, temp;
        for (out = 0; out < arr.length; out++) {
            for (in = out + 1; in < arr.length; in++) {
                if (arr[out] > arr[in]) {
                    temp = arr[in];
                    arr[in] = arr[out];
                    arr[out] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 插入排序
     * 选择一个标记
     *
     * @param arr 待排序的数组
     * @return 返回排序后的数组
     */
    public static int[] insertSort(int[] arr) {
        int out, in, temp;
        for (out = 1; out < arr.length; out++) {
            in = out;
            temp = arr[out];
            while (in > 0 && arr[in - 1] > temp) {
                arr[in] = arr[in - 1];
                in--;
            }
            arr[in] = temp;
        }
        return arr;
    }


    public static int partition(int[] arr, int left, int right) {
        int temp = arr[left];
        while (right > left) {
            //先判断基准数后面的数依次比较
            while (temp <= arr[right] && left < right) {
                right--;
            }
            //当基准数大于了arr[right]则填坑
            if (left < right) {
                arr[left] = arr[right];
                left++;
            }
            //现在是arr[right]需要填坑了
            while (temp >= arr[left] && left < right) {
                left++;
            }
            if (left < right) {
                arr[right] = arr[left];
                right--;
            }
        }
        arr[left] = temp;
        return left;
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (arr == null || left >= right || arr.length <= 1) {
            return;
        }
        int mid = partition(arr, left, right);
        quickSort(arr, left, mid);
        quickSort(arr, mid + 1, right);
    }


    public static void testQuickTest() {
        int[] arr = {6, 4, 3, 2, 7, 9, 1, 8, 5};
        quickSort(arr, 0, arr.length - 1);
        Log.v("TAG", Arrays.toString(arr));
    }
}
