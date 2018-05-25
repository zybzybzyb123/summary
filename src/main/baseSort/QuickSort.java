package main.baseSort;

import java.util.Arrays;

/**
 * 快速排序,左闭右开区间[)
 */
public class QuickSort {
    private static void swap(int[] nums, int i, int j){
        //同一位置不交换
        if(i == j) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    /**
     * 快速排序单向扫描法
     * @param nums
     * @param left
     * @param right
     */
    public static void quickSort1(int[] nums, int left, int right){
        if(left >= right - 1) return;
        int temp = nums[left];
        int i = left, j = left + 1;
        while(j < right){
            if(nums[j] < temp){
                i++;
                swap(nums, i, j);
            }
            j++;
        }
        swap(nums, left, i);
        quickSort1(nums, left, i);
        quickSort1(nums, i + 1, right);
    }
    /**
     * 快速排序挖洞填坑法
     * @param nums
     * @param left
     * @param right
     */
    public static void quickSort2(int[] nums, int left, int right){
        if(left >= right - 1) return;
        int temp = nums[left];
        int i = left, j = right - 1;
        while(i < j){
            //扫描时必须有一个取等号，不然遇到和基准相同的值时会陷入死循环
            while(i < j && nums[j] >= temp){
                j--;
            }
            nums[i] = nums[j];
            while(i < j && nums[i] <= temp){
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = temp;
        quickSort2(nums, left, i);
        quickSort2(nums, i + 1, right);
    }


}
