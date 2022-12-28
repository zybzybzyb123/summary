package algorithm.dataStruct.baseSort;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序,左闭右开区间[)
 */
public class QuickSort {
    private static void swap(int[] nums, int i, int j){
        //同一位置不交换
        if (i == j) return;
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
    private static Random random = new Random();
    public static void quickSort1(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        /**
         * 这个是解决力扣卡边界case
         */
        int rand = random.nextInt(right - left + 1) + left;
        swap(nums, rand, right);
        int temp = nums[right];
        /**
         * 这个算法用左端点作为基准比较trick，改为用右端点为基准
         */
        int i = left, j = left;
        while (j < right) {
            if (nums[j] < temp) {
                // 用右端点可以避免i溢出，最极限出现在right的位置
                swap(nums, i++, j);
            }
            j++;
        }
        swap(nums, right, i);
        quickSort1(nums, left, i - 1);
        quickSort1(nums,  i + 1, right);
    }
    /**
     * 快速排序挖洞填坑法
     * @param nums
     * @param left
     * @param right
     */
    public static void quickSort2(int[] nums, int left, int right){
        if (left >= right - 1) return;
        int temp = nums[left];
        int i = left, j = right - 1;
        while (i < j){
            //扫描时必须有一个取等号,不然遇到和基准相同的值时会陷入死循环
            while (i < j && nums[j] >= temp){
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= temp){
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = temp;
        quickSort2(nums, left, i);
        quickSort2(nums, i + 1, right);
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 2, 4, 1, 6};
//        int[] nums = {5, 2, 3, 1, 6};
        QuickSort.quickSort1(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
