package yinwuteng.com.myutils.utils;

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
            while (in > 0 && arr[in - 1] > arr[in]) {
                arr[in] = arr[in - 1];
                in--;
            }
            arr[in] = temp;
        }
        return arr;
    }


}
