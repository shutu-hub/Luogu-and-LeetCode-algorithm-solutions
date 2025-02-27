package PaiXu;

import java.util.Arrays;

public class LeetCode912 {
    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1, 4};
        int[] sortedNums = sortArray(nums);
        System.out.println(Arrays.toString(sortedNums));
    }
    public static int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }

    /**
     * 对nums数组中L-R区间的元素进行排序
     * 5 4 3    2 1
     *
     */
    public static void mergeSort(int[] nums, int l, int r){
        // 递归出口
        if (l>=r){
            return;
        }
        int mid=(l+r)>>1;
        mergeSort(nums,l,mid);
        mergeSort(nums,mid+1,r);
        // 对 L-R区间排序
        int[]tempArrays=new int[r-l+1];
        int index=0;
        int l1=l;
        int l2=mid+1;
        // 当左区间和右区间都有元素时 每次选出较小的放入临时数组
        while(l1<=mid && l2<=r){
            if (nums[l1]<=nums[l2]){
                tempArrays[index]=nums[l1];
                index++;
                l1++;
            }else{
                tempArrays[index]=nums[l2];
                index++;
                l2++;
            }
         }
        while (l1<=mid){
            tempArrays[index]=nums[l1];
            index++;
            l1++;
        }
        while (l2<=r){
            tempArrays[index]=nums[l2];
            index++;
            l2++;
        }
        for (int i = 0; i <tempArrays.length ; i++) {
            nums[l+i]=tempArrays[i];
        }
    }
}
