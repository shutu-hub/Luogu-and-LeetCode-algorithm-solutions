package Hot100;

public class L13 {

    public int maxSubArray(int[] nums) {
       int max=Integer.MIN_VALUE;
       int current=0;
        for (int num : nums) {
            current += num;
            max = Math.max(current, max);
            if (current < 0) {
                current = 0;
            }
        }
        return max;
    }

}
