import baseSort.QuickSort;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static final int len = 10;
    private static void init(int[] nums){
        Random random = new Random();
        for(int i = 0; i < nums.length; i++){
            nums[i] = random.nextInt(len);
        }
    }
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
    public static void main(String[] args) {
        int[] nums = new int[len];
        QuickSortTest(nums);
    }
}
