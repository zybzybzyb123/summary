package main.baseSort;

/**
 * 堆排序，左闭右开[)
 */
public class HeapSort {
    private static void swap(int[] nums, int i, int j){
        if(i == j) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    //调整堆
    private static void adjustHeap(int[] nums, int par, int sz){
        int temp = nums[par];
        //先指向左儿子
        int pos = 2 * par + 1;
        while(pos < sz){
            //如果右儿子存在并且比左儿子大，指向右儿子
            if(pos + 1 < sz && nums[pos + 1] > nums[pos]){
                pos++;
            }
            //如果父节点更大，不用调整堆，直接退出
            if(temp >= nums[pos]){
                break;
            }
            //更新父节点的值
            nums[par] = nums[pos];
            //调整子堆
            par = pos;
            pos = 2 * par + 1;
        }
        nums[par] = temp;
    }
    public static void heapSort(int[] nums){
        int sz = nums.length;
        //先初始化堆
        for(int i = (sz - 1) / 2; i >= 0; i--){
            adjustHeap(nums, i, sz);
        }
        //交换堆顶和堆尾节点，重新从堆顶调整堆
        for(int i = sz - 1; i > 0 ;i--){
            swap(nums, 0, i);
            adjustHeap(nums, 0, i);
        }
    }

}
