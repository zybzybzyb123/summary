package main.baseSort;

import java.util.Arrays;
import java.util.Random;

public class Test {
    private static final int len = 10;
    private static void init(int[] nums){
        Random random = new Random();
        for(int i = 0; i < nums.length; i++){
            nums[i] = random.nextInt(len);
        }
    }
    /**
     * 快速排序测试
     * @param nums
     */
    private static void QuickSortTest(int[] nums){
        System.out.println("QuickSort Test");
        init(nums);
        System.out.println(Arrays.toString(nums));
        QuickSort.quickSort1(nums, 0, nums.length);
        System.out.println(Arrays.toString(nums));
        System.out.println();
        init(nums);
        System.out.println(Arrays.toString(nums));
        QuickSort.quickSort2(nums, 0, nums.length);
        System.out.println(Arrays.toString(nums));
    }
    /**
     *  归并排序测试
     * @param nums
     */
    private static void MergeSortTest(int[] nums){
        System.out.println("MergeSort Test");
        init(nums);
        System.out.println(Arrays.toString(nums));
        MergeSort.mergeSort(nums, 0, nums.length);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 堆排序测试
     * @param nums
     */
    private static void HeapSortTest(int[] nums){
        System.out.println("HeapSort Test");
        init(nums);
        System.out.println(Arrays.toString(nums));
        HeapSort.heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    /**
     * 插入排序测试
     * @param nums
     */
    private static void InsertSortTest(int[] nums){
        System.out.println("InsertSort Test");
        init(nums);
        System.out.println(Arrays.toString(nums));
        InsertSort.insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 冒泡排序测试
     * @param nums
     */
    private static void BubbleSortTest(int[] nums){
        System.out.println("BubbleSort Test");
        init(nums);
        System.out.println(Arrays.toString(nums));
        BubbleSort.bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 选择排序测试
     * @param nums
     */
    private static void SelectSortTest(int[] nums){
        System.out.println("SelectSort Test");
        init(nums);
        System.out.println(Arrays.toString(nums));
        SelectSort.selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void main(String[] args) {
        int[] nums = new int[len];
//        QuickSortTest(nums);
//        MergeSortTest(nums);
        HeapSortTest(nums);
//        InsertSortTest(nums);
//        BubbleSortTest(nums);
//        SelectSortTest(nums);
    }
}
