package baseSort;

import java.util.Arrays;

public class InsertSort {
    private static void insertSort(int[] nums){
        for(int i = 1; i < nums.length; i++){
            int temp = nums[i], j = i;
            while(j > 0 && nums[j - 1] > temp){
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{5,6,2,4,3,1,0};
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
