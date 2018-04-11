package main.baseSort;

import java.util.Arrays;

public class QuickSort {

    private static void quickSort1(int[] nums, int left, int right){
        if(left >= right - 1) return;
        int temp = nums[left];
        int i = left, j = right - 1;
        while(i < j){
            while(i < j && nums[j] >= temp){
                j--;
            }
            if(i < j){
                nums[i++] = nums[j];
            }
            while(i < j && nums[i] <= temp){
                i++;
            }
            if(i < j){
                nums[j--] = nums[i];
            }
        }
        nums[i] = temp;
        quickSort2(nums, left, i);
        quickSort2(nums, i + 1, right);
    }
    /**
     * 快速排序挖洞填坑法
     * @param nums
     * @param left
     * @param right
     */
    private static void quickSort2(int[] nums, int left, int right){
        if(left >= right - 1) return;
        int temp = nums[left];
        int i = left, j = right - 1;
        while(i < j){
            while(i < j && nums[j] >= temp){
                j--;
            }
            if(i < j){
                nums[i++] = nums[j];
            }
            while(i < j && nums[i] <= temp){
                i++;
            }
            if(i < j){
                nums[j--] = nums[i];
            }
        }
        nums[i] = temp;
        quickSort2(nums, left, i);
        quickSort2(nums, i + 1, right);
    }
    public static void main(String[] args) {
        int[] nums = new int[]{7,9,3,5,0,2,1,4};
        quickSort2(nums, 0, nums.length);
        System.out.println(Arrays.toString(nums));
    }
}
