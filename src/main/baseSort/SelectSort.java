package baseSort;

import java.util.Arrays;

public class SelectSort {
    private static void selectSort(int[] nums){
        for(int i = 0; i < nums.length; i++){
            int pos = i;
            for(int j = i; j < nums.length; j++){
                if(nums[pos] > nums[j]){
                    pos = j;
                }
            }
            if(i != pos){
                int temp = nums[pos];
                nums[pos] = nums[i];
                nums[i] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{6,5,2,4,3,1,0};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
