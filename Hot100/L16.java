package Hot100;

import java.util.Arrays;

public class L16 {
    public static void main(String[] args) {
        int[] ints = productExceptSelf(new int[]{1,2,3,4});
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 思路：计算出该元素左边元素的乘积 * 该元素右边元素的乘积
     * 左前缀和 * 右后缀和
     * 在计算后缀和时，要倒着遍历，这样可以避开除法的计算，不会出现/0的情况
     * @param nums
     * @return
     */
//    public static int[] productExceptSelf(int[] nums) {
//        int[]prefix = new int[nums.length];
//        int[]sufix = new int[nums.length];
//        prefix[0]=1;
//        sufix[nums.length-1]=1;
//        for (int i = 1; i < nums.length; i++) {
//            prefix[i]=prefix[i-1]*nums[i-1];
//        }
//        for (int i = nums.length-2 ; i >=0 ; i--) {
//            sufix[i]=sufix[i+1]*nums[i+1];
//        }
//        for (int i = 0; i < nums.length; i++) {
//            nums[i]=prefix[i]*sufix[i];
//        }
//        return nums;
//    }

    public static int[] productExceptSelf(int[] nums) {
        // 将输出数组answer代替前缀数组
        int[]answer = new int[nums.length];
        answer[0]=1;
        for (int i = 1; i < nums.length; i++) {
            answer[i]=answer[i-1]*nums[i-1];
        }
        int r = 1;
        for (int i = nums.length-1; i >=0 ; i--) {
            answer[i]=answer[i]*r;
            r*=nums[i];
        }
        return answer;
    }
}
