package main.baseSort;

/**
 * 归并排序区间左闭右开[)
 */
public class MergeSort {
    private static int[] temp = new int[100];
    public static void mergeSort(int[] nums, int left, int right){
        //只有一个数，直接返回
        if(left >= right - 1) return;
        int p = left, mid = left + (right - left) / 2, q = mid;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid, right);
        int t = left;
        while(p < mid || q < right){
            if(q >= right || nums[p] < nums[q]){
                temp[t++] = nums[p++];
            } else{
                temp[t++] = nums[q++];
            }
        }
        for(int i = left; i < right; i++){
            nums[i] = temp[i];
        }
    }
}
