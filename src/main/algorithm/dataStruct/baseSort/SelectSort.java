package algorithm.dataStruct.baseSort;


public class SelectSort {
    public static void selectSort(int[] nums){
        for (int i = 0; i < nums.length; i++){
            int pos = i;
            for (int j = i; j < nums.length; j++){
                if(nums[pos] > nums[j]){
                    pos = j;
                }
            }
            if (i != pos){
                int temp = nums[pos];
                nums[pos] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
