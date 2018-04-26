package main.baseSort;

public class InsertSort {
    public static void insertSort(int[] nums){
        for(int i = 1; i < nums.length; i++){
            int temp = nums[i], j = i;
            while(j > 0 && nums[j - 1] > temp){
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }
}
