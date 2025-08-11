package Hot100;

import java.util.Arrays;

public class L15 {

    public static void main(String[] args) {
        rotate(new int[]{-1},2);
    }

    /**
     * nums中元素向右移动k个位置
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        int[]numsNew=new int[nums.length];
        int n = nums.length;
        // numsNew是nums向右移动k个位置的数组
        for (int i = 0; i < nums.length; i++) {
            numsNew[(i+k) % n]=nums[i];
        }
        System.arraycopy(numsNew, 0, nums, 0, nums.length);
    }
}
