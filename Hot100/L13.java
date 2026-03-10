package Hot100;

public class L13 {

    /**
     * 最长连续和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int cur=0;
        for (int num : nums) {
            cur+=num;
            max=Math.max(cur,max);
            if (cur<0){
                cur=0;
            }
        }
        return max;
    }

}
