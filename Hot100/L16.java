package Hot100;

import java.util.Arrays;

public class L16 {
    public static void main(String[] args) {
        int[] ints = productExceptSelf(new int[]{-1,1,0,-3,3});
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 思路：计算出该元素左边元素的乘积 * 该元素右边元素的乘积
     * 左前缀和 * 右后缀和
     * 在计算后缀和时，要倒着遍历，这样可以避开除法的计算，不会出现/0的情况
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        // 算出左边的乘积，右边的乘积
        int[] answer = new int[nums.length];
        // 第一位右边所有数的乘积
        int[]prefixSum=new int[nums.length];
        int[]sufixSum=new int[nums.length];
        prefixSum[0]=1;
        sufixSum[nums.length-1]=1;
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i]=prefixSum[i-1]*nums[i-1];
        }
        for (int i = nums.length-2; i>=0; i--) {
            sufixSum[i]=sufixSum[i+1]*nums[i+1];
        }
        for (int i = 0; i < nums.length; i++) {
            answer[i]=prefixSum[i]*sufixSum[i];
        }
        return answer;
    }
}
