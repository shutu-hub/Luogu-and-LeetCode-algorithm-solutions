package Hot100;

public class L89 {

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
    }

    /**
     * 解题思路：
     * 当前位置的最大值可能是前一个位置的最大值*当前值，也可能就是当前值，也可能是前一个位置的最小值（可能是负数）* 当前值出现负负得正，
     * 从三者中取最大值
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        long[] dpMax = new long[nums.length+1];
        long[] dpMin = new long[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            dpMax[i]=nums[i];
            dpMin[i]=nums[i];
        }
        int maxNum=nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpMax[i]=Math.max(dpMax[i-1]*nums[i],Math.max(nums[i],dpMin[i-1]*nums[i]));
            maxNum=Math.max(maxNum,(int)dpMax[i]);
            dpMin[i]=Math.min(dpMin[i-1]*nums[i],Math.min(nums[i],dpMax[i-1]*nums[i]));
        }
        return maxNum;
    }
}
