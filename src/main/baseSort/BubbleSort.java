package baseSort;

import java.util.Arrays;

public class BubbleSort {
    private static void bubbleSort(int[] nums){
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = 0; j < nums.length -1 - i; j++){
                if(nums[j] > nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{6,5,2,4,3,1,0};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
